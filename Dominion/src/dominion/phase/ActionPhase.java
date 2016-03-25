/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import Cards.MainCard;
import dominion.*;
/**
 *
 * @author Quinten
*/
public class ActionPhase{ 

    public void placeCard(MainCard card, Player p, Player otherPlayer){
        
        
        p.removeAction(1);
        if ("ATTACK".equals(card.getCardType())){
            
            //p.AddToPlayingField(card.GetID());
            //p.RemoveNthCard(card.GetID());
            
            card.playCard(p,otherPlayer);
            p.addToPlayingField(card.getCardID());

            
            
        }else if("ACTION".equals(card.getCardType()) || "REACTION".equals(card.getCardType())){
            card.playCard(p);
            p.addToPlayingField(card.getCardID());
        }
        
    }
}
