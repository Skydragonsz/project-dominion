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
public class Duchy extends VictoryCards{
    private final int cardID = 5;
    private final int victoryValue = 3;
    private final int cost = 5;
    private final String name = "Duchy";
    
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

