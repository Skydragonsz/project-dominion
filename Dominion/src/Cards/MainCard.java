/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import dominion.Player;
import dominion.Turn;

/**
 *
 * @author Arthur
 */
public class MainCard{
    private String TYPE;
    
    public String getCardType(){
        return TYPE;
    }
    
    
    public void playCard(Player player,Player otherPlayer){
        System.out.println("DIT IS DE MAIN CARD.");
    }
}
