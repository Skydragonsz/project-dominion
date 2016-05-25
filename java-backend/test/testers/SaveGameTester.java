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

    }
	


	
	@Test
	public void testSave(){
		

    	
    	ge.initPlayer(1, "Quinten");
    	ge.initPlayer(2, "Arthur");
    	ge.initPlayer(3, "Coene");
    	ge.initPlayer(4, "Tim");
    	ge.init();
    	ge.initCards();
   
		sg.save(ge);
		
	}
	
	
	@Test
	public void testLoad(){
		

		sg.load(ge, sg.getLastGameID());
		System.out.println("BOARD");
		
		for(int i = 0;i < ge.getBoard().getPiles().size();i++){
			System.out.print(ge.getBoard().getFromIndex(i).getFromIndex(1).getName());
			System.out.print(" ");
			System.out.println(ge.getBoard().getFromIndex(i).getAmount());
		}
		
		System.out.println();
		for(int i = 1; i <= ge.getMaxPlayers();i++){

			System.out.print(ge.getPlayer(i).getName());
			System.out.print(">>> ");
			System.out.print("Deck: "+ge.getPlayer(i).getDeck().getCardsName());
			System.out.println();
			System.out.print("Hand: "+ge.getPlayer(i).getHand().getCardsName());
			System.out.println();
			System.out.print("Discard pile: "+ge.getPlayer(i).getDiscardPile().getCardsName());
			System.out.println();
			System.out.println("Playing Field: "+ge.getPlayer(i).getPlayingField().getCardsName());
			System.out.println();
			System.out.println();

		}
		
		System.out.println("Playercounter " + ge.getPlayerCounter());
		System.out.println("Turn " + ge.getTurnNumber());
	}

}
