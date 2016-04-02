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
import dominion.GameEngine;
import dominion.phase.ActionPhase;


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
    private Collection col = new Collection();
    private GameEngine ge = new GameEngine();
    private ActionPhase ap = new ActionPhase();

    
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
    
    @Test
    public void testGetName(){
        System.out.println(col.getCard(12).getName());
    }
    
    @Test
    public void testAdventurer(){
        System.out.println(p.getDeck());
        col.getCard(32).playCard(p);
        System.out.println(p.getDeck());
        System.out.println(p.getCardsInHand());
    }
    
    @Test
    public void testBureaucrat(){
        ge.reset();
        ge.setAmountPlayers(3);
        ge.setName(1, "Bob");
        ge.setName(2, "Ross");
        ge.setName(3, "Arthur");
        
        
        
        
        ge.getPlayer(1).addCardToHand(1);
        ge.getPlayer(1).addCardToHand(6);
        ge.getPlayer(1).addCardToHand(3);
        
        ge.getPlayer(2).addCardToHand(1);
        ge.getPlayer(2).addCardToHand(3);
        ge.getPlayer(2).addCardToHand(3);
        
        ge.getPlayer(3).addCardToHand(15);
        ge.getPlayer(3).addCardToHand(5);
        ge.getPlayer(3).addCardToHand(1);
        ge.getPlayer(3).addCardToHand(13);
        
        
        
        
        for(int i = 1; i <= ge.getPlayerList().size() ; i++){
            System.out.println(ge.getPlayer(i).getName() + " "+ ge.getPlayer(i).getCardsInHand());
        }
        
        ap.placeCard(col.getCard(15), ge.getPlayer(3));
        
        
        for(int i = 1; i <= ge.getPlayerList().size() ; i++){
            System.out.println("AFTER: "+ge.getPlayer(i).getName() + " "+ ge.getPlayer(i).getCardsInHand());
        }
        
    }
}
