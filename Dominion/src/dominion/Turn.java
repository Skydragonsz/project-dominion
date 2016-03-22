/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

/**
 *
 * @author Quinten
 */
public class Turn {
   private int amountOfCurrency;
   private int currentPhase;
   private int amountOfActions;
   private int amountOfBuys;
   public static final int ACTION = 0, BUY = 1, CLEANUP = 2;
   
   public void addCoin(int amount)
   {
       this.amountOfCurrency += amount;
   }
   
   public void addAction(int amount)
   {
       this.amountOfActions += amount;
   }
   
   public void addBuy(int amount)
   {
       this.amountOfBuys += amount;
   }

    public int getPhase()
    {
        return currentPhase; 
    }
    
    public int getCoin(){
        return amountOfCurrency;
    }
}
