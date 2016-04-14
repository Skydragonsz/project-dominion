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
//Card is NOT DONE
public class Feast extends ActionCards{
    private final int cardID = 15;
    private final int cost = 4;
    private final String name = "Feast";
    
    public Feast(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- look if this works
        player.removeNthCardFromPlayingField(player.getPlayingField().indexOf(15));
        player.addInstancedCoin(5);
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
