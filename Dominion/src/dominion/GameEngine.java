/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;
import dominion.Player;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class GameEngine {
    private final ArrayList<Player> playerArray = new ArrayList<>();
    public GameEngine(){
        
    }
    
    public static void main(String[] args) {
        
    }
    
    private void init(){
        //TODO -- Check this out
        playerArray.add(new Player());
    }
}
