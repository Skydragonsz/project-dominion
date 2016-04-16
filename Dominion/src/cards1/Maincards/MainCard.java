/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.Maincards;

import dominion.GameEngine;
import dominion.Player;
import java.util.ArrayList;


/**
 *
 * @author Arthur
 */
public class MainCard{
    private String TYPE = "MAIN";
    private static int cardID = 0;
    private static String name = "MainCard";
    private static String info = "Dit is de info van de MAINCARD";
    private int cost = 0;
    private int victoryValue = 0;
    private int value = 0;
    
    public String getCardType(){
        return TYPE;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCardID(){
        return cardID;
    } 
    
    public int getCost(){
        return cost;
    }
    
    public String getInfo(){
        return info;
    }
    
    public int getVictoryValue(){
        return victoryValue;
    }
       
    public void playCard(Player player){
        System.out.println("DIT IS DE MAIN CARD.");
    }
    
    public void playCard(Player player,Player otherPlayer){
        System.out.println("DIT IS DE MAIN CARD.");
    }
    
    public void playCard(Player player,ArrayList<Player> otherPlayer){
        System.out.println("DIT IS DE MAIN CARD. ArrayList");
    }
    
    public void playCard(Player player,GameEngine otherPlayer){
        System.out.println("DIT IS DE MAIN CARD.");
    }
}
