/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import Cards.MainCard;
import Cards.Witch;
import dominion.*;
/**
 *
 * @author Quinten
*/
public class ActionPhase{ 

    public void placeCard(Witch card, Player p, Player otherPlayer){
        
        if (card.getCardType() == "ACTION"){
            card.playCard(p,otherPlayer);
            //p.AddToPlayingField(card.GetID());
            //p.RemoveNthCard(card.GetID());
            
        }else{
            placeCard(card, p, otherPlayer);
        }
        
    }
}
