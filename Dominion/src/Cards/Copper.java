/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author Arthur
 */
public class Copper extends TreasureCards{
    private final int cardID = 1;
    private final int value = 1;
    private final int cost = 0;
    private final String name = "Copper";
    
    public int getValue(){
        return value;
    }
    
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
