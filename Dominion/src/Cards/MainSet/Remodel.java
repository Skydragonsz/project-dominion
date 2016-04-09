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
public class Remodel extends ActionCards{
    private final int cardID = 20;
    private final int cost = 4;
    private final String name = "Remodel";
    
    public Remodel(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
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
