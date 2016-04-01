/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import dominion.Player;

/**
 *
 * @author Arthur
 */
public class Moat extends ReactionCards{
    private final int cardID = 10;
    private final int cost = 2;
    private final String name = "Moat";
    public Moat(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.setNthAmountOfCards(2);
    }
    
    @Override
    public void reactionPlay(Player player){
        //TODO -- Add reaction phase
    }   
    
    
    
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
