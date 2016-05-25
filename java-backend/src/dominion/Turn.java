package dominion;

import java.util.ArrayList;

/**
 *
 * @author Quinten
 */

public class Turn {

    private ArrayList<TurnSegment> turnArray = new ArrayList<TurnSegment>();
    private int turnNumber;
    private int turnSegmentNumber;

    public Turn(int NthTurn,GameEngine ge) {
        this.turnNumber = NthTurn;
        this.turnSegmentNumber = 0;

        for (int i = 0; i < ge.getMaxPlayers(); i++) {  
            turnArray.add(new TurnSegment());
        }
    }

    /* METHODS */
    public void nextTurnSegment(GameEngine ge) {
        if (turnSegmentNumber <= ge.getMaxPlayers()) {
            turnSegmentNumber++;
        }
    }
    
    public void setCurrentTurnNumber(int number){
    	turnNumber = number;
    }

    /* GETTERS */
    public int getCurrentTurnNumber() {
        return turnNumber;
    }

    public TurnSegment getCurrentTurnSegment(int turnSegment) {
        return turnArray.get(turnSegment);
    }

}
