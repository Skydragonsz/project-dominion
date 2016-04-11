package gameconsole;

import dominion.GameEngine;
import dominion.Player;
import java.util.Scanner;

public class GameConsole {

    private GameEngine gameEngine;
    private Player currentPlayer;
    private boolean endPlayerTurn = false; //TEMP
    Scanner scanner = new Scanner(System.in);

//START-UP
    public static void main(String[] args) {
        GameConsole consoleGame = new GameConsole();
        consoleGame.run();
    }

    public GameConsole() {
        gameEngine = new GameEngine();
        currentPlayer = new Player();
    }

    public void run() {
        Layout.drawLogo();
        Layout.drawMenuAlphabeticList("Main menu", "New game", "Load Game", "print (card) sets", "Help", "Exit game");

        System.out.print("Choice an option:\t");
        String option = scanner.nextLine();

        handleMainMenuAction(option);
    }
    
    //START-UP -- GAMELOOP
    public void gameLoop() {
        boolean bln = true; //TEMP
        
        while (bln = true) //gameEngine.gameNotFinished()
        {   
            currentPlayer = gameEngine.getPlayer(gameEngine.getCurrentPlayer());
            printCurrentSituation();

            System.out.print("[ ACTIONS ] What action would you like to perform:\t");
            String option = scanner.nextLine();

            handlePlayerAction(option);

            if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayer()) {
                gameEngine.addTurn();
                gameEngine.ResetPlayer();
            } else if (CurrentPlayerWantsToEndTurn()) {
                System.out.print(gameEngine.getCurrentPlayer() + " || " + gameEngine.getLastPlayer());
                initNewPlayerTurn();
                gameEngine.setNextPlayer();
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
    
//HANDLE
    //HANDLE -- SWITCH
    public void handleMainMenuAction(String action) {

        switch (action.toUpperCase()) {
            case "A":				// A: (Start) New game
                //gameEngine.init();
                printMatchSettings();
                gameLoop();
                break;
            case "B":                        // B: Load game
                //gameEngine.load();
                break;
            case "C":                        // C: print sets
                //printSetsMenu();
                break;
            case "D":                        // D: Help / info
                //printHelpMenu();
                break;
            case "E":                        // E: Exit game
                //ExitGame();
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                //duplicatie
                System.out.print("Choose an option:\t");
                String option = scanner.nextLine();
                handleMainMenuAction(option);
                break;
        }
    }
    
    public void handleMatchSettings(String action) {
        //WARNING: Copied switch from above.
        //TODO: change content of cases.
        switch (action.toUpperCase()) {
            case "A":				// 1: (Start) New game
                //handleMatchSettings();
                //gameEngine.init();
                gameLoop();
                break;
            case "B":                        // 2: Load game
                //gameEngine.load();
                break;
            case "C":                        // 3: print sets
                //printSetsMenu();
                break;
            case "D":                        // 4: Help / info
                //printHelpMenu();
                break;
            case "E":                        // 5: Exit game
                //ExitGame();
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                //duplicatie
                System.out.print("Choice an option:\t");
                String option = scanner.nextLine();
                handleMainMenuAction(option);
                break;
        }
    }
    
    public void handlePlayerAction(String action) {
        switch (action.toUpperCase()) {
            case "A":                       // A: Play a card
                //TODO: Geld kan altijd gespeeld worden!
                if (gameEngine.getAction() > 0) handlePlayCard();
                break;

            case "B":                      // B: Buy a card
                if (gameEngine.getBuy() > 0) handleBuyCard();
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
        System.out.print("[ ACTIONS -- PLAY CARD ] What card would you like to play:\t");
        int card = Integer.parseInt(scanner.nextLine());
        currentPlayer.addToPlayingField(card-1);
    }

    public void handleBuyCard() {
        //TODO: change this with a better parameter.
        printAllCards();
        
        System.out.print("[ ACTIONS -- BUY CARD ] What card would you like to buy:\t");
        int card = Integer.parseInt(scanner.nextLine());
        //TODO -- If enough money
        //TODO -- Card goes to discardArray, not to handArray
        //TODO -- -1 buy
        currentPlayer.addHandFromBuyTransaction(card-1);
    }
    
    public void handleBuyAction(Integer card) {

    }
    
    public void handledrawCard() {

//		GameEngine.drawCard();
    }

//SETTERS    
    public void setPlayerNames(int amount) {
        for (int i = 1; i <= amount; i++) {
            System.out.print("Player " + i + "'s name" + ":\t");
            String name = scanner.nextLine();
            gameEngine.setName(i, name);
        }
    }

//PRINTERS
    public void printCurrentSituation() {
        //TODO: cleaning, lots of it
        //IFB = insert from backend
        //ACTIONS = A B C; CURRENT TURN = None; HAND = 1 2 3; PLAYING FIELD = none;    
        Layout.drawTitel("PLAYER " + gameEngine.getCurrentPlayer() + ": " + currentPlayer.getName() + " -- TURN " + gameEngine.getCurrentTurn());
        Layout.drawSubTitel(currentPlayer.getName() + " INFORMATION");
        
        Layout.drawMenuAlphabeticList("Actions", "Play Card", "Buy Card", "print current board", "Search card info", "End Turn");
        Layout.drawMenuNoList("Current turn", "Coin(s): " + gameEngine.getCoin(), "Action(s): " + gameEngine.getAction(), "Buy(s): " + gameEngine.getBuy());

        Layout.drawMenuNumericList("Your Cards", currentPlayer.getCardsInHand());
        Layout.drawMenuNoList("Playing Field", currentPlayer.getPlayingField());
    }

    public void printAllCards() {
        Layout.drawSubTitel("Card available on board");
        Layout.drawMenuNumericList("Board", currentPlayer.getCurrentSetArray());
    }

    public void printMatchSettings() {

        Layout.drawTitel("Match Settings");
        Layout.drawSubTitel("Players");

        System.out.print("How many players:\t");
        int amount = Integer.parseInt(scanner.nextLine());
        gameEngine.setAmountPlayers(amount);
        setPlayerNames(amount);
        
        Layout.drawSubTitel("Kingdom Set");
        Layout.drawMenuAlphabeticList("Kingdom Sets", "Custom set", "Random", "First game", "Big Money", "Interaction", "Size Distortion", "Village Square");
        System.out.print("Pick a set:\t");
        String set = scanner.nextLine();

        //prints players the chosen kingdom cards
        //TODO: change this with a better parameter.
        printAllCards();
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
