/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.MainSet;

import cards.Functions.Collection;
import cards.Maincards.AttackCards;
import dominion.GameEngine;
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
    private GameEngine gameEngine = new GameEngine();

    public Bureaucrat(){
        
    }
    
    @Override
    public void playCard(Player player){
        player.addCardToDeck(2);
        System.out.println("VOOR LOOP" + (gameEngine.getPlayerList().size()-1) );
        
        for(int index = 0; index < gameEngine.getPlayerList().size()-1 ; index++){
            
            //int I is BROKEN! Zit steeds in de loop vast
            
            
            System.out.println("IN EERSTE LOOP " + index);
            
            Collection col = new Collection();
            
            int cardIndex = 0;
            for(int j = 0; j < gameEngine.getOtherPlayersList(player).get(index).getCardsInHand().size();j++){
                
                System.out.println("IN TWEEDE LOOP");
                
                if ("VICTORY".equals(col.getCard(player.getCardsInHand().get(cardIndex)).getCardType())){
                    gameEngine.getOtherPlayersList(player).get(index).getCardsInDeck().add(0,gameEngine.getOtherPlayersList(player).get(index).getCardsInHand().get(cardIndex));
                    gameEngine.getOtherPlayersList(player).get(index).getCardsInHand().remove(cardIndex);
                    
                    j = gameEngine.getOtherPlayersList(player).get(index).getCardsInHand().size() +1;
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
