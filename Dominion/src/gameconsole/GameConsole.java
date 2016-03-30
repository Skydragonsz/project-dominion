package gameconsole;

import java.util.Scanner;

public class GameConsole {

    //private Dominion gameEngine;
    private int nrPlayers;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        GameConsole consoleGame = new GameConsole();

        consoleGame.run();
    }

    public GameConsole() {
        //gameEngine = new Dominion();
    }

    public void run() {
        GameConsoleLayout.DrawLogo();
        GameConsoleLayout.DrawMenu("Main menu", "New game", "Load Game", "Show (card) sets", "Help", "Exit game");

        System.out.print("Choice an option:\t");
        int option = Integer.parseInt(scanner.nextLine());

        nrPlayers = askNrPlayers();

        handleMainMenuAction(option);

        //gameEngine.setNrPlayers(nrPlayers);
        //VV Functie met for loop met aantal spelers VV
        //gameEngine.setPlayer(0, "jos");
        //gameEngine.setPlayer(1, "rudy");
    }

    public int askNrPlayers() {
        return 2;
    }

    public void gameLoop() {
        boolean bln = true;
        ShowAllCards("first");
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
        while (bln = true) //gameEngine.gameNotFinished()
        {
//			 stap 1: toon de situatie : wie is er aan de beurt?
//			 welke kaarten heb je in je hand ?
//			 wat ligt er op tafel?
//			 welke zetten zijn nu mogelijk?
//			 hoeveel geld heb je?
            showCurrentSituation();

            System.out.print("[ ACTIONS ] What action would you like to perform:\t");
            int action = Integer.parseInt(scanner.nextLine());                           //askPlayerAction();  // 1 = draw card ; 2 = ... ; ....

            handlePlayerAction(action);		// gaat werken met gameEngine

        }

    }

    public void handlePlayerAction(int action) {
        switch (action) {
            case 1:
                if (GetActions() > 0) {
                    handlePlayCard();
                }
                break;

            case 2:
                if (getBuys() > 0) {
                    handleBuyCard();
                }
                break;
            case 3:
                ShowAllCards("NaN");
                System.out.print("Press ENTER to continue...");
                scanner.nextLine();
                break;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
    }

    public void handleMainMenuAction(int action) {

        switch (action) {
            case 1:				// 1: (Start) New game
                //handleMatchSettings();
                //gameEngine.init();
                ShowMatchSettings();
                gameLoop();
                break;
            case 2:                        // 2: Load game

                //gameEngine.load();
                break;
            case 3:                        // 3: Show sets
                //ShowSetsMenu();
                break;
            case 4:                        // 4: Help / info
                //ShowHelpMenu();
                break;
            case 5:                        // 5: Exit game
                //ExitGame();
                break;
            default:
                System.out.print("Incorrect or unknown number, please try again!\n");
                //duplicatie
                System.out.print("Choice an option:\t");
                int option = Integer.parseInt(scanner.nextLine());
                handleMainMenuAction(option);
                break;
        }
    }

    public void handleMatchSettings(int action) {
        switch (action) {
            case 1:				// 1: (Start) New game
                //handleMatchSettings();
                //gameEngine.init();
                gameLoop();

                break;
            case 2:                        // 2: Load game

                //gameEngine.load();
                break;
            case 3:                        // 3: Show sets
                //ShowSetsMenu();
                break;
            case 4:                        // 4: Help / info
                //ShowHelpMenu();
                break;
            case 5:                        // 5: Exit game
                //ExitGame();
                break;
            default:
                System.out.print("Incorrect or unknown number, please try again!\n");
                //duplicatie
                System.out.print("Choice an option:\t");
                int option = Integer.parseInt(scanner.nextLine());
                handleMainMenuAction(option);
                break;
        }
    }

    public void handleDrawCard() {

//		GameEngine.drawCard();
    }

    public void handlePlayCard() {
        System.out.print("[ ACTIONS -- PLAY CARD ] What card would you like to play:\t");
        int card = Integer.parseInt(scanner.nextLine());
//		GameEngine.playCard();
    }

    public void handleBuyCard() {
        ShowAllCards("NaN");
        System.out.print("[ ACTIONS -- BUY CARD ] What card would you like to buy:\t");
        int card = Integer.parseInt(scanner.nextLine());
//		GameEngine.playCard();
    }

    public Integer GetActions() {
        return 1;
    }

    public Integer getBuys() {
        return 1;
    }

    public void showCurrentSituation() {
//               GameEngine.showCurrentSituation();
        GameConsoleLayout.DrawTitel("PLAYER 1 -- TURN 1");
        GameConsoleLayout.DrawSubTitel("PLAYER 1 INFORMATION");
        GameConsoleLayout.DrawMenu("Actions", "Play Card", "Buy Card", "Show current board", "Search card info", "End Turn");
        GameConsoleLayout.DrawMenu("Current turn", "Coin(s): 0", "Action(s): 1", "Buy(s): 1");
        GameConsoleLayout.DrawMenu("Your Cards", "Copper", "Estate", "Silver", "Curse", "Village");
        GameConsoleLayout.DrawMenu("Playing Field", "Copper");
        //ACTIONS = A B C; CURRENT TURN = None; HAND = 1 2 3; PLAYING FIELD = none;    
    }

    public void ShowAllCards(String board) {
        if (board == "first") {
            board = "THESE WILL BE THE CARDS FOR THE ONGOING GAME";
        } else {
            board = "YOUR CURRENT BOARD";
        }

        GameConsoleLayout.DrawSubTitel(board);
        GameConsoleLayout.DrawMenu("Victory cards", "Province $8 (8)", "Duchy $8 (3)", "Estate $8 (9)");
        GameConsoleLayout.DrawMenu("Kingdom cards", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)", "Village $8 (10)");
        GameConsoleLayout.DrawMenu("Treasure cards", "Gold $8 (40)", "Silver $8(37)", "Bronze $8 (40)", "Curse $8 (9)");
    }

    public void ShowMatchSettings() {

        //gameEngine.setNrPlayers(nrPlayers);
        //VV Functie met for loop met aantal spelers VV
        //gameEngine.setPlayer(0, "jos");
        //gameEngine.setPlayer(1, "rudy");
        GameConsoleLayout.DrawTitel("Match Settings");
        GameConsoleLayout.DrawSubTitel("Players");
        System.out.print("How many players:\t");
        int amount = Integer.parseInt(scanner.nextLine());
        GameConsoleLayout.DrawSubTitel("Kingdom Set");
        GameConsoleLayout.DrawMenu("Kingdom Sets", "Custom set", "Random", "First game", "Big Money", "Interaction", "Size Distortion", "Village Square");
        System.out.print("Pick a set:\t");
        int set = Integer.parseInt(scanner.nextLine());
    }
}
