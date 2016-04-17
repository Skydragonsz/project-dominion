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

import dominion.Card;
import dominion.Pile;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Quint
 */
public class nonHardCodedCardsTester {

    private Card village = new Card("Village", "Action", "description", 3, 0, 0, 1, 2, 0, false);
    private Card gold = new Card("Gold", "Treasure", "description", 6, 3, 0, 0, 0, 0, false);
    private Pile goldPile = new Pile(gold,30); 
    private Pile pileOfTwo;
    
    private Pile deck = new Pile(gold,gold,gold,gold,gold,gold,gold,village,village,village);
    private Pile hand = new Pile();
    
    public nonHardCodedCardsTester() {
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
    public void testGetVillageName() {
        System.out.println(village.getName());
        assertEquals(village.getName(), "Village");
    }
    
    @Test
    public void testMake30GoldCards() {
        
        System.out.println(goldPile.getPile());
        assertEquals(goldPile.getAmount(),30);
    }
    
    @Test
    public void testMakePileOfCards() {
        pileOfTwo = new Pile(village, gold);
        System.out.println(pileOfTwo.getPile());
        ArrayList resultPile = new ArrayList(Arrays.asList(village,gold));
        assertEquals(pileOfTwo.getPile(),resultPile);
    }
    
    @Test
    public void testAddGoldCardToHandFromDeck(){
        System.out.println("BEFORE");
        System.out.println(hand.getPile());
        System.out.println(deck.getPile());
    
        hand.addFrom(gold, deck);
        System.out.println("AFTER");
        System.out.println(hand.getPile());
        System.out.println(deck.getPile());
        
        ArrayList resultPile = new ArrayList(Arrays.asList(gold));
        assertEquals(hand.getPile(),resultPile);
    }
}
