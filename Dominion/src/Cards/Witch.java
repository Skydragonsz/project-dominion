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
public class Witch extends AttackCards{
    private final int cardID = 31;
    private final int cost = 5;

    
    public Witch(){

    }
   
    @Override
    public void playCard(Player player,Player otherPlayer){
        player.setNthAmountOfCards(2); //HAND
        otherPlayer.AddCard(7); //Add Curse card DECK
    }
    
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
}
