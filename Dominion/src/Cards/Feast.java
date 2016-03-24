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
public class Feast extends ActionCards{
    private final int cardID = 15;
    private final int cost = 4;
    
    public Feast(){
        
    }
    
    @Override
    public void playCard(Player player){
        //TODO -- EffectPhase
    }
    
    public int getCost(){
        return cost;
    }
    
    @Override
    public int getCardID(){
        return cardID;
    }
    
}
