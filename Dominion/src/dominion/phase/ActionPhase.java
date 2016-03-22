/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import dominion.*;
/**
 *
 * @author Quinten

public class ActionPhase {
    
    
    public void placeCard(MainCard card, Player p){
        
        if (card.getType() == "ACTION"){
            //RUN FUNCTION OF SAID CARD
            p.discardCard("CURRENT CARD");
        
        }else{
            placeCard(card);
        };
        
    }
}*/
