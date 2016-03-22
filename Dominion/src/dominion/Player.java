/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    /*
    1 Copper
    2 Silver
    3 Gold
    4 Estate(1)
    5 Estate(3)
    6 Estate(6)
    */

package dominion;

import java.util.*;

public class Player{
    private int[] cards;
    private int[] deck;
    private int victoryPoints;
    private int[] discardPile;
    
        
        
    public Player()
    {
        
        init();
    }
    
    public void init()
    {
        deck = new int[]{1,1,1,1,1,4,4,4};
    }
    
    public int[] shuffleDeck(int[] deck){
        Random rng = new Random();
        
        for (int i = deck.length -1; i>0; i--)
        {
            int index = rng.nextInt(i +1);
            
            int swap = deck[index];
            deck[index] = deck[i];
            deck[i] = swap;                   
        }
        
        return deck;
    }
    
    public int[] getDeck(){
        return deck;
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
    
    
}
    

