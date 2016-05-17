package dominion;

import java.util.ArrayList;

public class CardSpecialAction  {

	private static Player stPlayer;
	private static ArrayList<Player> stOtherPlayerList;
	private static GameEngine stgameEngine;
	private static TurnSegment stCurrentTurnSegment;

	public static void playSpecialAction(String cardName, Player player, ArrayList<Player> otherPlayerList, TurnSegment currentTurnSegment) {

		stPlayer = player;
		stOtherPlayerList = otherPlayerList;
		stCurrentTurnSegment = currentTurnSegment;

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
		case "Throne room":
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
		int i = stPlayer.getSelectedHand().getAmount();
		for (Card card : stPlayer.getSelectedHand().getPile()) {
			stPlayer.getDiscardPile().addFrom(card, stPlayer.getHand());
		}

		stPlayer.getHand().addAmountOfCardsFrom(i, stPlayer.getDeck());
		System.out.println(stPlayer.getHand());
	}

	public static void playChapel() {
		if (stPlayer.getSelectedHand().getAmount() <= 4) {
			for (Card card : stPlayer.getSelectedHand().getPile()) {
				stPlayer.getHand().remove(card);
			}
		}
	}

	public static void playMoat() {
		//stPlayer.getHand().addAmountOfCardsFrom(2, stPlayer.getDeck());
	}

	public static void playChancellor() {
		//+2 Coins, You may immediately put your deck into your discard pile.
		boolean choice = true;
		if (choice == true){
			stPlayer.getDiscardPile().addAmountOfCardsFrom(stPlayer.getDeck().getAmount(), stPlayer.getDeck());
		}
		
	}

	public static void playWorkshop() {
		stCurrentTurnSegment.addInstancedCoin(4);
	}

	public static void playBureaucrat() {
		//Gain a silver card, put it on top of your deck
		stPlayer.getDeck().add(GameEngine.CallCard("Silver"));
		//Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).
		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			for (int j = 0; j < stOtherPlayerList.get(i).getHand().getAmount(); j++){
				if ("Victory".equals(stOtherPlayerList.get(i).getHand().getFromIndex(j).getType())) {
					stOtherPlayerList.get(i).getDeck().addFrom(stOtherPlayerList.get(i).getHand().getFromIndex(j), stOtherPlayerList.get(i).getHand());
					j = stOtherPlayerList.get(i).getHand().getAmount();
				}
			}
				
		}
		
	}

	public static void playFeast() {
		stPlayer.getPlayingField().remove(GameEngine.CallCard("Feast"));
		stCurrentTurnSegment.addInstancedCoin(5);
	}

	public static void playMilitia() {
		// +2 Coins, Each other player discards down to 3 cards in his hand.
		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			for (Player otherPlayer : stOtherPlayerList) {
				if (otherPlayer.getHand().getAmount() > 3) {
					for (Card card : otherPlayer.getSelectedHand().getPile()) {
						otherPlayer.getDiscardPile().addFrom(card, otherPlayer.getHand());
					}
				}
			}
		}		
	}

	public static void playMoneylender() {
		// Trash a Copper from your hand. If you do, +3 Coins.
		Card card = null;
		if (stPlayer.getSelectedHand().getAmount() != 0){ //IF NOT EMPTY
			card = stPlayer.getSelectedHand().getPile().get(0);
		}
			if (card.getName() == "Copper") {
				stPlayer.getHand().remove(card);
				stCurrentTurnSegment.addCoin(3);
			}

		}

	public static void playRemodel() {
		// Trash a card from your hand. Gain a card costing up to 2 Coins more than the trashed card.
		Card card = stPlayer.getSelectedHand().getPile().get(0);
		stCurrentTurnSegment.addCoin(card.getCost() + 2);
		stPlayer.getHand().remove(card);
	}

	public static void playSpy() {
		// +1 Card, +1 Action
		// Each player (including you) reveals the top card of his deck and either discards it or puts it back, your choice
		boolean choice = true;
		if (choice){
			stPlayer.getDiscardPile().addAmountOfCardsFrom(1, stPlayer.getDeck());
		}
		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			if (choice) {
			stOtherPlayerList.get(i).getDiscardPile().addAmountOfCardsFrom(1, stOtherPlayerList.get(0).getDeck());
			}
		}
	}

	public static void playThief() {
		// Each other player reveals the top 2 cards of his deck. If they revealed any Treasure cards, they trash 
		// one of them that you choose. You may gain any or all (?) of these trashed cards. They discard the other revealed cards.
		int choice = 1;
		boolean keep = true; //Implement: You may gain any or all of these trashed cards (clean up code first)
		for (int i = 0; i < stOtherPlayerList.size(); i++){
			//for (int j = 0; j < 2; j++) {
			//Both cards are treasure cards:
				if ("Treasure".equals(stOtherPlayerList.get(i).getDeck().getFromIndex(0).getType()) && "Treasure".equals(stOtherPlayerList.get(i).getDeck().getFromIndex(1).getType())){
					Card firstTreasureCard = stOtherPlayerList.get(i).getDeck().getFromIndex(0);
					Card secondTreasureCard = stOtherPlayerList.get(i).getDeck().getFromIndex(1);
					if (choice == 1) {
						stOtherPlayerList.get(i).getDeck().remove(stOtherPlayerList.get(i).getDeck().getFromIndex(0));
					} else if (choice == 2) {
						stOtherPlayerList.get(i).getDeck().remove(stOtherPlayerList.get(i).getDeck().getFromIndex(1));
					}
					//Only one card is a treasure card:
				} else if ("Treasure".equals(stOtherPlayerList.get(i).getDeck().getFromIndex(0).getType()) || "Treasure".equals(stOtherPlayerList.get(i).getHand().getFromIndex(1).getType())){
					if ("Treasure".equals(stOtherPlayerList.get(i).getDeck().getFromIndex(0).getType())){
						Card drawnTreasureCard = stOtherPlayerList.get(i).getDeck().getFromIndex(0);
						stOtherPlayerList.get(i).getDiscardPile().addFrom(stOtherPlayerList.get(i).getDeck().getFromIndex(1), stOtherPlayerList.get(i).getDiscardPile());
					} else {
						Card drawnTreasureCard = stOtherPlayerList.get(i).getDeck().getFromIndex(1);
						stOtherPlayerList.get(i).getDiscardPile().addFrom(stOtherPlayerList.get(i).getDeck().getFromIndex(0), stOtherPlayerList.get(i).getDiscardPile());
					}
					//No cards are treasure cards:
				} else {
					for (int k = 0; k < 2; k++)
					stOtherPlayerList.get(i).getDiscardPile().addFrom(stOtherPlayerList.get(i).getDeck().getFromIndex(k), stOtherPlayerList.get(i).getDiscardPile());
				}
			//}
				
		}
	}

	public static void playThroneRoom() {
		// Choose an Action card in your hand. Play it twice.
		Card card = stPlayer.getSelectedHand().getPile().get(0);
			if ("Action".equals(card.getType())){
					for (int j = 0; j <= 1; j++) {
					card.PlayCard(stPlayer, stOtherPlayerList, stCurrentTurnSegment);
					}
				}
			}

	public static void playCouncilRoom() {
		stPlayer.getHand().addAmountOfCardsFrom(4, stPlayer.getDeck());

		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			stOtherPlayerList.get(i).getHand().addAmountOfCardsFrom(4, stOtherPlayerList.get(i).getDeck());
		}
	}

	public static void playLibrary() {
		// Draw until you have 7 cards in hand. You may set aside any Action cards drawn this way, 
		// as you draw them; discard the set aside cards after you finish drawing.
		boolean choice = true;
		ArrayList aside = new ArrayList();
		for (int i = stPlayer.getHand().getAmount(); i < 7; i++ ) {
			Card drawnCard = stPlayer.getDeck().getFromIndex(0);
			stPlayer.getHand().addFrom(drawnCard, stPlayer.getDeck());
			if ("Action".equals(drawnCard.getType()) || "Attack".equals(drawnCard.getType())) {
				i--;
				if (choice) {
					aside.add(drawnCard);
					stPlayer.getHand().remove(drawnCard);
				}
			}
		}
		stPlayer.getDiscardPile().getPile().addAll(aside);
	}

	public static void playMine() {
		// Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 Coins more; put it into your hand.
		Card card = stPlayer.getSelectedHand().getPile().get(0);
			if ("Treasure".equals(card.getType())){
				stCurrentTurnSegment.addInstancedCoin(card.getCost() + 3);
				stPlayer.getHand().remove(card);
				}
			}
	

	public static void playWitch() {
		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			if (!stOtherPlayerList.get(i).checkForReactionCard()) {
				stOtherPlayerList.get(i).getDeck().add(GameEngine.CallCard("Curse"));
				// Add Curse card DECK
			}
		}
	}

	public static void playAdventurer() {
		int cards = 0;
		int indexCounter = 0;
		while (cards < 2) {
			if ("Treasure".equals(stPlayer.getDeck().getFromIndex(indexCounter).getType())) {
				stPlayer.getHand().add(stPlayer.getDeck().getFromIndex(indexCounter));
				stPlayer.getDeck().remove(stPlayer.getDeck().getFromIndex(indexCounter));
				cards++;
				indexCounter--;
			}
			indexCounter++;
		}
	}

}
