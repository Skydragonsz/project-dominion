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

    //TEMP VALUES - NOT REAL
    private Card witch = new Card("Witch", "ATTACK", "description", 3, 0, 0, 1, 2, 0, false);
    private Card witch2 = witch;
    private Card copper = new Card("Copper", "TREASURE", "description", 3, 0, 0, 1, 2, 0, false);
    private Card province = new Card("Province", "Action", "description", 8, 5, 0, 1, 2, 0, false);
    private Card duchy = new Card("Duchy", "Action", "description", 3, 5, 0, 1, 2, 0, false);
    private Card province2 = province;
    
    private Card village = new Card("Village", "Action", "description", 3, 0, 0, 1, 2, 0, false);
    private Card gold = new Card("Gold", "Treasure", "description", 6, 3, 0, 0, 0, 0, false);
    
    private Pile deck = new Pile(gold,gold,gold,gold,gold,gold,gold,village,village,village);
    private Pile hand = new Pile();
    
    private Player firstPlayer;
    private ArrayList<Player> secondPlayer;
    
    private GameEngine gameEngine = new GameEngine();
    
    public CardsTester() {
    	gameEngine.initAmountPlayers(2);
    	gameEngine.initPlayer(1, "testPlayerOne");
    	gameEngine.initPlayer(2, "testPlayerTwo");
    	
    	this.firstPlayer = gameEngine.getPlayer(1);
    	this.secondPlayer = gameEngine.getOtherPlayersList(firstPlayer);
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
        assertEquals(witch.getType(), "ATTACK");

    }

    @Test
    public void testGetTypeCopper() {
        assertEquals(copper.getType(), "TREASURE");

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

        assertEquals(VictoryPoints, 15);

    }

//    @Test
//    public void testRandomSet() {
//        set.generateRandomSet();
//        //Class kingdomSet not finished yet.
//        //assertTrue(set.getDeck() != testArrayDeck);
//        fail(); 
//    }

    @Test
    public void testGetNameForCopperCard() {
        String cardName = copper.getName();
        System.out.println(cardName);
        assertEquals(cardName,"Copper");
    }

    @Test
    public void testAdventurer() {
    	
        System.out.println(firstPlayer.getDeck());
        //Adventurer card will add two copper (ID = 1) into the hand of the player.
        //What the result should be.
        ArrayList resultHandArray =  new ArrayList(firstPlayer.getHand().getPile());       
        resultHandArray.add("Copper");
        resultHandArray.add("Copper");

        //Real function
        gameEngine.playCard("Adventurer", firstPlayer, secondPlayer);

        System.out.println(firstPlayer.getDeck());
        System.out.println(firstPlayer.getDeck());
        System.out.println(resultHandArray);
        
        assertEquals(firstPlayer.getHand(),resultHandArray);
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
