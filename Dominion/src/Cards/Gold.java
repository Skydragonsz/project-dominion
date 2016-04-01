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
public class Gold extends TreasureCards{
    private final int cardID = 3;
    private final int value = 3;
    private final int cost = 6;
    private final String name = "Gold";
    
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
