/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.BaseSet;

import cards.Maincards.ActionCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is DONE
public class Woodcutter extends ActionCards{
    private final int cardID = 13;
    private final int cost = 3;
    private final String name = "Woodcutter";
    public Woodcutter(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addCoin(2);
        player.addBuy(1);
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
