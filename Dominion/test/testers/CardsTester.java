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
    	gameEngine.reset();
    	gameEngine.initAmountPlayers(2);
    	gameEngine.init();
    	gameEngine.initPlayer(1, "testPlayerOne");
    	gameEngine.initPlayer(2, "testPlayerTwo");
    	
    	this.firstPlayer = gameEngine.getPlayer(1);
    	this.secondPlayer = gameEngine.getOtherPlayersList(firstPlayer);
    	
        witch = GameEngine.CallCard("Witch");
        copper = GameEngine.CallCard("Copper");
        province = GameEngine.CallCard("Province");
        duchy = GameEngine.CallCard("Duchy");
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
        gameEngine.playCard(GameEngine.CallCard("Adventurer"));

        System.out.println("[After] Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("[After] Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        System.out.println("Result: " + resultHandArray);
        
        assertEquals(firstPlayer.getHand().getCardsName(),resultHandArray);
    }
    
    @Test
    public void testChancellor() {
    	firstPlayer.getDeck().add(GameEngine.CallCard("Chancellor"));
    	firstPlayer.getHand().addFrom(GameEngine.CallCard("Chancellor"), firstPlayer.getDeck());
    	
    	ArrayList resultDiscardArray = firstPlayer.getDiscardPile().getCardsName();
    	resultDiscardArray.addAll(firstPlayer.getDeck().getCardsName());
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	
    	gameEngine.playCard(GameEngine.CallCard("Chancellor"));
    	
    	System.out.println("[After] Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
        System.out.println("[After] Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
        System.out.println("[After] Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
        
        assertEquals(firstPlayer.getDiscardPile().getCardsName(),resultDiscardArray);
    	
    }
    
    @Test
    public void testBureaucrat() {
    	//!!Takes all victory cards.
    	
    	//Bureaucrat from deck to hand.
    	firstPlayer.getDeck().add(GameEngine.CallCard("Bureaucrat"));
    	firstPlayer.getHand().addFrom(GameEngine.CallCard("Bureaucrat"), firstPlayer.getDeck());
    	
    	//What result should be.
    	ArrayList resultDeckArray = new ArrayList(secondPlayer.get(0).getDeck().getCardsName());
    	resultDeckArray.add("Estate");
    	
    	System.out.println(resultDeckArray);
    	
    	System.out.println("Player 2 - Deck: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Hand: " + secondPlayer.get(0).getHand().getCardsName());
    	
    	
    	gameEngine.playCard(GameEngine.CallCard("Bureaucrat"));
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	
    	System.out.println("Player 2 - Deck after Card: " + secondPlayer.get(0).getDeck().getCardsName());
    	System.out.println("Player 2 - Hand after Card: " + secondPlayer.get(0).getHand().getCardsName());
    	
    	assertEquals(secondPlayer.get(0).getDeck().getCardsName(),resultDeckArray);
    }
    
    
    
    @Test
    public void testSpy() {
    	ArrayList resultDiscardArray = firstPlayer.getDiscardPile().getCardsName();
    	resultDiscardArray.add("Witch");
    	
    	firstPlayer.getDeck().getPile().add(0, GameEngine.CallCard("Witch"));
    	secondPlayer.get(0).getDeck().getPile().add(0, GameEngine.CallCard("Adventurer"));
    	
    	System.out.println("Resultaat Array " + resultDiscardArray);
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile());
    	
    	System.out.println("Player 2 - Deck: " + secondPlayer.get(0).getDeck());
    	System.out.println("Player 2 - Discard: " + secondPlayer.get(0).getDiscardPile());
    	
    	gameEngine.playCard(GameEngine.CallCard("Spy"));
    	
    	System.out.println("Player 2 - Deck after Card: " + secondPlayer.get(0).getDeck());
    	System.out.println("Player 2 - Discard after Card: " + secondPlayer.get(0).getDiscardPile());
    	
    	
    	assertEquals(firstPlayer.getDiscardPile().getCardsName(), resultDiscardArray);
    	
    }
    
    @Test
    public void testLibrary() {
    	ArrayList resultHandArray = firstPlayer.getHand().getCardsName();
    	resultHandArray.add("Copper");
    	resultHandArray.add("Copper");

    	System.out.println(resultHandArray);
    	
    	firstPlayer.getDeck().getPile().add(0, GameEngine.CallCard("Chapel"));
    	firstPlayer.getDeck().getPile().add(1, GameEngine.CallCard("Bureaucrat"));
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	gameEngine.playCard(GameEngine.CallCard("Library"));
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    	
    	assertEquals(firstPlayer.getHand().getCardsName(), resultHandArray);
    		// Werkt, maar volgorde klopt niet altijd --> error
    	
    }
    //Problem with this test
    @Test
    public void testThroneRoom() {
    	//TODO Fix this test
    	//Test won't work since turns won't get made.
    	
    	ArrayList resultHandArray = firstPlayer.getHand().getCardsName();
    	resultHandArray.add("Estate");
    	resultHandArray.add("Copper");
    	
    	
    	System.out.println(resultHandArray);
    	
    	firstPlayer.getSelectedHand().add(GameEngine.CallCard("Village"));
    	
    	firstPlayer.getDeck().getPile().add(0, GameEngine.CallCard("Estate"));
    	firstPlayer.getDeck().getPile().add(1, GameEngine.CallCard("Copper"));
    	    	
    	System.out.println(gameEngine.CallCard("Throne room").getType());
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	System.out.println(gameEngine.getCurrentTurnSegment().getAction());
    	
    	gameEngine.playCard(GameEngine.CallCard("Throne room"));
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    	System.out.println("Village 2x uitvoeren: 1(Standaard) + 2(Village) + 2(Village) actions = " + gameEngine.getCurrentTurnSegment().getAction());
    	
    	assertEquals(firstPlayer.getHand().getCardsName(), resultHandArray);
    	
    	
    }
    //Problem with this test
    @Test
    public void testMine() {
    	firstPlayer.getSelectedHand().add(GameEngine.CallCard("Silver"));
    	
    	System.out.println("Player 1 - Deck: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard: " + firstPlayer.getDiscardPile().getCardsName());
    	System.out.println(gameEngine.getCurrentTurnSegment().getInstancedCoin());
    	
    	gameEngine.playCard(GameEngine.CallCard("Mine"));
    	
    	System.out.println("Player 1 - Deck after Card: " + firstPlayer.getDeck().getCardsName());
    	System.out.println("Player 1 - Hand after Card: " + firstPlayer.getHand().getCardsName());
    	System.out.println("Player 1 - Discard after Card: " + firstPlayer.getDiscardPile().getCardsName());
    	System.out.println(gameEngine.getCurrentTurnSegment().getInstancedCoin());
    	
    	System.out.println("Deze kaart werkt, geen waarden om te vergelijken");
    }
    

}
