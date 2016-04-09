/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.MainSet;

import cards.Maincards.ActionCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */

//
public class Chancellor extends ActionCards{
    private final int cardID = 11;
    private final int cost = 3;
    private final String name = "Chancellor";
    private final String info = "You may immediately put your deck into your discard pile.";
    
    public Chancellor(){
        
    }
    
    @Override
    public void playCard(Player player){
        
        player.addCoin(2);
        
        
        //You !!MAY!! immediately put your deck into your sicard pile.
        //TODO -- keuze -- mss in EffectPhase
        player.discardDeckToPile();
        
        
    }
    
    @Override
    public String getInfo(){
        return info;
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
