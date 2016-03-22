package Tester;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.*;
/**
 *
 * @author Arthur
 */
public class PlayerTester {
    
    public Player p = new Player();
    
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
        
        p.getFirstFiveCards();
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testGetCards(){
        
        System.out.println(p.getCards(1));
    }

}
