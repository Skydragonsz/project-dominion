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
public class Witch extends AttackCards{
    private final int cost = 5;
    
    
    
    public Witch(){
<<<<<<< HEAD
        //TODO - Curse++;
=======
        
        
    }

    
    public static void playCard(Player player,Player otherPlayer, Turn turn){
        turn.removeAction(1);
        player.setNthAmountOfCards(2);
        otherPlayer.AddCard(7);


>>>>>>> refs/remotes/origin/Quinten
    }
    
    public int getCost(){
        return cost;
    }
    
}
