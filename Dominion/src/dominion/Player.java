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
import java.lang.Math.*;

public class Player{
    //private String[] cards = new String[];
    //private String[] firstHand 
    private int[] deck = new int[7];    
    private int victoryPoints;
    private String name;
        
        
    public Player()
    {
        System.out.println("Test");
        init();
        System.out.println(ShuffleDeck(deck));
        
    }
    
    public void init(){
        this.deck = new int[]{1,1,1,1,1,1,1,4,4,4};   
    }
    
    public int[] ShuffleDeck(int[] array){
		Random rgen = new Random();
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
   
    public int[] getCards()
    {
        return deck;
    }
    
    

}
    

