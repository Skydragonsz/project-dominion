/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import cards.Maincards.MainCard;
/**
 *
 * @author Arthur
 */


public class EffectPhase {
    private String firstChoice;
    private String secondChoice;
    
    public EffectPhase(){
        
    }
    
    public void decisions(String firstChoice, String secondChoice, MainCard playcard){
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
    }
    
    public String getChoise1(){
        return firstChoice;
    }
    
    public String getChoise2(){
        return secondChoice;
    }
    
    
}
