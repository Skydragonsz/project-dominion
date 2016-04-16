/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.BaseSet;

import cards1.Maincards.ActionCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is DONE
public class Festival extends ActionCards{
    private final int cardID = 26;
    private final int cost = 5;
    private final String name = "Festival";
    
    public Festival(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addCoin(2);
        player.addBuy(1);
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
