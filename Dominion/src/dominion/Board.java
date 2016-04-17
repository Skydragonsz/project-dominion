/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

import java.util.ArrayList;

/**
 *
 * @author Quint
 */
public class Board {

    private ArrayList<Pile> piles;
    private Pile province;

    public Board(Pile... piles) {
        for (Pile pile : piles) {
            this.piles.add(pile);

            if ("Province".equals(pile.getName())) {
                this.province = pile;
            }
        }
    }

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
    
    public ArrayList<Pile> getPiles() {
        return piles;
    }
}
