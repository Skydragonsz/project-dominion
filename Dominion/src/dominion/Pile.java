package dominion;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Quint
 */
public class Pile {

    private ArrayList<Card> pile = new ArrayList<>();
    private String name;

    private int amount;
    
    public Pile() {

    }

    public Pile(Card... pile) {
        for (Card card : pile) {
            this.pile.add(card);
        }
    }

    public Pile(Card KingdomCard, int amount) {
        for (int i = 0; i < amount; i++) {
            this.pile.add(KingdomCard);
        }
        this.amount = pile.size();
        this.name = KingdomCard.getName();
    }

    public ArrayList<Card> getPile() {
        return pile;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCardsName() {
        ArrayList tempArrayList = new ArrayList<>();
        for (int i = 0; i < pile.size(); i++) {
            tempArrayList.add(this.pile.get(i).getName());
        }
        return tempArrayList;
    }

    public int getAmount() {
        this.amount = pile.size();
        return amount;
    }

    public Card getFromIndex(int index) {
        return this.pile.get(index);
    }

    public void add(Card card) {
        this.pile.add(card);
    }
    
    public void add(int amount, Card card) {
        for(int i = 0; i < amount; i++){
    	this.pile.add(card);
        }
    }


    public void addFrom(Card card, Pile otherPile) {
        couldPileBeEmpty(1,otherPile);
        this.pile.add(card);
        otherPile.remove(card);
    }

    public void moveFrom(int index, Pile otherPile) {
        couldPileBeEmpty(1, otherPile);
        this.pile.add(otherPile.getFromIndex(index));
        otherPile.remove(otherPile.getFromIndex(index));
    }

    public void remove(Card card) {
        couldIBeEmpty(1);
        this.pile.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(this.pile);
    }

    public void addAmountOfCardsFrom(int amount, Pile otherPile) {
        
        for (int i = 0; i < amount; i++) {
            this.pile.add(otherPile.getFromIndex(0));
            otherPile.remove(otherPile.getFromIndex(0));
        }

    }

    public boolean isPileEmpty() {
        return this.pile.isEmpty();
    }

	public void addAllFrom(Pile... piles) {
		for (Pile pile : piles){
			this.getPile().addAll(pile.getPile());
			pile.getPile().clear();
		}
		
	}
	public void copyAllFrom(Pile... piles) {
		for (Pile pile : piles){
			this.getPile().addAll(pile.getPile());
		}
		
	}
	
	
	private void couldIBeEmpty(int amount){
		if (pile.size() - amount <= 0){
			this.addAllFrom(GameEngine.getCurrentdiscardPile());
		}
		
	}
	
	private void couldPileBeEmpty(int amount, Pile otherPile){
		if (otherPile.isPileEmpty()){
			otherPile.addAllFrom(GameEngine.getCurrentdiscardPile());
		}
		
	}
	

	
	
	@Override
	public String toString(){
		String stringOfCards = new String();
        for (int i = 0; i < pile.size(); i++) {
            stringOfCards += (this.pile.get(i).getName()) + ", ";
        }
        return stringOfCards;
    }


}
