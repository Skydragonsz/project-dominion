/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.BaseSet;

import cards1.Maincards.TreasureCards;

/**
 *
 * @author Arthur
 */
//Card is DONE
public class Gold extends TreasureCards{
    private final int cardID = 3;
    private final int value = 3;
    private final int cost = 6;
    private final String name = "Gold";
    
    @Override
    public int getValue(){
        return value;
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
