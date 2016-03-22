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
    private int[] test = new int[]{1,1,1,1,1,4,4,4};
    
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
    public void testGetCards(){
        assertArrayEquals(p.shuffleDeck(test),test);

        
    }

}
