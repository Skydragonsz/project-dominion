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
        
        if (card.getCardType() == "ATTACK"){
            
            //p.AddToPlayingField(card.GetID());
            //p.RemoveNthCard(card.GetID());
            p.removeAction(1);
            if(otherPlayer.checkForReactionCard()){
                System.out.println("REACTION IN HAND");
                
            } else {
                System.out.println("NO REACTION IN HAND");
                card.playCard(p,otherPlayer);
                }
            
            
        }else if(card.getCardType() == "ACTION"){
            card.playCard(p);
        }
        
    }
}
