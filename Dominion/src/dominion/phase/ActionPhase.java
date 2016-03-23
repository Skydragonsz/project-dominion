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
        
        if (card.getCardType() == "ACTION"){
            card.playCard(p,otherPlayer);
            //p.AddToPlayingField(card.GetID());
            //p.RemoveNthCard(card.GetID());
            p.removeAction(1);
            
            
        }else{
            placeCard(card, p, otherPlayer);
        }
        
    }
}
