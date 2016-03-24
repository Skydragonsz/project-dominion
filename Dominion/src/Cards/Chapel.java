/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import dominion.Player;

/**
 *
 * @author Arthur
 */
public class Chapel extends ActionCards{
    private final int cardID = 9;
    private final int cost = 2;
    
    public Chapel(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- Trash up to 4 cards in your hand.

        
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
