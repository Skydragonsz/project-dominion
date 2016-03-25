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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Quinten
 */
public class PhaseTest {
    final Cards.Collection col = new Cards.Collection();
    ActionPhase Pl = new ActionPhase();
    Player p1 = new Player();
    Player p2 = new Player();
    
    List<Integer> testArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    List<Integer> testEffectedArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 4, 4, 4));
    List<Integer> testArrayEffectedHand = new ArrayList<>(Arrays.asList(1, 1));
    List<Integer> testArrayEffectDeckOtherPlayer = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 7));
  
    
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
    //+Visual feedback
    System.out.println("Begin deck Player 1: " + p1.getDeck());
    System.out.println("Begin hand Player 1: " + p1.getCards());
    System.out.println("Begin deck Player 2: " + p2.getDeck());
    System.out.println("Begin hand Player 2: " + p2.getCards());
    System.out.println("^BEGIN STATE^");

    Pl.placeCard(col.getCard(31), p1, p2);
       
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + p1.getDeck());
    System.out.println("Effected hand Player 1 (+2 cards): " + p1.getCards());
    System.out.println("Effected deck Player 2 (+1 curse): " + p2.getDeck());
    System.out.println("Effected hand Player 2: " + p2.getCards());
    System.out.println("^WITCH EFFECT STATE^");
    System.out.println("Card Type: " + col.getCard(31).getCardType());
    //TODO: Kijk voor een manier om alle assertEquals weer te geven op de test results.
    assertEquals(p1.getDeck(),testEffectedArrayDeck);
    //assertEquals(p1.getCards(),testArrayEffectedHand);
    //assertEquals(p2.getDeck(),testArrayEffectDeckOtherPlayer);
    }
    
    @Test
    public void AddOneWitchWhenOtherPlayerHasAReactionCard(){
    p2.AddCardToHand(10);
    Pl.placeCard(col.getCard(31), p1, p2);
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + p1.getDeck());
    System.out.println("Effected hand Player 1 (+2 cards): " + p1.getCards());
    System.out.println("Effected deck Player 2 (geen curse): " + p2.getDeck());
    System.out.println("Effected hand Player 2(1 moat): " + p2.getCards());
    System.out.println("^WITCH EFFECT STATE^");
    assertEquals(p2.getDeck(),testArrayDeck);
    }
}