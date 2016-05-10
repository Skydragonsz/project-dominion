package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dominion.GameEngine;
import dominion.Player;

public class findCardTester {

    private GameEngine gameEngine = new GameEngine();
    private Player firstPlayer;
    private ArrayList secondPlayer;
    
    public findCardTester() {
    	gameEngine.initCards();
    	gameEngine.reset();
    	gameEngine.initAmountPlayers(2);
    	gameEngine.initPlayer(1, "testPlayerOne");
    	gameEngine.initPlayer(2, "testPlayerTwo");
    	
    	this.firstPlayer = gameEngine.getPlayer(1);
    	this.secondPlayer = gameEngine.getOtherPlayersList(firstPlayer);
    }
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void initGameEngineToGenerateDeck() {
		System.out.println(firstPlayer.getDeck().getPile());
		System.out.println(firstPlayer.getDeck().getCardsName());
		
		
	}

}
