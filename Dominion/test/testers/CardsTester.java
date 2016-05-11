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
    	gameEngine.initCards();
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
    	assertEquals(witch.getType(), "Attack");
    }

    @Test
    public void testGetTypeCopper() {
        //assertEquals(copper.getType(), "Treasure");
    	assertEquals(copper.getType(), "Treasure");
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
        ArrayList resultHandArray =  new ArrayList(firstPlayer.getHand().getCardsName());       
        resultHandArray.add("Copper");
        resultHandArray.add("Copper");

        //Real function
        gameEngine.playCard("Adventurer", firstPlayer, secondPlayer, gameEngine);

        System.out.println("[After] Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("[After] Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        System.out.println("Result: " + resultHandArray);
        
        assertEquals(firstPlayer.getHand().getCardsName(),resultHandArray);
    }
    
    @Test
    public void testChancellor() {
    	firstPlayer.getDeck().add(gameEngine.CallCard("Chancellor"));
    	firstPlayer.getHand().addFrom(gameEngine.CallCard("Chancellor"), firstPlayer.getDeck());
    	
    	ArrayList resultDiscardArray = firstPlayer.getDiscardPile().getCardsName();
    	resultDiscardArray.addAll(firstPlayer.getDeck().getCardsName());
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	
    	gameEngine.playCard("Chancellor", firstPlayer, secondPlayer, gameEngine);
    	
    	System.out.println("[After] Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("[After] Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        System.out.println("[After] Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
        
        assertEquals(firstPlayer.getDiscardPile().getCardsName(),resultDiscardArray);
    	
    }
    
    @Test
    public void testBureaucrat() {
    	//!!Takes all victory cards.
    	
    	//Bureaucrat from deck to hand.
    	firstPlayer.getDeck().add(gameEngine.CallCard("Bureaucrat"));
    	firstPlayer.getHand().addFrom(gameEngine.CallCard("Bureaucrat"), firstPlayer.getDeck());
    	
    	//What result should be.
    	ArrayList resultDeckArray = new ArrayList(secondPlayer.get(0).getDeck().getCardsName());
    	resultDeckArray.add("Duchy");
    	
    	System.out.println(resultDeckArray);
    	
    	System.out.println("Player 2 - Deck: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Hand: " + secondPlayer.get(0).getHand().getCardsName());
    	
    	
    	secondPlayer.get(0).getHand().add(gameEngine.CallCard("Duchy"));
    	
    	gameEngine.playCard("Bureaucrat", firstPlayer, secondPlayer, gameEngine);
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	
    	System.out.println("Player 2 - Deck after Card: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Hand after Card: " + secondPlayer.get(0).getHand().getCardsName());
    	
    	assertEquals(secondPlayer.get(0).getDeck().getCardsName(),resultDeckArray);
    }
    
    @Test
    public void testSpy() {
    	ArrayList resultDiscardArray = firstPlayer.getDiscardPile().getCardsName();
    	resultDiscardArray.add("Witch");
    	
    	firstPlayer.getDeck().getPile().add(0, gameEngine.CallCard("Witch"));
    	secondPlayer.get(0).getDeck().getPile().add(0, gameEngine.CallCard("Adventurer"));
    	
    	System.out.println("Resultaat Array " + resultDiscardArray);
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	System.out.println("Player 2 - Deck: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Discard: " + secondPlayer.get(0).getDiscardPile().getCardsName());
    	
    	gameEngine.playCard("Spy", firstPlayer, secondPlayer, gameEngine);
    	
    	System.out.println("Player 2 - Deck after Card: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Discard after Card: " + secondPlayer.get(0).getDiscardPile().getCardsName());
    	
    	assertEquals(firstPlayer.getDiscardPile().getCardsName(), resultDiscardArray);
    	
    }
    
    @Test
    public void testLibrary() {
    	ArrayList resultHandArray = firstPlayer.getHand().getCardsName();
    	resultHandArray.add("Copper");
    	resultHandArray.add("Copper");

    	System.out.println(resultHandArray);
    	
    	firstPlayer.getDeck().getPile().add(0, gameEngine.CallCard("Chapel"));
    	firstPlayer.getDeck().getPile().add(1, gameEngine.CallCard("Bureaucrat"));
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	gameEngine.playCard("Library", firstPlayer, secondPlayer, gameEngine);
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	assertEquals(firstPlayer.getHand().getCardsName(), resultHandArray);
    		// Werkt, maar volgorde klopt niet altijd --> error
    	
    }
    
    @Test
    public void testThroneRoom() {
    	//TODO Fix this test
    	//Test won't work since turns won't get made.
    	firstPlayer.getHand().add(gameEngine.CallCard("Throne Room"));
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile());
    	
    	gameEngine.playCard(gameEngine.CallCard("Throne Room"), gameEngine);
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    }
    
    @Test
    public void testMine() {
    	firstPlayer.getHand().add(gameEngine.CallCard("Silver"));
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	gameEngine.playCard(gameEngine.CallCard("Mine"), gameEngine);
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    }
}
