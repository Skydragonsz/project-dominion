/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Cards.*;
import Cards.Witch;
import dominion.Player;
import dominion.Turn;

/**
 *
 * @author Arthur
 */
public class CardsTester {
    private Player p = new Player();
    private Player p2 = new Player();
    private Witch w = new Witch();
    private Witch w2;
    private Copper c = new Copper();
    private Province pro = new Province();
    private Duchy du = new Duchy();
    private Turn t = new Turn();
    
    public CardsTester() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetTypeWitch(){
        assertEquals(w.getCardType(), "ACTION");
        
    }
    
    @Test
    public void testGetTypeCopper(){
        assertEquals(c.getCardType(),"TREASURE");
        
    }
    
    
    
    @Test
    public void testGetCostOfProvince(){
        assertEquals(pro.getCost(),8);
        
    }
    
    @Test
    public void testVictoryPoints(){
        int VictoryPoints = 0;
        VictoryPoints += pro.getVictoryValue();
        VictoryPoints += du.getVictoryValue();
        VictoryPoints += pro.getVictoryValue();
        
        
        assertEquals(VictoryPoints,15);
        
    }
    
    

    
    @Test
    public void testWitchMetFunctie(){

        p.shuffleDeck();

        p.setNthAmountOfCards(5);
        p2.setNthAmountOfCards(5);

        w2.playCard(p,p2,t);
        assertEquals(t.getAction(),0);

        
        
        
    }
}
