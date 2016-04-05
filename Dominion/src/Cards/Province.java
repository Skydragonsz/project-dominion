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
public class Province extends VictoryCards{
    private static final int cardID = 6;
    private final int victoryValue = 6;
    private final int cost = 8;
    private final String name = "Procince";
    
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
