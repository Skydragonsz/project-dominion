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
public class Smithy extends ActionCards{
    private final int cardID = 21;
    private final int cost = 4;
    
    public Smithy(){
        
    }
    
    public void playCard(Player player){
        player.setNthAmountOfCards(3);
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
}
