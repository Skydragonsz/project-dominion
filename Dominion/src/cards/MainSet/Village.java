/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.MainSet;

import cards.Maincards.ActionCards;
import dominion.Player;


/**
 *
 * @author Arthur
 */
public class Village extends ActionCards{
    private final int cardID = 12;
    private final int cost = 3;
    private final String name = "Village";
    public Village(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.drawCards(1); //HAND
        player.addAction(2);        
    }
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
}
