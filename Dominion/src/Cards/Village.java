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
public class Village extends ActionCards{
    private final int cardID = 12;
    private final int cost = 3;
    public Village(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.setNthAmountOfCards(1); //HAND
        player.addAction(2);        
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}