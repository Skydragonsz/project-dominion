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
public class Laboratory extends ActionCards{
    private final int cardID = 26;
    private final int cost = 5;
    
    public Laboratory(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.setNthAmountOfCards(2);
        player.addAction(1);
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
