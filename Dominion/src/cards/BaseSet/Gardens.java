/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.BaseSet;

import cards.Maincards.VictoryCards;

/**
 *
 * @author Arthur
 */
//Card is DONE
public class Gardens extends VictoryCards{
    private final int cardID = 17;
    private final int cost = 4;
    private final String name = "Garden";
    
    public Gardens(){
        
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
