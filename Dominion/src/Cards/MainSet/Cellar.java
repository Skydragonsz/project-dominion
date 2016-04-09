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
public class Cellar extends ActionCards{
    private final int cardID = 8;
    private final int cost = 2;
    private final String name = "Cellar";
    
    public Cellar(){
        
        
    }
    
    @Override
    public void playCard(Player player){
        
        System.out.println("VILLAGE EFFECT");
       // player.setNthAmountOfCards(1); //HAND TODO -- 
        player.addAction(1);
        System.out.println("Extra action:" + player.getAction());
        
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