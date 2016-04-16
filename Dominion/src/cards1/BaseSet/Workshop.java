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
public class Workshop extends ActionCards{
    private final int cardID = 14;
    private final int cost = 3;
    private final String name = "Workshop";
    
    public Workshop(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
        player.addInstancedCoin(4);
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