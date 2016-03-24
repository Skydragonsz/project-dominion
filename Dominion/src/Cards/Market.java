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
public class Market extends ActionCards{
    private final int cardID = 29;
    private final int cost = 5;
    
    public Market(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addCoin(1);
        player.addBuy(1);
        player.addAction(1);
        player.setNthAmountOfCards(1);
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
