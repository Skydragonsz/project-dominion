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
		case "Council room":
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
		for (Card card : stPlayer.getSelectedHand().getPile()) {
			stPlayer.getHand().remove(card);
		}
	}


	public static void playChancellor() {
		//+2 Coins, You may immediately put your deck into your discard pile.
		boolean choice = true;
		if (choice == true){
			
			stPlayer.getDiscardPile().addAllFrom(stPlayer.getDeck());
		}
		
	}

	public static void playWorkshop() {
		stCurrentTurnSegment.addInstancedCoin(4);
		// showInstancedBuyMenu();
	}

	public static void playBureaucrat() {
		//Gain a silver card, put it on top of your deck
		stPlayer.getDeck().add(GameEngine.CallCard("Silver"));
		//Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).
		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			for (int j = 0; j < stOtherPlayerList.get(i).getHand().getAmount(); j++){
				if ("Victory".equals(stOtherPlayerList.get(i).getHand().getFromIndex(j).getType())) {
					stOtherPlayerList.get(i).getDeck().addFrom(stOtherPlayerList.get(i).getHand().getFromIndex(j), stOtherPlayerList.get(i).getHand());
				}
			}
				
		}
		
	}

	public static void playFeast() {
		stPlayer.getHand().remove(GameEngine.CallCard("Feast"));
		stCurrentTurnSegment.addInstancedCoin(5);
		// showInstancedBuyMenu();
	}

	public static void playMilitia() {
		for (int i = 0; i < stOtherPlayerList.size() - 1; i++) {
			////stOtherPlayerList.get(i).getHand().addAmountOfCardsFrom(4, stOtherPlayerList.get(i).getDeck());
			// ArrayList selectedCards = selectableCards(4);
//			int size = selectedCards.size();
//			for (Card card : selectedCards) {
//				stOtherPlayerList.get(i).getDiscardPile().addFrom(card, stOtherPlayerList.get(i).getHand());
//			}
		}		
	}

	public static void playMoneylender() {
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
		Card card = stPlayer.getSelectedHand().getPile().get(0);
		stPlayer.getHand().remove(card);
	}

	public static void playSpy() {
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
		//TODO Test this code (test won't work: NullPointerException --> TurnSegment problem?)
		boolean choice = true;
		for (int i = 0; i < stPlayer.getHand().getAmount(); i++){
			if ("Action".equals(stPlayer.getHand().getFromIndex(i).getType())){
				if (choice) {
					for (int j = 0; j < 1; j++) {
					//stPlayer.getHand().getFromIndex(i).PlayCard(stPlayer, stOtherPlayerList);
					stPlayer.getHand().getFromIndex(i).PlayCard(stPlayer, stOtherPlayerList, stCurrentTurnSegment);
					}
				}
			}
		}
	}

	public static void playCouncilRoom() {
		

		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			
			stOtherPlayerList.get(i).getHand().addAmountOfCardsFrom(1, stOtherPlayerList.get(i).getDeck());
			
		}
	}

	public static void playLibrary() {
		// Draw until you have 7 cards in hand. You may set aside any Action cards drawn this way, 
		// as you draw them; discard the set aside cards after you finish drawing.
		boolean choice = true;
		ArrayList<Card> aside = new ArrayList<Card>();
		for (int i = stPlayer.getHand().getAmount() - 1; i < 7; i++ ) {
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
		// TODO Test this code (test won't work: OutOfBoundsException)
		boolean choice = true;
		for (int i = 0; i < stPlayer.getHand().getAmount(); i++){
			if ("Treasure".equals(stPlayer.getHand().getFromIndex(i).getType())){
				if (choice) {
					int originalCost = stPlayer.getHand().getFromIndex(i).getCost();
					stCurrentTurnSegment.addInstancedCoin(originalCost + 3);
					stPlayer.getHand().remove(stPlayer.getHand().getFromIndex(i));
					}
				}
			}
		}
	

	public static void playWitch() {
		for (int i = 0; i < stOtherPlayerList.size(); i++) {
			if (!stOtherPlayerList.get(i).checkForReactionCard()) {
				stOtherPlayerList.get(i).getDiscardPile().add(GameEngine.CallCard("Curse"));
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
