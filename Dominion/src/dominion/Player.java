    /*
    1 Copper
    2 Silver
    3 Gold
    4 Estate(1)
    5 Estate(3)
    6 Estate(6)
    */

package dominion;

//import Deck.LinkedCards;
import java.util.*;

public class Player{ 
    private ArrayList deckArray;
    private ArrayList cardArray;
    private int victoryPoints;
    private int[] discardPile;
        
    public Player()
    {        
        init();
    }
    
    public void init()
    {
        //Starter deck -- TEST
        deckArray = new ArrayList<Integer>();
        cardArray = new ArrayList<Integer>();
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(4);
        deckArray.add(4);
        deckArray.add(4);

    }
    public void shuffleDeck(){
        Random rng = new Random();
        for (int i = deckArray.size() -1; i>0; i--)
        {
            int index = rng.nextInt(i +1);
            
            Object swap = deckArray.get(index);
            deckArray.set(index,deckArray.get(i));
            deckArray.set(i, swap);                   
        }   
        
    }
     
    public ArrayList getDeck(){
        return deckArray;
    }
    
    public void setNthAmountOfCards(int amount )
    {
        for(int i = 0;i <amount ;i++){
            cardArray.add(deckArray.get(i));
            deckArray.remove(i);
        }
    }
    
    public ArrayList getCards(){
        return cardArray;
    }
    
  
    public void AddCard(int CardID)
    {
        deckArray.add(CardID);
    }
    
    public void RemoveNthCard(int CardID){
        deckArray.remove(CardID);
    }
    
    public String getD(){
        return deckArray.toString();
    }

}
    

