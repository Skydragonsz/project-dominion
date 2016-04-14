/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import cards.Maincards.MainCard;
import dominion.phase.ActionPhase;
/**
 *
 * @author Arthur
 */


public class EffectPhase {
    private String firstChoice;
    private String secondChoice;
    private ActionPhase ap = new ActionPhase();
    private boolean dicisions;
    
    public EffectPhase(){
        
    }
    
    public void decisions(String firstChoice, String secondChoice, MainCard playcard){
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        
        while(dicisions){
            
        }
    }
    
    public String getChoise1(){
        return firstChoice;
    }
    
    public String getChoise2(){
        return secondChoice;
    }
    
    
}
