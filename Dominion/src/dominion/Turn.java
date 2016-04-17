/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

   public Turn(int NthTurn){
       this.turnNumber = NthTurn;
       this.turnSegmentNumber = 0;
       
       for(int i = 0; i < 3; i++){ //TEMP 3
       
       turnArray.add(new TurnSegment());
       }
   }
   
    public int getCurrentTurnNumber(){
        return turnNumber;
    }
    
    public TurnSegment getCurrentTurnSegment(){
        return turnArray.get(turnSegmentNumber);
    }
    
    public void nextTurnSegment(){
        if (turnSegmentNumber <= 3){ //TEMP 3
        turnSegmentNumber++;
        }
    }
}