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
    public void testsetAmountPlayers(){
        System.out.println("testsetAmountPlayers");
        ge.reset();
        
        ge.setAmountPlayers(2);
        ge.setName(1, "Bob");
        ge.setName(2, "Rudy");
        System.out.println(ge.getPlayer(1).getName());
        System.out.println(ge.getPlayerList());
    }
    
    @Test
    public void testGetOtherPlayers(){
        System.out.println("testGetOtherPlayers");
        ge.reset();
        
        ge.setAmountPlayers(4);
        ge.setName(1, "Quinten");
        ge.setName(2, "Coene");
        ge.setName(3, "Tim");
        ge.setName(4, "Arthur");
        
        
       
        System.out.println(ge.getOtherPlayersList(ge.getPlayer(4)));
        
    }
    
    @Test
    public void testGetOtherPlayersByName(){
        ge.reset();
        System.out.println("testGetOtherPlayersByName");
        
        ge.setAmountPlayers(4);
        ge.setName(1, "Quinten");
        ge.setName(2, "Coene");
        ge.setName(3, "Tim");
        ge.setName(4, "Arthur");
        
        for(int i = 0;i < ge.getPlayerList().size() -1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(4)).get(i).getName());
        }
    }
    
    
}
