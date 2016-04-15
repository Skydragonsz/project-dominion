/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.BaseSet;

import cards.Functions.Collection;
import cards.Maincards.ActionCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is NOT DONE
public class Moneylender extends ActionCards{
    private final int cardID = 19;
    private final int cost = 4;
    private final String name = "Moneylender";
    
    public Moneylender(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
        //if coper to TRASH; +3 coins
        //boolean initialiseren op true, speler de keuze geven om dit effect uit te voeren (knop?)
        //if (col.getCard(player.getCardInHand(index)).getName()="Copper")
        //remove card
        boolean decision = true;
        Collection collection = new Collection();
        //TODO Check integratie Front-end (Positie moet door de Front-end meegegeven worden)
        int cardPosition = 6;
        if (decision == true){
            if (collection.getCard(player.getCardInHand(cardPosition)).getName() == "Copper"){
               player.removeNthCardFromHand(cardPosition);
               player.addCoin(3);
            };
            
        }
            
    }
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    
}
