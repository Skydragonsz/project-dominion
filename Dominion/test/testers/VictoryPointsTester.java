/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Card;
import dominion.GameEngine;
import dominion.VictoryPoints;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class VictoryPointsTester {
    private VictoryPoints vp = new VictoryPoints();
    private GameEngine ge = new GameEngine();
    
    
    
    private Card province;
    private Card copper;
    private Card duchy;
    private Card garden;
    private Card curse;
    
    private void initTestVictoryPoints(){
    	ge.initConnection();
    	province = ge.CallCard("Province");
    	copper = ge.CallCard("Copper");
        duchy = ge.CallCard("Duchy");
        garden = ge.CallCard("Garden");
        curse = ge.CallCard("Curse");
    	
    }
    public VictoryPointsTester() {
    }
    
    
    @Test
    public void testVictoryPoints(){
    	initTestVictoryPoints();
        ge.initAmountPlayers(3);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(province);//6
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(duchy);//3
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(duchy);//3
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(garden);//1 omdat gehele deling 17/10 = 1
        ge.getPlayer(1).getDeck().add(garden);//1 omdat gehele deling 17/10 = 1
        ge.getPlayer(1).getDeck().add(curse);//-1
        
        
        
        System.out.println("Deck size: "+ge.getPlayer(1).getDeck().getAmount());
                
        //6+3+3+1+1-1 = 13
        //
        vp.victoryPointsCalc(ge);
        System.out.println(ge.getPlayer(1).getVictoryPoints());
        assertEquals(ge.getPlayer(1).getVictoryPoints(),13);
        
    }
}
