    /*
    1 Copper
    2 Silver
    3 Gold
    4 Estate(1)
    5 Estate(3)
    6 Estate(6)
    */

package dominion;

import Deck.LinkedCards;
import java.util.*;

public class Player{
    private int[] cards;
    private LinkedCards cardsLinked = new LinkedCards();
    private int[] deck;
    private LinkedCards deckLinked = new LinkedCards();
    private int victoryPoints;
    private int[] discardPile;
        
    public Player()
    {        
        init();
    }
    
    public void init()
    {
    //deck = new int[]{1,1,1,1,1,4,4,4};
    //FILL - TEST
    cardsLinked.addInFront(1);
    cardsLinked.addInFront(1);
    cardsLinked.addInFront(5);
    cardsLinked.addInFront(5);
    cardsLinked.addInFront(5);
    cardsLinked.addInFront(6);
    cardsLinked.addInFront(7);
    }
    
    public LinkedCards shuffleDeck(LinkedCards deck){
        Random rng = new Random();
        //TODO: Count 
        //REMOVE: i = 10
        for (int i = 10 -1; i>0; i--)
        {
            int index = rng.nextInt(i +1);
            
            int swap = deck.getNth(index);
            int swapTemp = deck.getNth(i);
            deck.setNth(index,swapTemp);
            deck.setNth(i,swap);                   
        }
        
        return deck;
    }
    
    public LinkedCards getDeck(){
        return cardsLinked;
    }
    
    public void getFirstFiveCards()
    {
        cards = new int[5];
        for(int i = 0;i>=5;i++){
            cards[i] = deck[i];
        }
    }
    
    public int[] getCards(){
        return cards;
    }
    
    
    public void RemoveNthCard(int CardID){
    cardsLinked.deleteFirst(CardID);
    }
    
    public String getLinkedCards(){
        return cardsLinked.toString();
    }
    
}
    

