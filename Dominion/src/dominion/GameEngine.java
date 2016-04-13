/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

import dominion.phase.ActionPhase;
import java.util.*;
import cards.Functions.Collection;
/**
 *
 * @author Arthur
 */

//TODO -- transfer Player methods to GameEngine
public class GameEngine{
    private final static ArrayList<Player> playerArray = new ArrayList<>();
    private final static ArrayList<Player> otherPlayersArray = new ArrayList<>();
    private Player currentPlayer;
    private int PlayerCounter = 0;
    private Collection collection;
    private ArrayList<Turn> turnArray = new ArrayList<>();
    
    
    public GameEngine(){
        
    }
    
    public static void main(String[] args) {
        
    }
//PLAYER
    //INIT
    public void initAmountPlayers(int amount){
        for(int i = 0; i < amount;i++)
        {
            playerArray.add(new Player());
        }
    }
   
    public void setPlayerName(int playernr, String name){
        getPlayer(playernr).setName(name);
    }
    //GETTERS
    public Player getPlayer(int playernr){
        return playerArray.get(playernr-1);
    }
    
    public Player getCurrentPlayer(){
        return playerArray.get(PlayerCounter);
    }
        public int getMaxPlayers(){
        return playerArray.size();
    }
    
    public ArrayList<Player> getPlayerList(){
        return playerArray;
    }

    public ArrayList<Player> getOtherPlayersList(Player player){
            //TEMP FIX
            otherPlayersArray.clear();
            for(int i = 0; i < playerArray.size();i++){
                if(player != playerArray.get(i)){
                    otherPlayersArray.add(playerArray.get(i));
                }
            }
        return otherPlayersArray;
    }
    
    //SETTERS
    public void setNextPlayer(){
        PlayerCounter++;
    }
    
    //RESET
    public void ResetPlayer(){
        PlayerCounter = 0;
    }
    
    public void PlayCardEffect(int index){

    }
    
//TURN        
    public void addTurn(int NthTurn){
        turnArray.add(new Turn(NthTurn));
    }
    
    public Turn getTurn(int NthTurn){
        return turnArray.get(NthTurn);
    }
    
    public int getTurnNumber(int NthTurn){
        return turnArray.get(NthTurn).getCurrentTurnNumber();
    }
    
    public TurnSegment getTurnSegment(int NthTurn){
        return turnArray.get(NthTurn).getCurrentTurnSegment();
    }
    
    public int getTurnSegmentCoin(int NthTurn){
        return turnArray.get(NthTurn).getCurrentTurnSegment().getCoin();
    }
    
//OTHER    
    public void reset(){
        otherPlayersArray.clear();
        playerArray.clear();
    }
}
