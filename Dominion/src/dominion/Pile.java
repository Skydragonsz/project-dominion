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

    public ArrayList getPile() {
        return pile;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCardsName() {
        ArrayList tempArrayList = new ArrayList<>();
//        if (!pile.isEmpty()) {
        for (int i = 0; i < pile.size(); i++) {
            tempArrayList.add(this.pile.get(i).getName());
        }
        return tempArrayList;

//        else {
//        
//            return tempArrayList;
//    }
//        return tempArrayList;
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

    public void addFrom(Card card, Pile otherPile) {
        this.pile.add(card);
        otherPile.remove(card);
    }

    public void moveFrom(int index, Pile otherPile) {
        this.pile.add(otherPile.getFromIndex(index));
        otherPile.remove(otherPile.getFromIndex(index));
    }

    public void remove(Card card) {
        this.pile.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(this.pile);
    }

    public void addAmountOfCardsFrom(int amount, Pile otherPile) {
        for (int i = 0; i < amount; i++) {
            this.pile.add(otherPile.getFromIndex(i));
            otherPile.remove(otherPile.getFromIndex(i));
        }

    }

    public boolean isDeckEmpty() {
        return this.pile.isEmpty();
    }

}
