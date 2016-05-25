package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// INIT
		case "initialize":
			
			int amount = Integer.parseInt(request.getParameter("playerAmount"));
			gameEngine.initAmountPlayers(amount);
			gameEngine.initCards(Integer.parseInt(request.getParameter("set"))); 
			for (int i = 1; i <= amount; i++) {
				gameEngine.initPlayer(i, request.getParameter("name" + i));
			}
			gameEngine.init();
			break;
		case "load":			
			int gameID = Integer.parseInt(request.getParameter("gameID"));
			gameEngine.loadGame(gameID);
			break;
		case "getGameState":
			response.getWriter().write("{\"gameOver\" : " + gameEngine.isGameOver() + "}");
		// GETTERS
			break;
		case "getBoard":
			List<String> board = new ArrayList<>();

			for (Pile pile : gameEngine.getBoard().getPiles()) {
				if (pile.isPileEmpty()){
					board.add(pile.getName() + ";0");
					
				} else {
					board.add(pile.getFromIndex(0).getName() + ";" + pile.getAmount());
				}
			}
			String jsonBoard = new Gson().toJson(board);
			response.getWriter().write(jsonBoard);
			break;
		case "getHand":
			List<String> list = new ArrayList<>();
			list = gameEngine.getCurrentPlayer().getHand().getCardsName();
			String json = new Gson().toJson(list);

			response.getWriter().write(json);
			break;
//		case "getSelectableHand":
//			List<String> selectable = new ArrayList<>();
//			list = gameEngine.getCurrentPlayer().getPickedHand().getCardsName();
//			String selectableJson = new Gson().toJson(selectable);
//
//			response.getWriter().write(selectableJson);
//			break;	
		case "getPlayingField":
			List<String> playingFieldList = new ArrayList<>();
			playingFieldList = gameEngine.getCurrentPlayer().getPlayingField().getCardsName();
			String playingFieldJson = new Gson().toJson(playingFieldList);

			response.getWriter().write(playingFieldJson);
			break;
		case "getPlayerInfo":
			String playerInfo = "{\"player\":\"" + gameEngine.getCurrentPlayer().getName() + "\", \"turn\":\""
					+ gameEngine.getTurnNumber() + "\" , \"coins\":\"" + gameEngine.getCurrentTurnSegment().getCoin()
					+ "\" , \"actions\":\"" + gameEngine.getCurrentTurnSegment().getAction() + "\" , \"buys\":\""
					+ gameEngine.getCurrentTurnSegment().getBuy() + "\"}";

			response.getWriter().write(playerInfo);
			break;
		case "getSpecialAction":
			String specialActionInfo = "Player = [";
			for (int i= 0; i < 1; i++){
				String Hand = new Gson().toJson(gameEngine.getPlayer(1).getHand().getCardsName());
				specialActionInfo += "{\"Hand\"" + ":" + Hand + "}";
			}
//				specialActionInfo.substring(0, specialActionInfo.length() - 1);
				specialActionInfo += "]" ;
				
			response.getWriter().write(specialActionInfo);
			break;	
		case "getAllCards":
			List<String> allCards = new ArrayList<>();

			for (Card card : gameEngine.getAllCards()) {
				String cardName = card.getName();
				String cardType = card.getType();
				if (!("Victory".equals(cardType) || "Treasure".equals(cardType))) {
					allCards.add(cardName);
				}
			}
			String jsonCards = new Gson().toJson(allCards);
			response.getWriter().write(jsonCards);
			break;
		case "getCurrentPlayer":
			response.getWriter().write("{\"currentPlayer\" : " + gameEngine.getPlayerCounter() + "}");
			break;
		// ACTIONS
		case "playCard":
			String card = request.getParameter("card");

			String[] effect = request.getParameterValues("effect[]");

			Pile selectedHand = new Pile();
			if (effect != null) {
				for (String cardName : effect) {
					selectedHand.add(gameEngine.CallCard(cardName));
				}
			}
			gameEngine.playCard(card);
//			JSONObject obj = new JSONObject(request.getParameter("effect"));
//
//			System.out.println(obj.get("player1"));
//			System.out.println(request.getQueryString());
			break;

		case "buyCard":
			String buyCard = request.getParameter("card");
			gameEngine.buyCard(gameEngine.CallCard(buyCard));
			break;
		case "buyInstancedCard":
			String buyInstancedCard = request.getParameter("card");
			//gameEngine.buyInstancedCard(gameEngine.CallCard(buyInstancedCard));
			break;	
		case "nextSegment":
			gameEngine.CleanedUp();
			if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayers()) {
				gameEngine.nextTurn(8); // integer needed? maybe saves?
			}
			gameEngine.nextPlayer();
			break;
		// EXTRA
		case "spawnCard":
			String spawnCard = request.getParameter("card");
			gameEngine.getCurrentPlayer().getHand().add(gameEngine.CallCard(spawnCard));
			break;
		case "information":
			writer.append("Hand " + gameEngine.getCurrentPlayer().getHand() + "\n" + "Deck "
					+ gameEngine.getCurrentPlayer().getDeck() + "\n" + "PlayingField "
					+ gameEngine.getCurrentPlayer().getPlayingField() + "\n" + "Discard"
					+ gameEngine.getCurrentPlayer().getDiscardPile() + "\n" + gameEngine.CallCard("Copper") + " "
					+ gameEngine.CallCard("Copper"));
			break;
		case "emptyPiles":
			gameEngine.getBoard().getFromIndex(12).remove(gameEngine.CallCard(12));
			gameEngine.getBoard().getFromIndex(13).remove(gameEngine.CallCard(13));
			gameEngine.getBoard().getFromIndex(14).remove(gameEngine.CallCard(14));
			break;
		case "emptyProvince":
			gameEngine.getBoard().getFromIndex(6).remove(gameEngine.CallCard("Province"));
			break;
		case "calcVictory":
			
			if(gameEngine.getCurrentPlayer().getVictoryPoints()==0){
				gameEngine.calcVictory();
			}
			Map<String,Integer> players = new LinkedHashMap<String, Integer>();
			
			for (int i = 1; i <= gameEngine.getMaxPlayers();i++){
				players.put(gameEngine.getPlayer(i).getName(), gameEngine.getPlayer(i).getVictoryPoints());
			}
			
			String playerData = new Gson().toJson(players);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(playerData);
			break;
			
		default:
			writer.append("error: Something went wrong :(");
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
