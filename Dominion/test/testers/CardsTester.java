/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Card;
import dominion.GameEngine;
import dominion.Pile;
import dominion.Player;

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

public class CardsTester {
    private GameEngine gameEngine = new GameEngine();
	
    private Card witch;
    private Card copper;
    private Card province;
    private Card duchy;
    
    private Player firstPlayer;
    private ArrayList<Player> secondPlayer;
    
    
    public CardsTester() {
    	gameEngine.initConnection();
    	gameEngine.reset();
    	gameEngine.initAmountPlayers(2);
    	gameEngine.initPlayer(1, "testPlayerOne");
    	gameEngine.initPlayer(2, "testPlayerTwo");
    	
    	this.firstPlayer = gameEngine.getPlayer(1);
    	this.secondPlayer = gameEngine.getOtherPlayersList(firstPlayer);
    	
        witch = gameEngine.CallCard("Witch");
        copper = gameEngine.CallCard("Copper");
        province = gameEngine.CallCard("Province");
        duchy = gameEngine.CallCard("Duchy");
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
    public void testGetTypeWitch() {
        //assertEquals(witch.getType(), "Attack");
    	assertEquals(witch.getType(), "4");
    }

    @Test
    public void testGetTypeCopper() {
        //assertEquals(copper.getType(), "Treasure");
    	assertEquals(copper.getType(), "3");
    }

    @Test
    public void testGetCostOfProvince() {
        assertEquals(province.getCost(), 8);
    }

    @Test
    public void testVictoryPoints() {
        int VictoryPoints = 0;
        VictoryPoints += province.getValue();
        VictoryPoints += duchy.getValue();
        VictoryPoints += province.getValue();

        System.out.println(province.getValue());
        System.out.println(duchy.getValue());
        System.out.println(province.getValue());
        
        //TODO: Fix values in database
        //has to be 15. Now it is 8(?).
        assertEquals(VictoryPoints, 15);
    }

    @Test
    public void testGetNameForCopperCard() {
        String cardName = copper.getName();
        System.out.println(cardName);
        assertEquals(cardName,"Copper");
    }

    @Test
    public void testAdventurer() {
    	
        System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        //Adventurer card will add two copper (ID = 1) into the hand of the player.
        //What the result should be.
        ArrayList resultHandArray =  new ArrayList(firstPlayer.getHand().getPile());       
        resultHandArray.add("Copper");
        resultHandArray.add("Copper");

        //Real function
        gameEngine.playCard("Adventurer", firstPlayer, secondPlayer);

        System.out.println("[After] Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("[After] Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        System.out.println("Result: " + resultHandArray);
        
        assertEquals(firstPlayer.getHand().getCardsName(),resultHandArray);
    }
//
//    @Test
//    //Test doesn't succeed(?). doesn't hava an assert_____();
//    //Does the function work?
//    public void testBureaucrat() {
//        ge.reset();
//        ge.initAmountPlayers(3);
//        ge.initPlayer(1, "Bob");
//        ge.initPlayer(2, "Ross");
//        ge.initPlayer(3, "Arthur");
//
//        ge.getPlayer(1).addCardToHand(1);
//        ge.getPlayer(1).addCardToHand(6);
//        ge.getPlayer(1).addCardToHand(3);
//
//        ge.getPlayer(2).addCardToHand(1);
//        ge.getPlayer(2).addCardToHand(3);
//        ge.getPlayer(2).addCardToHand(3);
//
//        ge.getPlayer(3).addCardToHand(15);
//        ge.getPlayer(3).addCardToHand(5);
//        ge.getPlayer(3).addCardToHand(1);
//        ge.getPlayer(3).addCardToHand(13);
//
//        for (int i = 1; i <= ge.getPlayerList().size(); i++) {
//            System.out.println(ge.getPlayer(i).getName() + " " + ge.getPlayer(i).getCardsInHand());
//        }
//        
//        
//        System.out.println(ge.getPlayer(3));
//        System.out.println(col.getCard(15) );       
//        ap.placeCard(col.getCard(15), ge.getPlayer(3));
//
//        for (int i = 1; i <= ge.getPlayerList().size(); i++) {
//            System.out.println("AFTER: " + ge.getPlayer(i).getName() + " " + ge.getPlayer(i).getCardsInHand());
//        }
//        //fail(); 
//    }
}
