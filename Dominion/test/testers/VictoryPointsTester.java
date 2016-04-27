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
    private Card province = new Card("Province","VICTORY","none", 0,6,0,0,0,0,false);
    private Card copper = new Card("Copper","TREASURE","none", 0,0,0,0,0,0,false);
    private Card ducky = new Card("Duchy","VICTORY","none", 0,3,0,0,0,0,false);
    private Card garden = new Card("Garden","VICTORY","none", 0,0,0,0,0,0,false);
    private Card curse = new Card("Curse","VICTORY","none", 0,-1,0,0,0,0,false);
    public VictoryPointsTester() {
    }
    
    
    @Test
    public void testVictoryPoints(){
        ge.initAmountPlayers(3);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(province);//6
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(ducky);//3
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(ducky);//3
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(copper);
        ge.getPlayer(1).getDeck().add(garden);//1 omdat gehele deling 17/10 = 1
        ge.getPlayer(1).getDeck().add(garden);//1 omdat gehele deling 17/10 = 1
        ge.getPlayer(1).getDeck().add(curse);//-1
        
        
        
        System.out.println("Deck size: "+ge.getPlayer(1).getDeck().getPile().size());
                
        //6+3+3+1+1-1 = 13
        //
        vp.victoryPointsCalc(ge);
        System.out.println(ge.getPlayer(1).getVictoryPoints());
        assertEquals(ge.getPlayer(1).getVictoryPoints(),13);
        
    }
}
