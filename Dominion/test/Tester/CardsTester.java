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

/**
 *
 * @author Arthur
 */
public class CardsTester {
    private Witch w = new Witch();
    private Copper c = new Copper();
    
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGetTypeWitch(){
        System.out.println("testGetTypeWitch " + w.getCardType());
    }
    
    @Test
    public void testGetTypeCopper(){
        System.out.println("testGetTypeCopper " + c.getCardType());
    }
}
