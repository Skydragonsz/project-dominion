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
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Quinten
 */
public class PhaseTest {
    Cards.Collection col = new Cards.Collection();
    ActionPhase Pl = new ActionPhase();
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

    Pl.placeCard(col.getCard(31), p1, p2);
       
    System.out.println(p1.getDeck());
    System.out.println(p1.getCards());
    System.out.println(p2.getDeck());
    System.out.println(p2.getCards());
    System.out.println("^WITCH EFFECT STATE^");
    System.out.println(col.getCard(31).getCardType());
    
 
    }
}