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
public class TreasureCards extends MainCard{
    private final String TYPE= "TREASURE";
    
    private int amountOfBuys = 1;
    
    @Override
    public String getCardType(){
        return TYPE;
    }
    
    public void lowerBuys(){
        amountOfBuys--;
    }
}
