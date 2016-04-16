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
//Card is NOT DONE
public class Mine extends ActionCards{
    private final int cardID = 30;
    private final int cost = 5;
    private final String name = "Mine";
    public Mine(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
        //Trash Treasurecard; getValue + 3
        player.addInstancedCoin(3);
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
