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
    private Province province = new Province();
    private KingdomCards set = new KingdomCards();

    
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
        assertEquals(w.getCardType(), "ATTACK");
        
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
    public void testRandomSet(){
          set.generateRandomSet();
        
        //assertTrue(set.getDeck() != testArrayDeck);
        
    }
}
