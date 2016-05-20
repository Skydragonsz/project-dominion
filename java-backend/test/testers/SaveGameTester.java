package testers;

import static org.junit.Assert.*;

import org.junit.Test;
import dominion.SaveGame;
import dominion.GameEngine;

public class SaveGameTester {
	
	private GameEngine ge = new GameEngine();
	private SaveGame sg = new SaveGame();
	
	public SaveGameTester(){

    	ge.reset();
    	ge.initAmountPlayers(4);
    	ge.init();
    	ge.initPlayer(1, "testPlayerOne");
    	ge.initPlayer(2, "testPlayerTwo");
    	ge.initPlayer(3, "testPlayerThree");
    	ge.initPlayer(4, "testPlayerFour");
    }
	

	@Test
	public void testStringify(){
		System.out.println(sg.stringify(ge.getPlayer(1).getDeck()));
		
	}
	
	@Test
	public void testSplitify(){
		String test = sg.stringify(ge.getPlayer(1).getDeck());
		
		System.out.println("String " + test);
		System.out.println("Pile " + sg.splitify(test));
		
	}
	
	@Test
	public void testSave(){
		sg.save(ge);
		
	}
	
	@Test
	public void testLoad(){
		sg.load(ge,19);
		
	}
	
	@Test
	public void randomTester(){
		System.out.println(ge.getBoard().getFromIndex(4).getCardsName());
		
		System.out.println(ge.getBoard().getPiles());
		

		
		System.out.println(ge.getBoard().getPiles());
	}

}
