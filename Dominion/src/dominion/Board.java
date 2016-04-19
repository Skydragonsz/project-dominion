package dominion;

import java.util.ArrayList;

/**
 *
 * @author Quint
 */
public class Board {

    private ArrayList<Pile> piles = new ArrayList<>();
    private Pile province;

    public Board(Pile... piles) {
        for (Pile pile : piles) {
            this.piles.add(pile);

            if ("Province".equals(pile.getName())) {
                this.province = pile;
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
}
