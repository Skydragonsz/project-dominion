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
import dominion.*;

/**
 *
 * @author Quinten
 */

    
public class TurnTester {

    public Turn n = new Turn(1);
    public TurnSegment ts = n.getCurrentTurnSegment();
    public TurnTester() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    ts.addAction(24);
    ts.addBuy(25);
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
    public void testAddFiveCoins(){
        ts.addCoin(5);
     assertEquals(ts.getCoin(), 5);
    }
    
    @Test
    public void testRemoveOneAction(){
        ts.removeAction(2);
        System.out.println(ts.getAction());
     assertEquals(ts.getAction(), 23);
    }
    
    @Test
    public void restRemoveBuysBelowZero(){
        ts.removeBuy(500);
        System.out.println(ts.getBuy());
     assertTrue(ts.getBuy() > 0);
    }
}
