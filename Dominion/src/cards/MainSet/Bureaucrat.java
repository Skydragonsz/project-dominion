/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.MainSet;

import cards.Functions.Collection;
import cards.Maincards.AttackCards;
import dominion.Player;

/**
 *
 * @author Arthur
 */

//TODO -- FIX THIS
public class Bureaucrat extends AttackCards{
    private final int cardID = 15;
    private final int cost = 4;
    private final String name = "Bureaucrat";
    
    public Bureaucrat(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addCardToDeck(2);
        System.out.println("VOOR LOOP" + (player.getPlayerList().size()-1) );
        
        for(int index = 0; index < player.getPlayerList().size()-1 ; index++){
            
            //int I is BROKEN! Zit steeds in de loop vast
            
            
            System.out.println("IN EERSTE LOOP " + index);
            
            Collection col = new Collection();
            
            int cardIndex = 0;
            for(int j = 0; j < player.getOtherPlayersList(player).get(index).getCardsInHand().size();j++){
                
                System.out.println("IN TWEEDE LOOP");
                
                if ("VICTORY".equals(col.getCard(player.getCardsInHand().get(cardIndex)).getCardType())){
                    player.getOtherPlayersList(player).get(index).getDeck().add(0,player.getOtherPlayersList(player).get(index).getCardsInHand().get(cardIndex));
                    player.getOtherPlayersList(player).get(index).getCardsInHand().remove(cardIndex);
                    
                    j = player.getOtherPlayersList(player).get(index).getCardsInHand().size() +1;
                    System.out.println("IN DE IF");

                }
                cardIndex++;


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
