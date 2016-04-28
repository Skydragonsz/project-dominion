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
		// ArrayList selectedCards = selectableCards();
		int i = selectedCards.size();
		for (Card card : selectedCards) {
			stPlayer.getDiscardPile().addFrom(card, stPlayer.getHand());
		}

		stPlayer.getHand().addAmountOfCardsFrom(i, stPlayer.getDeck());
	}

	public static void playChapel() {
		// ArrayList selectedCards = selectableCards(4);
		int i = selectedCards.size();
		for (Card card : selectedCards) {
			stPlayer.getHand().remove(card);
			;
		}
	}

	public static void playMoat() {
		stPlayer.getHand().addAmountOfCardsFrom(2, stPlayer.getDeck());
	}

	public static void playChancellor() {
		//+2 Coins, You may immediately put your deck into your discard pile.
		boolean choice = true;
		if (choice == true){
			stPlayer.getDiscardPile().addAmountOfCardsFrom(stPlayer.getDeck().getAmount(), stPlayer.getDeck());
		}
		
	}

	public static void playWorkshop() {
		stPlayer.addInstancedCoin(4);
		// showInstancedBuyMenu();
	}

	public static void playBureaucrat() {
		//Gain a silver card, put it on top of your deck
		Card tmpSilver = new Card("Silver", "Treasure", "description", 3, 2, 0, 0, 0, 0, false);
		stPlayer.getDeck().add(tmpSilver);
		//Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).
		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			for (int j = 0; j < stOtherPlayerList.get(i).getHand().getAmount(); j++){
				if (stOtherPlayerList.get(i).getHand().getFromIndex(j).getType() == "Victory") {
					stOtherPlayerList.get(i).getDeck().addFrom(stOtherPlayerList.get(i).getHand().getFromIndex(j), stOtherPlayerList.get(i).getHand());
				}
			}
				
		}
		
	}

	public static void playFeast() {
		stPlayer.getHand().remove(stPlayer.getHand().findCard("Feast"));
		stPlayer.addInstancedCoin(5);
		// showInstancedBuyMenu();
	}

	public static void playMilitia() {
		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			////stOtherPlayerList.get(i).getHand().addAmountOfCardsFrom(4, stOtherPlayerList.get(i).getDeck());
			// ArrayList selectedCards = selectableCards(4);
			int size = selectedCards.size();
			for (Card card : selectedCards) {
				stOtherPlayerList.get(i).getDiscardPile().addFrom(card, stOtherPlayerList.get(i).getHand());
			}
		}		
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
		// ArrayList selectedCards = selectableCards(1);
		int size = selectedCards.size();
		strPlayer.
		stPlayer.getHand().remove(selectedCard.get(0);
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
				// Add Curse card DECK
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
