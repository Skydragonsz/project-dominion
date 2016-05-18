package dominion;

import java.util.ArrayList;

/**
 *
 * @author Quint
 */
public class Board {

    private ArrayList<Pile> piles = new ArrayList<>();
    private Pile province;

    //CHANGE TO CARDS
    public Board(Pile... piles) {
        for (Pile pile : piles) {
            this.piles.add(pile);

            if ("Province".equals(pile.getName())) {
                this.province = pile;
            }
        }
    }
    
    
    
    
    
    
    
    // CORRECT
    public Board(Card... cards) {
        for (Card card : cards) {
        	if ("Garden".equals(card.getName())){
        		this.piles.add(new Pile(card, 8 + ((3 > 2) ? 4 : 0))); //GameEngine.getMaxPlayers()

        	} else {
        		this.piles.add(new Pile(card, 10));
        	}
        	
            if ("Province".equals(card.getName())) {
                this.province = this.piles.get(piles.size() - 1);
            }
        }
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
