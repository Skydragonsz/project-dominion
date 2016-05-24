/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameconsole;

import java.util.ArrayList;

import dominion.Card;
import dominion.Pile;

/**
 *
 * @author Quint
 */
public class Layout {

	// Lots of duplicate code :(
	public static void drawMenuLine(String numerationChar, String line) {
		System.out.println("| " + numerationChar + line + "|");
	}

	public static void drawMenuNoList(String title, String... lines) {

		System.out.println(
				"|-----------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|-----------------------|");

		for (String line : lines) {
			drawMenuLine(" ", line);
		}
		System.out.println("|-----------------------|\n");
	}

	public static void drawMenuNoList(String title, ArrayList<Card> cards) {

		System.out.println(
				"|-----------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|-----------------------|");

		for (Card card : cards) {
			drawMenuLine(" ", card.getName());
		}
		System.out.println("|-----------------------|\n");
	}
	
	public static void drawMenuPurchasableCards(String title, ArrayList<Pile> piles, int instancedCoins){
		System.out.println(
				"|---------------------------------------------------------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|---------------------------------------------------------------------|");
		int counter = 1;
		for (Pile pile : piles) {
			Card card = pile.getFromIndex(0);
			if(card.getCost() <= instancedCoins){
			drawMenuLine(String.valueOf(counter) + ". ", card.getName() + " [Cost:" +  card.getCost() +  "] " + "[Value:" +  card.getValue() +  "] ");
			counter++;
			}
		}
		System.out.println("|---------------------------------------------------------------------|\n");
	}
	

	public static void drawMenuAlphabeticList(String title, String... lines) {

		System.out.println(
				"|-----------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|-----------------------|");
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int counter = 0;
		for (String line : lines) {
			drawMenuLine(String.valueOf(alphabet[counter]) + ". ", line);
			counter++;
		}
		System.out.println("|-----------------------|\n");
	}

	public static void drawMenuNumericList(String title, String... lines) {

		System.out.println(
				"|-----------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|-----------------------|");
		int counter = 1;
		for (String line : lines) {
			drawMenuLine(String.valueOf(counter) + ". ", line);
			counter++;
		}
		System.out.println("|-----------------------|\n");
	}

	public static void drawMenuNumericList(String title, ArrayList<Card> cards) {

		System.out.println(
				"|-----------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|-----------------------|");
		int counter = 1;
		for (Card card : cards) {
			drawMenuLine(String.valueOf(counter) + ". ", card.getName());
			counter++;
		}
		System.out.println("|-----------------------|\n");
	}
	
	public static void drawBoard(String title, ArrayList<Pile> piles) {

		System.out.println(
				"|---------------------------------------------------------------------|\n" + "|" + title.toUpperCase() + "|\n" + "|---------------------------------------------------------------------|");
		int counter = 1;
		for (Pile pile : piles) {
			Card card = pile.getFromIndex(0);
			drawMenuLine(String.valueOf(counter) + ". ","[Amount:" +  pile.getAmount() +  "] "  + card.getName() + "[Cost:" +  card.getCost() +  "] " + "[Value:" +  card.getValue() +  "] " + "[Type:" +  card.getType() +  "] ");
			counter++;
		}
		System.out.println("|---------------------------------------------------------------------|\n");
	}

	public static String calculateSpaces(int amount) {
		String BlankSpace = "";
		for (int i = 0; i < amount; i++) {
			BlankSpace += " ";
		}
		return BlankSpace;
	}

	public static void drawLogo() {
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

	public static void drawTitel(String titel) {
		System.out.print(
				"\n======================================== " + titel + " ========================================\n");
	}

	public static void drawSubTitel(String subtitel) {
		System.out.print("\n==================== " + subtitel + " ====================\n");
	}
}
