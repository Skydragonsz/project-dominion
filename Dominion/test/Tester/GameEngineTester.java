/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import dominion.GameEngine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.Player;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class GameEngineTester {
    private GameEngine ge = new GameEngine();
    
    
    
    
    public GameEngineTester() {
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
        ge.reset();
        
        ge.initAmountPlayers(2);
        ge.setPlayerName(1, "Bob");
        ge.setPlayerName(2, "Rudy");
        System.out.println(ge.getPlayer(1).getName());
        System.out.println(ge.getPlayerList());
        assertEquals(ge.getPlayerList().size(),2);
    }
    
    @Test
    public void testGetOtherPlayers(){
        //For now this function should give an error, see comments below.
        System.out.println("testGetOtherPlayers");
        ge.reset();
        
        ge.initAmountPlayers(4);
        ge.setPlayerName(1, "Quinten");
        ge.setPlayerName(2, "Coene");
        ge.setPlayerName(3, "Tim");
        ge.setPlayerName(4, "Arthur");
        
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
        
        
        System.out.println(ge.getOtherPlayersList(ge.getPlayer(4)));
        System.out.println(resultOtherPlayerArray);
        assertEquals(ge.getOtherPlayersList(ge.getPlayer(4)),resultOtherPlayerArray);
    }
    
    @Test
    public void testGetOtherPlayersByName(){
        ge.reset();
        System.out.println("testGetOtherPlayersByName");
        
        ge.initAmountPlayers(4);
        ge.setPlayerName(1, "Quinten");
        ge.setPlayerName(2, "Coene");
        ge.setPlayerName(3, "Tim");
        ge.setPlayerName(4, "Arthur");
        
        String tempString = new String();
        String resultString = "QuintenCoeneTim";
        for(int i = 0;i < ge.getPlayerList().size() -1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(4)).get(i).getName());
            tempString += ge.getOtherPlayersList(ge.getPlayer(4)).get(i).getName();
        }
        assertEquals(tempString,resultString);
    }
    
    
}
