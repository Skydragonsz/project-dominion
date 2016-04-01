/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameconsole;

import java.util.ArrayList;
import Cards.Collection;
/**
 *
 * @author Quint
 */
public class GameConsoleLayout {
        private static Collection collection = new Collection();
    public static void DrawMenu(String title, String... lines) {
        //ACTIONS = ABC
        //CARDS = 123
        int counter = 1;
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //TODO: check length
        int titleLength = (22 - (title.length())) / 2;
        String extraSpace = "";
        
        if (titleLength % 2 == 0) {
            extraSpace = " ";
        }

        System.out.println("|-----------------------|\n" + "|" + CalculateSpaces(titleLength) + extraSpace + title.toUpperCase() + CalculateSpaces(titleLength) + "|\n" + "|-----------------------|");

        for (String line : lines) {
            int lineLength = (22 - (line.length() + 3));
            System.out.println("| " + alphabet[counter - 1] + ". " + line + CalculateSpaces(lineLength) + "|");
            counter++;
        }
        System.out.println("|-----------------------|\n");
    }
    
    
    
        public static void DrawMenu(String title, ArrayList<Integer> lines) {
        //ACTIONS = ABC
        //CARDS = 123
        int counter = 1;
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //TODO: check length
        int titleLength = (22 - (title.length())) / 2;
        String extraSpace = "";

        if (titleLength % 2 == 0) {
            extraSpace = " ";
        }

        System.out.println("|-----------------------|\n" + "|" + CalculateSpaces(titleLength) + extraSpace + title.toUpperCase() + CalculateSpaces(titleLength) + "|\n" + "|-----------------------|");

        for (Integer line : lines) {
            int lineLength = 3;
            System.out.println("| " + alphabet[counter - 1] + ". " + collection.getCard(line).getName() + CalculateSpaces(lineLength) + "|");
            counter++;
        }
        System.out.println("|-----------------------|\n");
    }

    public static String CalculateSpaces(int amount) {
        String BlankSpace = "";
        for (int i = 0; i < amount; i++) {
            BlankSpace += " ";
        }
        return BlankSpace;
    }

    public static void DrawLogo() {
        System.out.println("    *                             |>>>                    +\n"
                + "+          *                      |                   *       +\n"
                + "                    |>>>      _  _|_  _   *     |>>>\n"
                + "           *        |        |;| |;| |;|        |                 *\n"
                + "     +          _  _|_  _    \\\\.    .  /    _  _|_  _       +\n"
                + " *             |;|_|;|_|;|    \\\\: +   /    |;|_|;|_|;|\n"
                + "               \\\\..      /    ||:+++. |    \\\\.    .  /           *\n"
                + "      +         \\\\.  ,  /     ||:+++  |     \\\\:  .  /\n"
                + "                 ||:+  |_   _ ||_ . _ | _   _||:+  |       *\n"
                + "          *      ||+++.|||_|;|_|;|_|;|_|;|_|;||+++ |          +\n"
                + "                 ||+++ ||.    .     .      . ||+++.|   *\n"
                + "+   *            ||: . ||:.     . .   .  ,   ||:   |               *\n"
                + "         *       ||:   ||:  ,     +       .  ||: , |      +\n"
                + "  *              ||:   ||:.     +++++      . ||:   |         *\n"
                + "     +           ||:   ||.     +++++++  .    ||: . |    +\n"
                + "           +     ||: . ||: ,   +++++++ .  .  ||:   |             +\n"
                + "                 ||: . ||: ,   +++++++ .  .  ||:   |        *\n"
                + "                 ||: . ||: ,   +++++++ .  .  ||:   | \n");
        System.out.println("              ____                  _       _           \n"
                + "             / __ \\____  ____ ___  (_)___  (_)___  ____ \n"
                + "            / / / / __ \\/ __ `__ \\/ / __ \\/ / __ \\/ __ \\\n"
                + "           / /_/ / /_/ / / / / / / / / / / / /_/ / / / /\n"
                + "          /_____/\\____/_/ /_/ /_/_/_/ /_/_/\\____/_/ /_/ \n");

    }

    public static void DrawTitel(String titel) {
        System.out.print("\n======================================== " + titel + " ========================================\n");
    }

    public static void DrawSubTitel(String Subtitel) {
        System.out.print("\n==================== " + Subtitel + " ====================\n");
    }
}
