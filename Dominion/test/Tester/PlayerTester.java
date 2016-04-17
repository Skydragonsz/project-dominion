package Tester;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Arthur
 */
//Since these tests were during earlier development they don't work anymore.
//Need to correct what these tests check in the assertEquals.
public class PlayerTester {
    
    private Player p = new Player();

    //testArrayDeck is de kaarten dat het begindeck bevat.
    //1 = copper & 4 = estate.    
    List<Integer> testArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    List<Integer> testArrayHand = new ArrayList<>(Arrays.asList(1, 1, 1));
   
    public PlayerTester() {
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
    public void testPrintedCards(){
        assertEquals(p.getCardsInDeck(),testArrayDeck);
    }
    
    @Test
    public void testShuffle(){
    //Het deck van de player p word geschud.
        System.out.println(p.getCardsInDeck());
        p.shuffleDeck();
        System.out.println(p.getCardsInDeck());
    //Kijk als deze deck niet gelijk is aan de begin deck.
        assertTrue(p.getCardsInDeck() != testArrayDeck);
    } 
        
    @Test
    public void testDiscardDeckToPile(){
    //+Visuele feedback.    
        System.out.println("Deck"+p.getCardsInDeck());
        System.out.println("Hand"+p.getCardsInHand());
        System.out.println("Discard pile "+p.getDiscardPile());
        System.out.println("^BEGIN STATE^");
        
        //Het deck shudden.
        ////p.shuffleDeck();
        ////System.out.println(p.getDeck());
        ////System.out.println("^SHUFFLE^");  
        
        //Pakt drie kaarten van het deck.    
        p.drawCards(3);
        
        //Discard deze kaarten.
        p.discardDeckToPile();
        System.out.println("Discard pile "+p.getDiscardPile());
        System.out.println("Deck "+p.getCardsInDeck());
        System.out.println("Cards in hand"+p.getCardsInHand());
        System.out.println("^Discard pile vol^");
        
        //
        p.drawCards(5);
        System.out.println("Discard pile "+p.getDiscardPile());
        
        System.out.println("Deck "+p.getCardsInDeck());
        System.out.println("Cards in hand"+p.getCardsInHand());
        assertEquals(p.getCardsInHand(), testArrayHand);

    
    }
    
    
    
}
