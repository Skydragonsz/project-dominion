/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominionconsole;
import java.util.Scanner;
import dominion.*;
/**
 *
 * @author Quint
 */

       public class GameConsole
       {
	   private Dominion gameEngine;
	   private int nrPlayers;
           Scanner scanner = new Scanner(System.in);

           //TODO delete deze functie later 
           public void dezeFunctieBestaatAlleenMaarOmDeCommentaarHierinTeVerbergen(){ 
//1. Een voor de desktop client / console client
//  -> gewoon java-programma
//  -> eventueel grafisch (windows forms, Swing, ...) --> ga ik hier niet op in (zie bijles dhr Theben Tervile)
//
//  -> of : console
//
//       Welcome to Dominion
//       -------------------
//       Enter nr players:   ___			2
//       Player 1 enter name:  _______   Jonas
//       Player 2 enter name:  _______   Rudy
//
//       Player 1 turn 1
//       ---------------
//       On table:
//        - kaart 1    naam van kaart, cost , ..
//        - kaart 2
//        - kaart 3
//       In your hand:
//        - kaart 1    naam van kaart, cost , ..
//        - kaart 2
//        - kaart 3
//       Money:  xxxxx 
//
//       Please pick your action: 
//	1. draw card
//	2. play one of your cards
//	3. ...
//
//
//
//
//       Player 2 turn 1
//       ---------------
//
//
//       System.out.println(".....")
//
//
//       .....
//
//
//       Scanner    om zaken te vragen (bv int lezen 1 2 of 3 bij het keuzescherm Please pick your action)
//
//       !! TODO voorbeeld tonen
}

	   public static void main(String[] args){
		GameConsole consoleGame = new GameConsole();

		consoleGame.run();
           }

	   public GameConsole(){
		gameEngine = new Dominion();
		nrPlayers = 2;
           }

	   public void run(){
System.out.println( "    *                             |>>>                    +\n" +
                    "+          *                      |                   *       +\n" +
                    "                    |>>>      _  _|_  _   *     |>>>\n" +
                    "           *        |        |;| |;| |;|        |                 *\n" +
                    "     +          _  _|_  _    \\\\.    .  /    _  _|_  _       +\n" +
                    " *             |;|_|;|_|;|    \\\\: +   /    |;|_|;|_|;|\n" +
                    "               \\\\..      /    ||:+++. |    \\\\.    .  /           *\n" +
                    "      +         \\\\.  ,  /     ||:+++  |     \\\\:  .  /\n" +
                    "                 ||:+  |_   _ ||_ . _ | _   _||:+  |       *\n" +
                    "          *      ||+++.|||_|;|_|;|_|;|_|;|_|;||+++ |          +\n" +
                    "                 ||+++ ||.    .     .      . ||+++.|   *\n" +
                    "+   *            ||: . ||:.     . .   .  ,   ||:   |               *\n" +
                    "         *       ||:   ||:  ,     +       .  ||: , |      +\n" +
                    "  *              ||:   ||:.     +++++      . ||:   |         *\n" +
                    "     +           ||:   ||.     +++++++  .    ||: . |    +\n" +
                    "           +     ||: . ||: ,   +++++++ .  .  ||:   |             +\n" +
                    "                 ||: . ||: ,   +++++++ .  .  ||:   |        *\n" +
                    "                 ||: . ||: ,   +++++++ .  .  ||:   | \n");

System.out.println( "              ____                  _       _           \n" +
"             / __ \\____  ____ ___  (_)___  (_)___  ____ \n" +
"            / / / / __ \\/ __ `__ \\/ / __ \\/ / __ \\/ __ \\\n" +
"           / /_/ / /_/ / / / / / / / / / / / /_/ / / / /\n" +
"          /_____/\\____/_/ /_/ /_/_/_/ /_/_/\\____/_/ /_/ \n");

                DrawMenu("MAIN MENU","Start game","Help", "Exit game", "Retry", "Load deck", "DEV");
                

                System.out.print("Choice an option:\t");
                String option = scanner.nextLine();
                
                System.out.print("PICKED" + option);
		nrPlayers = askNrPlayers();
		//gameEngine.setNrPlayers(nrPlayers);
                
                
                //VV Functie met for loop met aantal spelers VV
		//gameEngine.setPlayer(0, "jos");
		//gameEngine.setPlayer(1, "rudy");
                
                
//              gameEngine.init();
//		gameLoop();
           }

	   public int askNrPlayers(){
               return 2;
 	   }
	   
	   public void gameLoop(){
//
//		while(gameEngine.gameNotFinished())
//		{
//
//			 stap 1: toon de situatie : wie is er aan de beurt?
//			 welke kaarten heb je in je hand ?
//			 wat ligt er op tafel?
//			 welke zetten zijn nu mogelijk?
//			 hoeveel geld heb je?
//			showCurrentSituation();
//
//			int action = askPlayerAction();				// 1 = draw card ; 2 = ... ; ....
//
//			handlePlayerAction(action);		// gaat werken met gameEngine
//
//		}
//
	   }
//
	   public void handlePlayerAction(int action){
           
//	   
//		switch(action)
//		{
//			case 1:				// 1 was: draw a card
//				handleDrawCard();
//				break;
//			
//			case 2:
//				break;
//
//			default:
//				break;
//		}
//
	   }
//
	   public void handleDrawCard(){
//	   
//		GameEngine.drawCard();
	   }
//
	   public void showCurrentSituation(){
//               
           }
           
           
           //LAYOUT
           public  void DrawMenu(String title, String... lines) {
               System.out.println(
                    "╔══════════════╗\n" +
                    "║       "+ title.toUpperCase() +"      ║\n" +
                    "╠══════════════╣" );
               for (String line : lines) {
                   int lineLength = (22 - (line.length()+ 3));
                     System.out.println(
                    "║ 1."+ line + CalculateSpaces(lineLength) + "║");
                                    }
                System.out.println(
                    "╚══════════════╝");
           }           
           public String CalculateSpaces(int amount){
           String BlankSpace ="";
               for (int i=0; i < amount; i++){
           BlankSpace += " ";
           }
           return BlankSpace;
           }
       }


//    2. Engine classes
//
//
//        public class GameEngine			// heet gameEngine in ons eerste project
//        {
//
//            Player[] players = new Player[2];
//
//            public GameEngine()		// constructor
//            {
//            }
//
//            public void setPlayer(int playerIdx, String name)
//            {
//                    players[playerIdx] = new Player(name);
//            }
//
//        }
//
//        public class Player
//        {
//            private String name;
//
//            private int amountMoney;
//
//            private List hand;
//            private List table;
//
//            public Player(String name)
//            {
//                    this.name = name;
//
//                    this.hand = new LinkedList();
//                    this.table = new LinkedList();
//            }
//        }
//
//        public class Card
//        {
//            int type;			// 0 = action 1 = landarea 2 = ...
//            String name;			// "victory daaa"
//
//            public Card(int type, String name)
//            {
//                    this.type = type;
//                    this.name = name;
//            }
//
//
//        }




