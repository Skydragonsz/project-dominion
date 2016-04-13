/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.MainSet;

import cards.Maincards.AttackCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */
//Card is NOT DONE
public class Militia extends AttackCards{
    private final int cardID = 18;
    private final int cost = 4;
    private final String name = "Militia";
    public Militia(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- player may chose which card to discard
        player.addCoin(2);
        for(int i = 0; i < player.getPlayerList().size()-1;i++){
            if(!player.getOtherPlayersList(player).get(i).checkForReactionCard()){
                //TODO -- fix this
                //player.getOtherPlayersList(player).get(i).
            }
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
