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
    private boolean HasReaction;
    private int amount;
    
    public Pile() {

    }

    public Pile(Card... pile) {
        for (Card card : pile) {
        	//System.out.print("Een kaart in Pile -- Pile: " + card + " " + card.getName()  + "\n");
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
        ArrayList<String> tempArrayList = new ArrayList<String>();
        if(!(this.pile.size() ==0)){
	        for (int i = 0; i < pile.size(); i++) {
	            tempArrayList.add(this.pile.get(i).getName().toString());
	        }
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
    
    public void add(Pile pile){
    	for(int i = 0; i < pile.getAmount(); i++){
    		this.pile.add(pile.getFromIndex(i));
    	}
    }


    public void addFrom(Card card, Pile otherPile) {
        this.pile.add(card);
        otherPile.remove(card);
    }

    public void moveFrom(int index, Pile otherPile) {
        this.pile.add(otherPile.getFromIndex(index));
        otherPile.remove(otherPile.getFromIndex(index));
    }

	public void remove(Card card) {
		//pretty messy
		// pointers, objects, those things.
//    	System.out.print("Een kaart in remove -- Pile: " + card + " " + card.getName() + "\n");
//		boolean firstFind = true;
//		Card foundCard = null;
//
//		for (Card pileCard : pile) {
//			if (pileCard.getName().equals(card.getName()) && firstFind) {
//				firstFind = false;
//				foundCard = pileCard;
//			}
//		}
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
    
    public void drawCards(int amount, Pile hand, Pile discardPile){		
		if(this.getAmount() < amount){
			if((this.getAmount() + discardPile.getAmount()) < amount){
				amount = this.getAmount() + discardPile.getAmount();
			}
				if (this.isPileEmpty() || this.getAmount() < amount){
					this.addAllFrom(discardPile);
					this.shuffle();
				}
			}
		hand.addAmountOfCardsFrom(amount, this);		
    }
    
    public Boolean checkForReactionCard() {
        HasReaction = false;
        for (int i = 0; i < this.getAmount(); i++) {
            if ("Reaction".equals(this.getFromIndex(i).getType())) {
                HasReaction = true;
                i = this.getAmount() + 1;
            }
        }
        return HasReaction;
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
	
	
	
	@Override
	public String toString(){
		String stringOfCards = new String();
        for (int i = 0; i < pile.size(); i++) {
            stringOfCards += (this.pile.get(i).getName()) + ", ";
        }
        return stringOfCards;
    }


}
