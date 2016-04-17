/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

     public Pile(){
     
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
    }

    public ArrayList getPile() {
        return pile;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void add(Card card) {
        this.pile.add(card);
    }

    public void addFrom(Card card, Pile otherPile) {
        this.pile.add(card);
        otherPile.remove(card);
    }

    public void remove(Card card) {
        this.pile.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(this.pile);
    }

    public boolean isDeckEmpty() {
        return this.pile.isEmpty();
    }

}
