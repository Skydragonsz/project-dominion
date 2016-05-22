package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

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
		
			
		String operation;
		operation = request.getParameter("operation");

		switch (operation) {
		case "initialize":
			gameEngine.initCards();
			System.out.println("Init case");
			int amount = Integer.parseInt(request.getParameter("playerAmount"));
			gameEngine.initAmountPlayers(amount);

			for (int i = 1; i <= amount; i++) {
				gameEngine.initPlayer(i, request.getParameter("name" + i));
			}
			//gameEngine.init();
			break;
		case "getHand":
			System.out.println("Hand case");
			List<String> list = new ArrayList<>();
			list = gameEngine.getCurrentPlayer().getHand().getCardsName();
			String json = new Gson().toJson(list);

			response.getWriter().write(json);
			break;
		case "getPlayingField":
			System.out.println("Hand case");
			List<String> playingFieldList = new ArrayList<>();
			playingFieldList = gameEngine.getCurrentPlayer().getPlayingField().getCardsName();
			String playingFieldJson = new Gson().toJson(playingFieldList);

			response.getWriter().write(playingFieldJson);
			break;		
		case "getBoard":
			System.out.println("Board case");
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
			System.out.println("player info case");
			String playerInfo = "{\"player\":\"" + gameEngine.getCurrentPlayer().getName() + "\", \"turn\":\""
					+ gameEngine.getTurnNumber() + "\" , \"coins\":\"" + gameEngine.getCurrentTurnSegment().getCoin()
					+ "\" , \"actions\":\"" + gameEngine.getCurrentTurnSegment().getAction() + "\" , \"buys\":\""
					+ gameEngine.getCurrentTurnSegment().getBuy() + "\"}";

			response.getWriter().write(playerInfo);
			break;
		case "getAllCards":
			System.out.println("AllCard case");
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
			System.out.println("Play case");
			String card = request.getParameter("card");
	    	System.out.print("\n" + gameEngine.getAllCards() + "\n");
	    	System.out.print("Een kaart in playCard -- Servlet: " + card  + "\n");
			gameEngine.playCard(card);
			
			break;
			
		case "buyCard":
			System.out.println("Buy case");
			String buyCard = request.getParameter("card");
			gameEngine.buyCard(gameEngine.CallCard(buyCard));
			break;
		case "information":
			writer.append("Hand " + gameEngine.getCurrentPlayer().getHand() + "\n" + "Deck "
					+ gameEngine.getCurrentPlayer().getDeck() + "\n" + "PlayingField "
					+ gameEngine.getCurrentPlayer().getPlayingField() + "\n" + "Discard"
					+ gameEngine.getCurrentPlayer().getDiscardPile() + "\n"
					+ gameEngine.CallCard("Copper")
					+ " " + gameEngine.CallCard("Copper"));
			break;
		case "nextSegment":
        	gameEngine.CleanedUp();
			if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayers()){
				gameEngine.nextTurn(8); //integer needed? maybe saves?
			}
				gameEngine.nextPlayer();
		default:
			writer.append("error: Something went wrong :(");
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
