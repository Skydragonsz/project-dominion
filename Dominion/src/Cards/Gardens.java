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
public class Gardens extends VictoryCards{
    private final int cardID = 17;
    private final int cost = 4;
    
    public Gardens(){
        
    }
    

    
    public int getCost(){
        return cost;
    }
    
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
