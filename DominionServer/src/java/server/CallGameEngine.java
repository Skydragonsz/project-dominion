/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import dominion.*;
import gameconsole.GameConsole;
/**
 *
 * @author Arthur
 */
public class CallGameEngine {
    private GameEngine ge = new GameEngine();
    private GameConsole gcon = new GameConsole();
    
    public void run(){
        gcon.run();
    }
    
    public String test(){
        return "Dit is een test";
    }
    
    
}
