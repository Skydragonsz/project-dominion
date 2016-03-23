/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;
import dominion.Player;
import dominion.Turn;
/**
 *
 * @author Arthur
 */
public class Witch extends ActionCards{
    private final int cost = 5;
    private String TYPE= "ACTION";
    
    
    public String getCardType(){
        return TYPE;
    }
    
    public Witch(){

    }

    
    public void playCard(Player player,Player otherPlayer){
        //turn.removeAction(1);
        System.out.println("WITCH EFFECT");
        player.setNthAmountOfCards(2); //HAND
        otherPlayer.AddCard(7); //Add Curse card DECK
    }
    
    public int getCost(){
        return cost;
    }
}
