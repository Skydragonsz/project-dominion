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

    public Turn n = new Turn();
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
    n.addAction(24);
    n.addBuy(25);
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
    public void AddFiveCoins(){
        n.addCoin(5);
     assertEquals(n.getCoin(), 5);
    }
    
    @Test
    public void RemoveOneAction(){
        n.removeAction(1);
        System.out.println(n.getAction());
     assertEquals(n.getAction(), 23);
    }
    
    @Test
    public void RemoveBuysBelowZero(){
        n.removeBuy(500);
        System.out.println(n.getBuy());
     assertTrue(n.getBuy() > 0);
    }
}
