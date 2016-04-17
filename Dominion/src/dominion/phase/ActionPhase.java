/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import cards.Maincards.MainCard;
import dominion.*;

/**
 *
 * @author Quinten
*/
public class ActionPhase{ 

    public void placeCard(MainCard card, Player player){
        player.removeAction(1);
        if ("ATTACK".equals(card.getCardType())){
            card.playCard(player); //TODO -- Checken of we enkel player nodig hebben!
        //TODO: change this to include a function that checks all other players their hand for a reaction card
        }else if("ACTION".equals(card.getCardType()) || "REACTION".equals(card.getCardType())){
            card.playCard(player);
        }
        player.addCardToPlayingField(player.getCardsInHand().indexOf(card.getCardID()));
        
    }
}
