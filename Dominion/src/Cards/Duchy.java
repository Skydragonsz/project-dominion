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
public class Duchy extends VictoryCards{
    private final int cardID = 5;
    private final int victoryValue = 3;
    private final int cost = 5;
    
    public int getCost(){
        return cost;
    }
    
    public int getVictoryValue(){
        return victoryValue;
    }
    
}

