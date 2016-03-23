package Tester;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.*;
import java.util.Arrays;
/**
 *
 * @author Arthur
 */
public class PlayerTester {
    
    private Player p = new Player();

    //private int[] test = new int[]{1,1,1,1,1,4,4,4};
   
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
    
    assertEquals(p.getDeck(),"7 5 5 5 1 1 ");

        
    }
    
    @Test
    public void testShuffle(){
        p.shuffleDeck();
    assertEquals(p.getDeck(),"7 5 5 5 1 1 ");

    }
    /*
    @Test
    public void testShuffleDeck(){
    p.shuffleDeck(p.getDeck());
    assertEquals(p.getLinkedCards(),"7 5 5 5 1 1 ");

        
    }*/
    
    @Test
    public void testGetHand(){
    System.out.println(p.getDeck());
    System.out.println(p.getCards());
    System.out.println("^BEGIN STATE^");
    
    p.shuffleDeck();
    System.out.println(p.getDeck());
    System.out.println("^SHUFFLE^");  
    
    p.setNthAmountOfCards(2);
    System.out.println(p.getDeck());
    System.out.println(p.getCards());
    assertEquals(p.getCards(),"7 5 5 5 1 1 ");
    
    }
    
    @Test
    public void testPrintedCardsAfter(){
    
    assertEquals(p.getDeck(),"7 5 5 5 1 1 ");

        
    }    
    
    
}
