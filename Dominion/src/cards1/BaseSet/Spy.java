/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.BaseSet;

import cards1.Maincards.AttackCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is NOT DONE
public class Spy extends AttackCards{
    private final int cardID = 22;
    private final int cost = 4;
    private final String name = "Spy";
    
    public Spy(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
        player.setNthAmountOfCards(1);
        player.addAction(1);
        
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
