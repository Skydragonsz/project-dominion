/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import dominion.GameEngine;
import dominion.VictoryPoints;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class VictoryPointsTester {
    private VictoryPoints vp = new VictoryPoints();
    private GameEngine ge = new GameEngine();
    
    public VictoryPointsTester() {
    }
    
    
    @Test
    public void testVictoryPoints(){
        ge.setAmountPlayers(3);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(6);
        ge.getPlayer(1).addCardToDeck(5);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(1);
        ge.getPlayer(1).addCardToDeck(17);
        ge.getPlayer(1).addCardToDeck(17);
        ge.getPlayer(1).addCardToDeck(7);
        
        
        
        System.out.println("Deck size: "+ge.getPlayer(1).getDeck().size());
                
        //22 cards in deck 2 
        //1+1+1 = 3+6+6+3 + 2 van garden
        //
        vp.victoryPointsCalc(ge);
        System.out.println(ge.getPlayer(1).getVictoryPoints());
        assertEquals(ge.getPlayer(1).getVictoryPoints(),15);
        
    }
}
