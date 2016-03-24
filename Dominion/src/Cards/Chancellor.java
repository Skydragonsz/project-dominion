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
public class Chancellor extends ActionCards{
    private final int cardID = 11;
    private final int cost = 3;
    
    public Chancellor(){
        
    }
    
    @Override
    public void playCard(Player player){
        
        player.addCoin(2);
        player.discardDeckToPile();
        player.isDeckEmpty(true);
        
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
