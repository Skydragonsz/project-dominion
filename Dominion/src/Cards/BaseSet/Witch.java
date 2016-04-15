/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.BaseSet;
import cards.Maincards.AttackCards;
import dominion.GameEngine;
import dominion.Player;

/**
 *
 * @author Arthur
 */

//Card is DONE
//TODO Clean the code up!!!
public class Witch extends AttackCards{
    private final int cardID = 31;
    private final int cost = 5;
    private final String name= "Witch";

    
    public Witch(){

    }
           
    @Override
    public void playCard(Player player){
        player.setNthAmountOfCards(2);
        
        
        for(int i = 0; i < player.getPlayerList().size()-1;i++){
            if(!player.getOtherPlayersList(player).get(i).checkForReactionCard()){
                player.getOtherPlayersList(player).get(i).addCardToDeck(7); //Add Curse card DECK
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
