package dominion;

import java.util.ArrayList;

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

	}

	public static void playChancellor() {

	}

	public static void playWorkshop() {

	}

	public static void playBureaucrat() {

	}

	public static void playFeast() {

	}

	public static void playMilitia() {

	}

	public static void playMoneylender() {

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

	}

	public static void playLibrary() {

	}

	public static void playMine() {

	}

	public static void playWitch() {

	}

	public static void playAdventurer() {

	}

}
