/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import dominion.Card;
import dominion.GameEngine;
import dominion.Pile;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Quint
 */
public class nonHardCodedCardsTester {
	
    private GameEngine gameEngine = new GameEngine();
    
    private Card village;
    private Card gold;
    private Pile goldPile;    
    private Pile pileOfTwo;
    
    private Pile deck;
    private Pile hand = new Pile();
    
    private Card province;
    private Pile provincePile;
    private Board board;
    
    public nonHardCodedCardsTester() {
    	gameEngine.initConnection();
    	
        village = gameEngine.CallCard("Village");
        gold = gameEngine.CallCard("Gold");
        province = gameEngine.CallCard("Province");
        
        deck = new Pile(gold,gold,gold,gold,gold,gold,gold,village,village,village);
        provincePile = new Pile(province,1);
        goldPile = new Pile(gold,30);
        board = new Board(goldPile, provincePile);
        
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
  
    @Test
    public void testIsProvincePileEmpty() {
        System.out.println("board " + board);
        System.out.println("province " + provincePile.getPile());
        System.out.println(provincePile.getAmount());
        provincePile.remove(province);
        System.out.println(provincePile.getAmount());
        System.out.println(board.isGameEnding());
        System.out.println(board.isProvinceEmpty());
        
        
        assertTrue(board.isGameEnding());
    }
}
