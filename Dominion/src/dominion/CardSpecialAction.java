package dominion;

import java.util.ArrayList;
import java.util.Collection;

public class CardSpecialAction {

	private static Player stPlayer;
	private static ArrayList<Player> stOtherPlayerList;

	public static void playSpecialAction(String cardName, Player player, ArrayList<Player> otherPlayerList) {

		stPlayer = player;
		stOtherPlayerList = otherPlayerList;

		switch (cardName) {
		case "Cellar":
			playCellar();
			break;
		case "Chapel":
			playChapel();
			break;
		case "Moat":
			// ?
			playMoat();
			break;
		case "Chancellor":
			playChancellor();
			break;
		case "Workshop":
			playWorkshop();
			break;
		case "Bureaucrat":
			playBureaucrat();
			break;
		case "Feast":
			playFeast();
			break;
		case "Militia":
			playMilitia();
			break;
		case "Moneylender":
			playMoneylender();
			break;
		case "Remodel":
			playRemodel();
			break;
		case "Spy":
			playSpy();
			break;
		case "Thief":
			playThief();
			break;
		case "Throne Room":
			playThroneRoom();
			break;
		case "Council Room":
			playCouncilRoom();
			break;
		case "Library":
			playLibrary();
			break;
		case "Mine":
			playMine();
			break;
		case "Witch":
			playWitch();
			break;
		case "Adventurer":
			playAdventurer();
			break;

		}
	}

	public static void playCellar() {

	}

	public static void playChapel() {

	}

	public static void playMoat() {
		stPlayer.getHand().addAmountOfCardsFrom(2, stPlayer.getDeck());
	}

	public static void playChancellor() {

	}

	public static void playWorkshop() {
		 stPlayer.addInstancedCoin(4);
	}

	public static void playBureaucrat() {

	}

	public static void playFeast() {

	}

	public static void playMilitia() {

	}

	public static void playMoneylender() {
		boolean decision = true;
		// TODO Check integratie Front-end (Positie moet door de Front-end
		// meegegeven worden)
		int cardPosition = 6;
		if (decision == true) {
			if (stPlayer.getHand().getFromIndex(cardPosition).getName() == "Copper") {
				stPlayer.getHand().remove(stPlayer.getHand().getFromIndex(cardPosition));
			}

		}
	}

	public static void playRemodel() {

	}

	public static void playSpy() {

	}

	public static void playThief() {

	}

	public static void playThroneRoom() {

	}

	public static void playCouncilRoom() {
		stPlayer.getHand().addAmountOfCardsFrom(4, stPlayer.getDeck());

		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			stOtherPlayerList.get(i).getHand().addAmountOfCardsFrom(4, stOtherPlayerList.get(i).getDeck());
		}
	}

	public static void playLibrary() {

	}

	public static void playMine() {

	}

	public static void playWitch() {
		Card tmpWitch = new Card("Witch", "Attack", "description", 5, 0, 0, 2, 0, 0, true);
		stPlayer.getHand().addAmountOfCardsFrom(2, stPlayer.getDeck());

		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			if (!stOtherPlayerList.get(i).checkForReactionCard()) {
				stOtherPlayerList.get(i).getDeck().add(tmpWitch);
				; // Add Curse card DECK
			}
		}
	}

	public static void playAdventurer() {
		int cards = 0;
		int indexCounter = 0;
		while (cards < 2) {
			if ("3".equals(stPlayer.getDeck().getFromIndex(indexCounter).getType())) {
				stPlayer.getHand().add(stPlayer.getDeck().getFromIndex(indexCounter));
				stPlayer.getDeck().remove(stPlayer.getDeck().getFromIndex(indexCounter));
				cards++;
				indexCounter--;
			}
			indexCounter++;
		}
	}

}
