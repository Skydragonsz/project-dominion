package gameconsole;

import dominion.GameEngine;
import dominion.Pile;
import dominion.Player;
import dominion.TurnSegment;

import java.util.Scanner;

public class GameConsole {

    private GameEngine gameEngine;
    Scanner scanner = new Scanner(System.in); // NEEDED (?)
    
    private int TurnCounter = 1;
    private boolean endPlayerTurn = false; //TEMP
    
    // For cleaner code
    private Player currentPlayer;
    private Pile currentDeck;
    private Pile currentHand;
    private Pile currentPlayingField;
    private Pile currentDiscardPile;
    private TurnSegment currentTurnSegment;

//START-UP
    public static void main(String[] args) {
        GameConsole consoleGame = new GameConsole();
        consoleGame.run();
    }

    public GameConsole() {
        gameEngine = new GameEngine();
        gameEngine.initCards(); //DIFFRENT PLACE?
    }

    public void run() {
        Layout.drawLogo();
        Layout.drawMenuAlphabeticList("Main menu", "New game", "Load Game", "show (card) sets", "Help", "Exit game");
        handleMainMenuAction(Actions.askFor("Choice an option"));
    }
    
    //START-UP -- GAMELOOP
    public void gameLoop() {
        boolean bln = true; //TEMP
        gameEngine.nextTurn(TurnCounter); //first turn
        while (bln = true) //gameEngine.gameNotFinished()
        {   
        	setCurrentPlayer();
        	printCurrentSituation();

            System.out.print("[ ACTIONS ] What action would you like to perform:\t");
            String option = scanner.nextLine();

            handlePlayerAction(option);
            
            if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayers()) {
            	TurnCounter++;
            	gameEngine.nextTurn(TurnCounter);
            } if (CurrentPlayerWantsToEndTurn())
                initNewPlayerTurn();
            
            	gameEngine.nextPlayer();
        }
    }
    
    //GAMELOOP -- PLAYER INFO
    public boolean CurrentPlayerWantsToEndTurn() {
        return endPlayerTurn;
    }

    public void endPlayerTurn() {
        this.endPlayerTurn = true;
    }

    public void initNewPlayerTurn() {
        this.endPlayerTurn = false;
    }
    
    public void setCurrentPlayer(){
        currentPlayer = gameEngine.getCurrentPlayer();
        currentDeck = currentPlayer.getDeck();
        currentHand = currentPlayer.getHand();
        currentPlayingField = currentPlayer.getPlayingField();
        currentDiscardPile = currentPlayer.getDiscardPile();
    }
    
//HANDLE
    //HANDLE -- SWITCH
    public void handleMainMenuAction(String action) {

        switch (action.toUpperCase()) {
            case "A":						 // A: (Start) New game
                printMatchSettings();
                gameLoop();
                break;
            case "B":                        // B: Load game
                //gameEngine.load();
            	System.out.println("WIP");
                break;
            case "C":                        // C: Shows sets
            	System.out.println("WIP -- Gets sets from database");
                break;
            case "D":                        // D: Help / info
            	System.out.println("WIP -- Extra help (needed?)");
                break;
            case "E":                        // E: Exit game
            	System.out.println("Quit game");
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                handleMainMenuAction(Actions.askFor("Choice an option"));
                break;
        }
    }
    
    public void handleMatchSettings(String action) {
        switch (action.toUpperCase()) {
            case "A":						 // 1: 
                break;
            case "B":                        // 2:
                break;
            case "C":                        // 3:
                break;
            case "D":                        // 4:
                break;
            case "E":                        // 5:
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
    }
    
    public void handlePlayerAction(String action) {
        switch (action.toUpperCase()) {
            case "A":                       // A: Play a card
                //TODO: Geld kan altijd gespeeld worden!
                if (1 > 0) handlePlayCard(); //TEMP 1
                break;

            case "B":                      // B: Buy a card
                if (1 > 0) handleBuyCard();  //TEMP 1
                break;
            case "C":                     // C: print all cards on board (Victory, Kingdom, Treasure)
                printAllCards();
                System.out.print("Press ENTER to continue...");
                scanner.nextLine();
                break;
            case "E":                     // C: print all cards on board (Victory, Kingdom, Treasure)
            	endPlayerTurn();
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
    }
    
    //HANDLE -- ACTION
    public void handlePlayCard() {
        int option = Integer.parseInt(Actions.askFor("[ ACTIONS -- PLAY CARD ] What card would you like to play"));
        gameEngine.playCard(currentHand.getFromIndex(option - 1), gameEngine);
        currentPlayingField.addFrom(currentHand.getFromIndex(option - 1), currentHand); // This will need to be moved.
    }

    public void handleBuyCard() {
        printAllCards();
        
        int option = Integer.parseInt(Actions.askFor("[ ACTIONS -- BUY CARD ] What card would you like to buy"));
        
        if (gameEngine.getCurrentTurnSegment().getCoin() >= gameEngine.getBoard().getFromIndex(option - 1).getFromIndex(0).getCost()){
        	currentPlayer.getDiscardPile().addAmountOfCardsFrom(1, gameEngine.getBoard().getFromIndex(option - 1));
        	gameEngine.getCurrentTurnSegment().removeBuy(1);
        	//System.out.print(gameEngine.getCurrentTurnSegment() + gameEngine.getCurrentTurnSegment().getCoin());
        } else {
        	System.out.print("You do not have enough coins");
        
        }
    }

//SETTERS    
    public void setPlayerNames(int amount) {
        for (int i = 1; i <= amount; i++) {
            System.out.print("Player " + i + "'s name" + ":\t");
            String name = scanner.nextLine();
            gameEngine.initPlayer(i, name);
        }
    }

//PRINTERS
    public void printCurrentSituation() {
    	
        //ACTIONS = A B C; CURRENT TURN = None; HAND = 1 2 3; PLAYING FIELD = none;    
        Layout.drawTitel("PLAYER " + currentPlayer.getName() 							// PLAYER PIETER-JAN
        			 + " -- TURN " + gameEngine.getCurrentTurn().getCurrentTurnNumber() // TURN 6
        			 + " -- SEGMENT " + gameEngine.getPlayerCounter());			 		// SEGMENT 3  (PlayerCounter = SegmentNumber)
        
        Layout.drawSubTitel(currentPlayer.getName() + "'S INFORMATION"); //PIETER-JAN'S INFORMATION
        
        Layout.drawMenuAlphabeticList("Actions", "Play Card", "Buy Card", "print current board", "Search card info", "End Turn"); /* <- Parameter STRINGS is printed in a list */
        
		System.out.println(gameEngine.getCurrentTurnSegment());
		System.out.println(gameEngine.getCurrentTurnSegment().getCoin());
        
        Layout.drawMenuNoList("Current turn", 												// Current turn
        					  "Coin(s): " + gameEngine.getCurrentTurnSegment().getCoin(),			// Coin(s): 2
        					  "Action(s): " + gameEngine.getCurrentTurnSegment().getAction() ,  	// Action(s): 1
        					  "Buy(s): " +  gameEngine.getCurrentTurnSegment().getBuy());			// Buy(s): 1

        System.out.println("H " + currentHand.getCardsName());
        System.out.println("D " + currentDeck.getCardsName());
        System.out.println("DP " + currentDiscardPile.getCardsName());
        Layout.drawMenuNumericList("Your Cards", currentHand.getPile()); /* <- Gets cards [name] from the HAND which is then printed in a list */
        Layout.drawMenuNoList("Playing Field", currentPlayingField.getPile());/* <- Gets cards from the FIELD which is then printed in a list */
    }

    public void printAllCards() {
        Layout.drawSubTitel("Card available on board");
        //Layout.drawMenuNumericList("Board", gameEngine.getAllCards()); /* <- Gets the chosen KINGDOM SET which is then printed in a list */
        Layout.drawBoard("Board", gameEngine.getBoard().getPiles());
    }

    public void printMatchSettings() {
        Layout.drawTitel("Match Settings");
        Layout.drawSubTitel("Players");

        int amount = Integer.parseInt(Actions.askFor("How many players"));
        gameEngine.initAmountPlayers(amount);
        setPlayerNames(amount);
        
        Layout.drawSubTitel("Kingdom Set");
        Layout.drawMenuAlphabeticList("Kingdom Sets", "Custom set", "Random", "First game", "Big Money", "Interaction", "Size Distortion", "Village Square");
        System.out.print("Pick a set:\t");
        String set = scanner.nextLine();

        printAllCards();
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
