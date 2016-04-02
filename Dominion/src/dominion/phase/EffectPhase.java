/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion.phase;
import Cards.*;
/**
 *
 * @author Arthur
 */


public class EffectPhase {
    private String choise1;
    private String choise2;
    
    public EffectPhase(){
        
    }
    
    public void decisions(String choise1, String choise2, MainCard playcard){
        this.choise1 = choise1;
        this.choise2 = choise2;
        
        
        
    }
    
    public String getChoise1(){
        return choise1;
    }
    
    public String getChoise2(){
        return choise2;
    }
    
    
}
