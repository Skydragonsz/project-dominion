package dominion;

import java.util.ArrayList;

/**
 *
 * @author Quint
 */
public class Board {
	


    private ArrayList<Pile> piles = new ArrayList<>();
    private Pile province;
    
    public Board(){
    	
    }
   
	// 2 Players:
	// 30 Gold
	// 40 Silver
	// 46 Copper (60 - 7 * amountOfPlayers)
	// 8 All Victory cards
	// 10 Curse
    
    // CORRECT
    public Board(GameEngine ge,Card... cards) {
    	int amount = ge.getMaxPlayers();
        for (Card card : cards) {
        	if ("Garden".equals(card.getName())){
        		this.piles.add(new Pile(card, 8 + ((amount > 2) ? 4 : 0))); //GameEngine.getMaxPlayers()

        	} else {
        		if ("Victory".equals(card.getType()) && !("Curse".equals(card.getName()))){
        			this.piles.add(new Pile(card, 8));
        		}else{
        			switch(card.getName()){
        			case "Copper":
        				this.piles.add(new Pile(card, (60 - (7 * amount )))); //GameEngine.getMaxPlayers()  //2 moet vervangen worden
        				break;
        			case "Silver":
        				this.piles.add(new Pile(card, 40)); 
        				break;
        			case "Gold":
        				this.piles.add(new Pile(card, 30)); 
        				break;
        			default:
        				this.piles.add(new Pile(card, 10));
        				break;
        			}
        		}
        	}
        	
            if ("Province".equals(card.getName())) {
                this.province = this.piles.get(piles.size() - 1);
            }
        }
    }
    
    // TODO fix this.
    public void addPileToBoardWithAmount(Card card, int amount){
    		this.piles.add(new Pile(card, amount));    	
    }
    
    

/* METHODS */    
    public boolean isGameEnding() {
        return isProvinceEmpty() || areThreeRandomPileEmpty();
    }

    public boolean isProvinceEmpty() {
        return province.getAmount() <= 0;
    }

    public boolean areThreeRandomPileEmpty() {
        int emptyCounter = 0;

        for (Pile pile : piles) {
            if (pile.getAmount() <= 0) {
                emptyCounter++;
            }
        }
        return emptyCounter == 3;
    }
    
/* GETTERS */
    public ArrayList<Pile> getPiles() {
        return piles;
    }
    
    public Pile getFromIndex(int index) {
        return this.piles.get(index);
    }

    
}
