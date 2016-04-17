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
public class CouncilRoom extends ActionCards{
    private final int cardID = 25;
    private final int cost = 4;
    private final String name = "Council room";
    
    public CouncilRoom(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addBuy(1);
        player.drawCards(4);
        
                
        for(int i = 0; i < gameEngine.getPlayerList().size()-1;i++){
            gameEngine.getOtherPlayersList(player).get(i).drawCards(1);
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
