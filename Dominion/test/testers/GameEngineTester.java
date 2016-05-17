/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;
import dominion.GameEngine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class GameEngineTester {
    private GameEngine ge = new GameEngine();
    
    // Construct will run for every test.
    public GameEngineTester() {
    	ge.initCards();
        ge.reset();
        
        ge.initAmountPlayers(4);
        ge.initPlayer(1, "Quinten");
        ge.initPlayer(2, "Coene");
        ge.initPlayer(3, "Tim");
        ge.initPlayer(4, "Arthur");
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
    public void testSetAmountPlayers(){
        System.out.println("testsetAmountPlayers");
        
        System.out.println("All players: " + ge.getPlayerList());
        assertEquals(ge.getPlayerList().size(),4);
        
    }
    
    @Test
    public void testGetOtherPlayers(){
        System.out.println("testGetOtherPlayers");
        //Gives all other players then said player.
        //What the result should be.
        ArrayList resultOtherPlayerArray =  new ArrayList();       
        resultOtherPlayerArray.add(ge.getPlayer(1));
        resultOtherPlayerArray.add(ge.getPlayer(2));
        resultOtherPlayerArray.add(ge.getPlayer(3));
       
        /*
        CODE[ge.getOtherPlayersList(ge.getPlayer(4))] should give you all other players except player X.
        When you print it it will give that result, but if you use an assertEquals you will get an arrayList
        with duplicate values:                                                      V Duplicates start here
        [dominion.Player@1c4af82c, dominion.Player@379619aa, dominion.Player@cac736f, dominion.Player@1c4af82c, dominion.Player@379619aa, dominion.Player@cac736f]
        
        What we want to get is:
        [dominion.Player@1c4af82c, dominion.Player@379619aa, dominion.Player@cac736f]
        
        I do not know if this has to do with assertEquals (since println output looks OK) or the function,
        this should be looked at.
        
        extra: assertArrayEquals isn't used since the values are ArrayLists and not Arrays.
        */
        
        /* Q 13/04/2016 TEMP FIX, clear the array */  
        System.out.println("All other players: " + ge.getOtherPlayersList(ge.getPlayer(4)));
        System.out.println("All players: " + ge.getPlayerList());
        System.out.println("Result: " + resultOtherPlayerArray);
        assertEquals(ge.getOtherPlayersList(ge.getPlayer(4)),resultOtherPlayerArray);
    
    }
    
    @Test
    public void testGetOtherPlayersByName(){
        System.out.println("testGetOtherPlayersByName");
        String tempString = new String();
        String resultString = "QuintenCoeneTim";
        for(int i = 0;i < ge.getPlayerList().size() -1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(4)).get(i).getName());
            tempString += ge.getOtherPlayersList(ge.getPlayer(4)).get(i).getName();
        }
        assertEquals(tempString,resultString);
    }
    
    @Test
    public void testDrawCards(){
    	System.out.println("Deck: "+ge.getCurrentPlayer().getDeck());
    	System.out.println("Discard pile: "+ge.getCurrentPlayer().getDiscardPile());
    	System.out.println("Hand: "+ge.getCurrentPlayer().getHand());
    	System.out.println("==================AFTER==================");
    	ge.drawAmountOfCards(4);
    	System.out.println("Deck: "+ge.getCurrentPlayer().getDeck());
    	System.out.println("Discard pile: "+ge.getCurrentPlayer().getDiscardPile());
    	System.out.println("Hand: "+ge.getCurrentPlayer().getHand());
    }
    
    
}
