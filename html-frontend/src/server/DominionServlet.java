package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominion.*;

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
//		response.setContentType("application/json");
//		

		GameEngine gameEngine = new GameEngine();
		
		gameEngine.initCards();
		
		
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
//		
		Writer writer = response.getWriter();
////		
//		writer.append("Kindly served by Tomcat at: " + gameEngine.getCurrentPlayer());
//		//writer.append(request.getContextPath());
//		
//		//writer.append("\n");
//		
//		//writer.append("Hello world");
//		
		String operation;
		
		operation = request.getParameter("operation");
		
		
		
		switch(operation)
		{
		case "initialize":
		
			int amount = Integer.parseInt(request.getParameter("playerAmount"));
			gameEngine.initAmountPlayers(amount);
			for (int i = 1; i < amount; i++)
			{
				gameEngine.initPlayer(i, request.getParameter("name" + i));
				
			}
			break;
			
//			Writer writer = response.getWriter();
////			
//			writer.append("Kindly served by Tomcat at: " + gameEngine.getCurrentPlayer());
		
////			writer.append("{ \"status\":\"OK\", \"name1\":\"");
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
		default:
			writer.append("{ \"status\":\"NOK\", \"errormessage\":\"Invalid operation\" }" );
			break;
		}
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
