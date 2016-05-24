package gameconsole;



import dominion.Card;
import dominion.GameEngine;
import dominion.Pile;
import dominion.Player;
import dominion.TurnSegment;

import java.util.Scanner;

public class GameConsole {

    private GameEngine gameEngine;
    Scanner scanner = new Scanner(System.in);
    
    private int TurnCounter = 1;
    private boolean endPlayerTurn = false;
    
    // For cleaner code
    private Player currentPlayer;
    private Pile currentDeck;
    private Pile currentHand;
    private Pile currentPlayingField;
    private Pile currentDiscardPile;
    private Pile currentSelectedHand;
    private Pile currentPickedHand;
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
        handleMainMenuAction(Actions.askFor("Choose an option"));
    }
    
    //START-UP -- GAMELOOP
    public void gameLoop() {
        boolean isNotEnding = true; //TEMP
        while (isNotEnding == true) //gameEngine.gameNotFinished()
        {   
        	setCurrentPlayer();
        	printCurrentTurn();

            handlePlayerAction(Actions.askFor("[ ACTIONS ] What action would you like to perform:\t"));
            
            if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayers()) {
            	TurnCounter++;
            	gameEngine.nextTurn(TurnCounter);
                initNewPlayerTurn();
            	gameEngine.nextPlayer();
            } else if(CurrentPlayerWantsToEndTurn()){
                initNewPlayerTurn();
            	gameEngine.nextPlayer();
        }
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
        currentSelectedHand = currentPlayer.getSelectedHand();
        currentPickedHand = currentPlayer.getPickedHand();
        currentPlayingField = currentPlayer.getPlayingField();
        currentDiscardPile = currentPlayer.getDiscardPile();
        gameEngine.setCurrentDiscardPile();
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
    
    public void handleSpecialActionLayout(Card card) {
        
    	String pressedKey = "";
    	currentPickedHand.getPile().clear();
    	currentPickedHand.copyAllFrom(currentHand);
    	currentPickedHand.remove(card);
    	currentSelectedHand.getPile().clear();
    	
    	switch (card.getName()) {
		case "Cellar":
	    	while (!"E".equals(pressedKey)){
	        Layout.drawSubTitel("Select cards");
	        Layout.drawMenuNumericList("Your Cards", currentPickedHand.getPile());
	        Layout.drawMenuNoList("selected cards", currentSelectedHand.getPile());
	        
	        handleSelectedCard();
	        pressedKey = Actions.askFor("Press any key to continue | press E to exit");
	    	}
			break;
		case "Chapel":
			int i = 0;
			while (!"E".equals(pressedKey) || i <= 4){
		        Layout.drawSubTitel("Discard cards");
		        Layout.drawMenuNumericList("Your Cards", currentPickedHand.getPile());
		        Layout.drawMenuNoList("selected cards", currentSelectedHand.getPile());
		        
		        handleSelectedCard();
		        pressedKey = Actions.askFor("Press any key to continue | press E to exit");
		        i++;
		    	}
			break;
		case "Workshop":
			Layout.drawSubTitel("Choose a card costing up to 4");
			Layout.drawMenuPurchasableCards("Choose one card costing up to 4", gameEngine.getBoard().getPiles(), 4);
			//Layout.drawBoard("Choose one card costing up to 4", gameEngine.getBoard().getPiles()); --> Resultaat NullPointerException
			System.out.println("Instanced Coins: " + currentTurnSegment.getInstancedCoin()); //--> Resultaat 0
			//System.out.println("Instanced Coins: " + gameEngine.getCurrentTurnSegment().getInstancedCoin());
			handleGainInstancedCard();
			//System.out.println("Instanced Coins: " + currentTurnSegment.getInstancedCoin());
			Actions.pressEnter();
			break;
		case "Bureaucrat":
			break;
		case "Feast":
			break;
		case "Militia":
			break;
		case "Moneylender":
		        Layout.drawSubTitel("Pick a card");
		        Layout.drawMenuNumericList("Your Cards", currentPickedHand.getPile());
		        Layout.drawMenuNoList("selected cards", currentSelectedHand.getPile());
		        
		        handleSelectedCard();
		        Actions.pressEnter();
			break;
		case "Remodel":
	        Layout.drawSubTitel("Pick a card");
	        Layout.drawMenuNumericList("Your Cards", currentPickedHand.getPile());
	        Layout.drawMenuNoList("selected cards", currentSelectedHand.getPile());
	        
	        handleSelectedCard();
	        Actions.pressEnter();
			break;
		case "Spy":
			break;
		case "Thief":
			break;
		case "Throne Room":
			break;
		case "Council Room":
			break;
		case "Library":
			break;
		case "Mine":
			Layout.drawSubTitel("Pick a Treasure card");
			Layout.drawMenuNumericList("Your Cards", currentPickedHand.getPile());
			Layout.drawMenuNoList("selected cards", currentSelectedHand.getPile());
			
			handleSelectedCard();
			Actions.pressEnter();
			break;
		case "Witch":
			break;
		case "Adventurer":
			break;
		default:			
            System.out.print("Incorrect or unknown letter, please try again!\n");
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
                handlePlayCard();
                break;

            case "B":                      // B: Buy a card
                if (gameEngine.getCurrentTurnSegment().getBuy() > 0) handleBuyCard();
                break;
            case "C":                     // C: print all cards on board (Victory, Kingdom, Treasure)
                printAllCards();
                System.out.print("Press ENTER to continue...");
                scanner.nextLine();
                break;
            case "E":                     // C: print all cards on board (Victory, Kingdom, Treasure)
            	gameEngine.CleanedUp();
            	endPlayerTurn();
                break;
            case "SC":                     // C: print all cards on board (Victory, Kingdom, Treasure)
            	printAllCards();
                int option = Integer.parseInt(Actions.askFor("[ SPAWN ] What card would you like to spawn"));
                currentPlayer.getHand().addAmountOfCardsFrom(1, gameEngine.getBoard().getFromIndex(option - 1));
                break;
            case "SCA":                     // C: print all cards on board (Victory, Kingdom, Treasure)
            	printAllCards();
                Layout.drawSubTitel("Card available on board");
                Layout.drawMenuNumericList("Board", gameEngine.getAllCards());
                int optionAll = Integer.parseInt(Actions.askFor("[ SPAWN ] What card would you like to spawn"));
                currentPlayer.getHand().add(gameEngine.getAllCards().get(optionAll - 1));
                break;
            case "VIEW":                     // C: print all cards on board (Victory, Kingdom, Treasure)
            	System.out.println("Deck: " + currentPlayer.getDeck());
            	System.out.println("Hand: " + currentPlayer.getHand());
            	System.out.println("Disc Pile: " + currentPlayer.getDiscardPile());
            	System.out.println("Play Field: " + currentPlayer.getPlayingField());
                break;   
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
    }
    
    //HANDLE -- ACTION
    public void handlePlayCard() {
        int option = Integer.parseInt(Actions.askFor("[ ACTIONS -- PLAY CARD ] What card would you like to play"));
        String card = currentHand.getFromIndex(option - 1).getName();
        if (currentHand.getFromIndex(option - 1).isHasSpecialAction()){
        	handleSpecialActionLayout(currentHand.getFromIndex(option - 1));
        }
        gameEngine.playCard(card);
        
    }
    
    public void handleSelectedCard(){
    	int option = Integer.parseInt(Actions.askFor("What card would you like to select"));
    	currentSelectedHand.addFrom(currentPickedHand.getFromIndex(option - 1),currentPickedHand);
    }
    
    public void handleGainInstancedCard() {
    	int option = Integer.parseInt(Actions.askFor("What card would you like to select"));
    	gameEngine.buyInstancedCard(option);
    }

    public void handleBuyCard() {
        printAllCards();
        
        int option = Integer.parseInt(Actions.askFor("[ ACTIONS -- BUY CARD ] What card would you like to buy")) -1;
        gameEngine.buyCard(option);
        
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
    public void printCurrentTurn() {
    	
        //ACTIONS = A B C; CURRENT TURN = None; HAND = 1 2 3; PLAYING FIELD = none;    
        
    	Layout.drawTitel("PLAYER " + currentPlayer.getName() 							// PLAYER PIETER-JAN
        			 + " -- TURN " + gameEngine.getCurrentTurn().getCurrentTurnNumber() // TURN 6
        			 + " -- SEGMENT " + gameEngine.getPlayerCounter());			 		// SEGMENT 3  (PlayerCounter = SegmentNumber)
        
        Layout.drawSubTitel(currentPlayer.getName() + "'S INFORMATION"); //PIETER-JAN'S INFORMATION
        
        Layout.drawMenuAlphabeticList("Actions", "Play Card", "Buy Card", "print current board", "Search card info", "End Turn"); /* <- Parameter STRINGS is printed in a list */

        Layout.drawMenuNoList("Current turn", 												// Current turn
        					  "Coin(s): " + gameEngine.getCurrentTurnSegment().getCoin(),			// Coin(s): 2
        					  "Action(s): " + gameEngine.getCurrentTurnSegment().getAction() ,  	// Action(s): 1
        					  "Buy(s): " +  gameEngine.getCurrentTurnSegment().getBuy());			// Buy(s): 1

        Layout.drawMenuNumericList("Your Cards", currentHand.getPile()); /* <- Gets cards [name] from the HAND which is then printed in a list */
        Layout.drawMenuNoList("Playing Field", currentPlayingField.getPile());/* <- Gets cards from the FIELD which is then printed in a list */
    }

    public void printAllCards() {
        Layout.drawSubTitel("Card available on board");
        Layout.drawBoard("Board", gameEngine.getBoard().getPiles());
    }

    public void printMatchSettings() {
        Layout.drawTitel("Match Settings");
        Layout.drawSubTitel("Players");

        int amount = Integer.parseInt(Actions.askFor("How many players"));
        gameEngine.initAmountPlayers(amount);
        setPlayerNames(amount);
        gameEngine.init();
        
        Layout.drawSubTitel("Kingdom Set");
        Layout.drawMenuAlphabeticList("Kingdom Sets", "Custom set", "Random", "First game", "Big Money", "Interaction", "Size Distortion", "Village Square");
        System.out.print("Pick a set:\t");
        String set = scanner.nextLine();

        printAllCards();
        Actions.pressEnter();
    }
}
