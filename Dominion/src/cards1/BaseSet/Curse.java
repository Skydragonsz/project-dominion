/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.BaseSet;

import cards1.Maincards.VictoryCards;

/**
 *
 * @author Arthur
 */
//Card is DONE
public class Curse extends VictoryCards{
    private final int cardID = 7;
    private final int victoryValue = -1;
    private final int cost = 0;
    private final String name = "Curse";
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getVictoryValue(){
        return victoryValue;
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
