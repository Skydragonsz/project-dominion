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
public class ActionCards extends MainCard{
    
    private String TYPE= "ACTION";
    
    private int amountOfActions = 1;
    
    
    
    @Override
    public String getCardType(){
        return TYPE;
    }
    
    public void lowerActions(){
        amountOfActions--;
    }
    


}
