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
public class Estate extends VictoryCards{
    private final int cardID = 4;
    private final int victoryValue = 1;
    private final int cost = 2;
    private final String name = "Estate";
    
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
