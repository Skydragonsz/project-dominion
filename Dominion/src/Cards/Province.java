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
    private final int cardID = 6;
    private final int victoryValue = 6;
    private final int cost = 8;
    
    public int getCost(){
        return cost;
    }
    
    public int getVictoryValue(){
        return victoryValue;
    }
}
