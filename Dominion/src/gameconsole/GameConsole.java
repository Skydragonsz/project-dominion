package gameconsole;

import dominion.GameEngine;
import java.util.Scanner;

public class GameConsole {

    private GameEngine gameEngine;
    private boolean endPlayerTurn = false;
    Scanner scanner = new Scanner(System.in);
//NORMAL -- START-UP

    public static void main(String[] args) {
        // TODO code application logic here
        GameConsole consoleGame = new GameConsole();

        consoleGame.run();
    }

    public GameConsole() {
        gameEngine = new GameEngine();
    }

    public void run() {
        GameConsoleLayout.DrawLogo();
        GameConsoleLayout.DrawMenu("Main menu", "New game", "Load Game", "Show (card) sets", "Help", "Exit game");

        System.out.print("Choice an option:\t");
        String option = scanner.nextLine();

        handleMainMenuAction(option);
    }

    public void gameLoop() {
        boolean bln = true;
        //gameEngine.getPlayer(gameEngine.getCurrentPlayer()).setNthAmountOfCards(5);
        while (bln = true) //gameEngine.gameNotFinished()
        {
//			 stap 1: toon de situatie : wie is er aan de beurt?
//			 welke kaarten heb je in je hand ?
//			 wat ligt er op tafel?
//			 welke zetten zijn nu mogelijk?
//			 hoeveel geld heb je?
            showCurrentSituation();

            System.out.print("[ ACTIONS ] What action would you like to perform:\t");
            String action = scanner.nextLine();                           //askPlayerAction();  // 1 = draw card ; 2 = ... ; ....

            handlePlayerAction(action);		// gaat werken met gameEngine

            if (gameEngine.getCurrentPlayer() == gameEngine.getLastPlayer()) {
                //gameEngine.addTurn();
            } else if (CurrentPlayerWantsToEndTurn()) {
                System.out.print(gameEngine.getCurrentPlayer() + " || " + gameEngine.getLastPlayer());
                initNewPlayerTurn();
                gameEngine.setNextPlayer();
            }
        }
    }

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
    //HANDLE SWITCH

    public void handlePlayerAction(String action) {
        switch (action.toUpperCase()) {
            case "A":                       // A: Play a card
                //TODO: Geld kan altijd gespeeld worden!
                if (GetActions() > 0) {
                    handlePlayCard();
                }
                break;

            case "B":                      // B: Buy a card
                if (getBuys() > 0) {
                    handleBuyCard();
                }
                break;
            case "C":                     // C: Show all cards on board (Victory, Kingdom, Treasure)
                ShowAllCards("NaN");
                System.out.print("Press ENTER to continue...");
                scanner.nextLine();
                break;
            case "E":                     // C: Show all cards on board (Victory, Kingdom, Treasure)
                endPlayerTurn();
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
    }

    public void handleMainMenuAction(String action) {

        switch (action.toUpperCase()) {
            case "A":				// A: (Start) New game
                //gameEngine.init();
                ShowMatchSettings();
                gameLoop();
                break;
            case "B":                        // B: Load game
                //gameEngine.load();
                break;
            case "C":                        // C: Show sets
                //ShowSetsMenu();
                break;
            case "D":                        // D: Help / info
                //ShowHelpMenu();
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
            case "C":                        // 3: Show sets
                //ShowSetsMenu();
                break;
            case "D":                        // 4: Help / info
                //ShowHelpMenu();
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

    //HANDLE ACTIONS
    public void handleDrawCard() {

//		GameEngine.drawCard();
    }

    public void handlePlayCard() {
        System.out.print("[ ACTIONS -- PLAY CARD ] What card would you like to play:\t");
        int card = Integer.parseInt(scanner.nextLine());
        gameEngine.getPlayer(gameEngine.getCurrentPlayer()).addToPlayingFieldIndex(card);
    }

    public void handleBuyCard() {
        ShowAllCards("NaN");
        System.out.print("[ ACTIONS -- BUY CARD ] What card would you like to buy:\t");
        int card = Integer.parseInt(scanner.nextLine());
//		GameEngine.playCard();
    }

//GETTERS 
    public Integer GetActions() {
        return 1;
    }

    public Integer getBuys() {
        return 1;
    }

//SETTERS    
    public void setPlayerNames(int amount) {
        for (int i = 1; i <= amount; i++) {
            System.out.print("Player " + i + "'s name" + ":\t");
            String name = scanner.nextLine();
            gameEngine.setName(i, name);
        }
    }

//SHOWERS ;)    
    public void showCurrentSituation() {
        //TODO: cleaning, lots of it
        //IFB = insert from backend
//               GameEngine.showCurrentSituation();
        GameConsoleLayout.DrawTitel("PLAYER " + gameEngine.getCurrentPlayer() + ": " + gameEngine.getPlayer(gameEngine.getCurrentPlayer()).getName() + " -- TURN " + "IFB");
        GameConsoleLayout.DrawSubTitel(gameEngine.getPlayer(gameEngine.getCurrentPlayer()).getName() + " INFORMATION");
        GameConsoleLayout.DrawMenu("Actions", "Play Card", "Buy Card", "Show current board", "Search card info", "End Turn");
        GameConsoleLayout.DrawMenuNonInt("Current turn", "Coin(s): " + gameEngine.getCoin(), "Action(s): " + gameEngine.getAction(), "Buy(s): " + gameEngine.getBuy());
        //GameConsoleLayout.DrawMenu("Your Cards", "Copper", "Estate", "Silver", "Curse", "Village");
        //gameEngine.getPlayer(gameEngine.getCurrentPlayer()).shuffleDeck(); //Dit mag weg Player handled zelf de shuffle bij het maken van de player

        GameConsoleLayout.DrawMenu("Your Cards", gameEngine.getPlayer(gameEngine.getCurrentPlayer()).getCardsInHand());
        System.out.println(gameEngine.getPlayer(gameEngine.getCurrentPlayer()).getCardsInHand());
        GameConsoleLayout.DrawMenu("Playing Field", gameEngine.getPlayer(gameEngine.getCurrentPlayer()).getPlayingField());
        //ACTIONS = A B C; CURRENT TURN = None; HAND = 1 2 3; PLAYING FIELD = none;    
    }

    public void ShowAllCards(String board) {
        //TODO: find better way to give a parameter value
        if (board == "first") {
            board = "THESE WILL BE THE CARDS FOR THE ONGOING GAME";
        } else {
            board = "YOUR CURRENT BOARD";
        }

        GameConsoleLayout.DrawSubTitel(board);
        GameConsoleLayout.DrawMenuBoard("Victory cards", "Province $8 (8)", "Duchy $8 (3)", "Estate $8 (9)");
        GameConsoleLayout.DrawMenuBoard("Kingdom cards", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)");
        GameConsoleLayout.DrawMenuBoard("Treasure cards", "Gold $8 (40)", "Silver $8(37)", "Bronze $8 (40)", "Curse $8 (9)");
    }

    public void ShowMatchSettings() {

        GameConsoleLayout.DrawTitel("Match Settings");
        GameConsoleLayout.DrawSubTitel("Players");

        System.out.print("How many players:\t");
        int amount = Integer.parseInt(scanner.nextLine());
        gameEngine.setAmountPlayers(amount);
        setPlayerNames(amount);

        /*
        System.out.print(gameEngine.getPlayer(1).getName());
        System.out.print(gameEngine.getPlayer(2).getName());
        System.out.print(gameEngine.getPlayer(3).getName());
        System.out.print(gameEngine.getPlayer(4).getName());
        System.out.print(gameEngine.getPlayer(5).getName());
         */
        GameConsoleLayout.DrawSubTitel("Kingdom Set");
        GameConsoleLayout.DrawMenu("Kingdom Sets", "Custom set", "Random", "First game", "Big Money", "Interaction", "Size Distortion", "Village Square");
        System.out.print("Pick a set:\t");
        String set = scanner.nextLine();

        //Shows players the chosen kingdom cards
        ShowAllCards("first");
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
