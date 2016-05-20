package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dominion.*;
import dominion.Turn;

/**
 * Servlet implementation class DominionServlet
 */
@WebServlet("/DominionServlet")
public class DominionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public DominionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer writer = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		GameEngine gameEngine = (GameEngine) request.getServletContext().getAttribute("gameEngine");
		if (gameEngine == null) {
			gameEngine = new GameEngine();
			request.getServletContext().setAttribute("gameEngine", gameEngine);
		}

		gameEngine.initCards();
		String operation;
		operation = request.getParameter("operation");

		switch (operation) {
		case "initialize":
			int amount = Integer.parseInt(request.getParameter("playerAmount"));
			gameEngine.initAmountPlayers(amount);

			for (int i = 1; i <= amount; i++) {
				gameEngine.initPlayer(i, request.getParameter("name" + i));
			}
			break;
		case "getHand":
			List<String> list = new ArrayList<>();
			list = gameEngine.getCurrentPlayer().getHand().getCardsName();
			String json = new Gson().toJson(list);

			response.getWriter().write(json);
			break;
		case "getBoard":
			List<String> board = new ArrayList<>();

			for (Pile pile : gameEngine.getBoard().getPiles()) {
				board.add(pile.getFromIndex(0).getName() + ";" + pile.getAmount());
			}
			String jsonBoard = new Gson().toJson(board);

			response.getWriter().write(jsonBoard);
			break;
		case "showBoard":
			writer.append("{ \"card\":\"Village\" } ");
			break;
		case "getPlayerInfo":
			String playerInfo = "{\"player\":\"" + gameEngine.getCurrentPlayer().getName() + "\", \"turn\":\""
					+ gameEngine.getTurnNumber() + "\" , \"coins\":\"" + gameEngine.getCurrentTurnSegment().getCoin()
					+ "\" , \"actions\":\"" + gameEngine.getCurrentTurnSegment().getAction() + "\" , \"buys\":\""
					+ gameEngine.getCurrentTurnSegment().getBuy() + "\"}";

			response.getWriter().write(playerInfo);
			break;
		case "getAllCards":
			List<String> allCards = new ArrayList<>();

			for (Card card : gameEngine.getAllCards()){
				String cardName = card.getName();
				String cardType = card.getType();
				if(!("Victory".equals(cardType) || "Treasure".equals(cardType))){
					allCards.add(cardName);
				}
			}
			String jsonCards = new Gson().toJson(allCards);

			
			response.getWriter().write(jsonCards);
			break;
		case "playCard":
			String card = request.getParameter("card");
			gameEngine.playCard(GameEngine.CallCard(card));
			break;
			
		case "buyCard":
			String buyCard = request.getParameter("card");
			gameEngine.buyCard(GameEngine.CallCard(buyCard));
			break;
		case "information":
			writer.append("Hand " + gameEngine.getCurrentPlayer().getHand() + "\n" + "Deck "
					+ gameEngine.getCurrentPlayer().getDeck() + "\n" + "PlayingField "
					+ gameEngine.getCurrentPlayer().getPlayingField() + "\n" + "Discard"
					+ gameEngine.getCurrentPlayer().getHand() + "\n");
			break;
		default:
			writer.append("error: jsdffsdkljsdfjlfd");
			break;
		}		
		
//		GameEngine gameEngine = (GameEngine) request.getServletContext().getAttribute("gameEngine");
//		if(gameEngine == null)
//		{
//			gameEngine = new GameEngine();
//			request.getServletContext().setAttribute("gameEngine", gameEngine);
//			
//		}
//
//		
//		// gameEngine is globaal
//		// en je ajax call zou moeten vermelden (via url parameters ?...&...)
//		// welke speler iets doet en welke kaart hij manipuleert.
//		// zodat je gameEngine.getPlayer(  PARAM PLAYER ) .getCard(  PARAM CARD ID )
//				
//		writer.append("Kindly served by Tomcat at: " + gameEngine.getCurrentPlayer());
//		//writer.append(request.getContextPath());
//		
//		//writer.append("\n");
//		
//		//writer.append("Hello world");

////			writer.append(playerName1);
////			writer.append("\", \"name2\":\"");
////			writer.append(playerName2);
////			writer.append("\" }");
////			
////			
//			gameEngine.initialize();
//			
//			
//			
//			break;
//			
//		case "draw":
//			int cardNumber =  Integer.parseInt(request.getParameter("cardNumber"));
//			
//			writer.append("{ \"status\":\"OK\", \"cardNumber\":");
//			writer.append(Integer.toString(cardNumber));
//			writer.append(" }");
//		
//			//   { 'naam':'Jonas' }
//			
//			break;
//
//		
//	}
//	
		
//		 response.setContentType("text/html");
//		 response.setCharacterEncoding("utf-8");
//		 PrintWriter out = response.getWriter();
//		 out.println("<html><body>Hello World. Dit is een test!</body></html>");
//		 System.out.println("ik heb gewerkt...");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
