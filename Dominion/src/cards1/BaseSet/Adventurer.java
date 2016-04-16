/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.BaseSet;

import cards1.Functions.Collection;
import cards1.Maincards.ActionCards;
import dominion.Player;


/**
 *
 * @author Arthur
 */

//Card is DONE



public class Adventurer extends ActionCards{
    private final int cardID = 32;
    private final int cost = 6;
    private final String name = "Adventurer";
    //TODO -- hebben we een info nodig? of gaat dit in de database staan?
    private final String info = "Reveal cards from yout deck until you reveal 2 treasure cards. Put those Treasure cards into your hand and discard the other revealed cards.";
    
    
    
    public Adventurer(){
        
    }
    
    @Override
    public void playCard(Player player){
        
        Collection col = new Collection();
        int cards = 0;
        int indexCounter = 0;
        while(cards <2){
            if ("TREASURE".equals(col.getCard(player.getDeck().get(indexCounter)).getCardType())){
                player.getCardsInHand().add(player.getDeck().get(indexCounter));
                player.getDeck().remove(indexCounter);
                cards++;
                indexCounter--;
                
            }
            indexCounter++;
        }
    }
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public String getInfo(){
        return info;
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
