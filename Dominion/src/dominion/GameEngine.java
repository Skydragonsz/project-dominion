/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

import java.util.*;
/**
 *
 * @author Arthur
 */

//TODO -- transfer Player methods to GameEngine
public class GameEngine extends Turn{
    private final static ArrayList<Player> playerArray = new ArrayList<>();
    private final static ArrayList<Player> otherPlayersArray = new ArrayList<>();
    
    public GameEngine(){
        
    }
    
    public static void main(String[] args) {
        
    }
    
    public void setAmountPlayers(int amount){
        for(int i = 0; i < amount;i++)
        {
            playerArray.add(new Player("player " + (i+1)));
            
        }
    }
    
    public void setName(int playernr, String name){
        getPlayer(playernr).setName(name);
    }
    
    public Player getPlayer(int playernr){
        return playerArray.get(playernr-1);
    }
    
    public ArrayList<Player> getPlayerList(){
        return playerArray;
    }
    
        
    
    public ArrayList<Player> getOtherPlayersList(Player player){
            for(int i = 0; i < playerArray.size();i++){
                if(player != playerArray.get(i)){
                    otherPlayersArray.add(playerArray.get(i));
                }
            }
        
        return otherPlayersArray;
    }
    
    public void reset(){
        otherPlayersArray.clear();
        playerArray.clear();
    }
    
    
    
    
}
