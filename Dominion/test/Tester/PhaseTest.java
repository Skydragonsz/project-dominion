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
import dominion.phase.ActionPhase;
import Cards.*;
import dominion.Player;
/**
 *
 * @author Quinten
 */
public class PhaseTest {
    ActionPhase Pl = new ActionPhase();
    Witch w1 = new Witch();
    Village v1 = new Village();
    Player p1 = new Player();
    Player p2 = new Player();

    public PhaseTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void AddOneWitch(){
    System.out.println(p1.getDeck());
    System.out.println(p1.getCards());
    System.out.println(p2.getDeck());
    System.out.println(p2.getCards());
    System.out.println("^BEGIN STATE^");
 
       Pl.placeCard(v1, p1, p2);
       
    System.out.println(p1.getDeck());
    System.out.println(p1.getCards());
    System.out.println(p2.getDeck());
    System.out.println(p2.getCards());
    System.out.println("^WITCH EFFECT STATE^");
    System.out.println(v1.getCardType());
    
 
    }
}