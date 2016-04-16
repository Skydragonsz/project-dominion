/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.BaseSet;

import cards.Maincards.ActionCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is NOT DONE
public class Library extends ActionCards{
    private final int cardID = 28;
    private final int cost = 5;
    private final String name = "Library";
    
    public Library(){
        
    }
    
    @Override
    public void playCard(Player player){
        int amount = player.getCardsInHand().size();
        amount = 7 - amount;
        player.setNthAmountOfCards(amount);
        //TODO -- if action card, ask if you want to keep it!
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
