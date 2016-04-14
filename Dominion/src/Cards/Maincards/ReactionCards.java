/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.Maincards;
import dominion.Player;
/**
 *
 * @author Arthur
 */
public class ReactionCards extends ActionCards{
    private final String TYPE= "REACTION";
    
    
    public void reactionPlay(Player player){
        
    }   
    
    public void reactionPlay(Player player,Player otherPlayer){
        
    }   
    
    @Override
    public String getCardType(){
        return TYPE;
    }
    
}
