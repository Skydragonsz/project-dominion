/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.Functions;

import java.util.ArrayList;
import java.util.Random;
    
/**
 *
 * @author Quinten
 */
public class KingdomCards {
    
    private int RandomNumber;
    Random r = new Random();
    ArrayList<Integer> KingdomCardsSetFirstGame = new ArrayList<>(10);
    
    public void generateRandomSet(){
    for (int i = 0; i < 10; i++)
        KingdomCardsSetFirstGame.add(i);
    int Low = 8;
    int High = 32;
    System.out.println(KingdomCardsSetFirstGame.size()); 
    for (int i = 0; i < KingdomCardsSetFirstGame.size(); i++){
        RandomNumber = r.nextInt(High-Low) + Low;
        while (KingdomCardsSetFirstGame.contains(RandomNumber)){
                RandomNumber = r.nextInt(High-Low) + Low;
        }
        System.out.println(i + " :: " + RandomNumber);
        KingdomCardsSetFirstGame.set(i,RandomNumber);
    }
    System.out.println(KingdomCardsSetFirstGame.toString());
    }
    
    
}
