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
   private int amountOfCurrency = 0;
   private int currentPhase;
   private int amountOfActions = 1;
   private int amountOfBuys = 1;
   public static final int ACTION = 0, BUY = 1, CLEANUP = 2;

   public Turn(){
       
   }
   
//ADD
   public void addCoin(int amount)
   {
       if (amountOfCurrency >=0){
        amountOfCurrency += amount;
       }
   }
   
   public void addAction(int amount)
   {
       if (amountOfActions >=0){
       amountOfActions += amount;
       }
   }
   
   public void addBuy(int amount)
   {
       if (amountOfBuys >=0){
       amountOfBuys += amount;
       }
   }
   
//REMOVE   
   public void removeCoin(int amount)
   {
       if (amountOfCurrency - amount >=0){
       amountOfCurrency -= amount;
       }
   }
   
   public void removeAction(int amount)
   {
       if (amountOfActions - amount >=0){
            amountOfActions -= amount;
       }
   }
   
   public void removeBuy(int amount)
   {
       if (amountOfCurrency - amount >=0){
       amountOfBuys -= amount;
       }
   }
//GET   
    public int getCoin(){
        return amountOfCurrency;
    }
    
    public int getAction(){
        return amountOfActions;
    }
    
    public int getBuy(){
        return amountOfBuys;
    }
    
//RESET
    public void cleanUp(){
        amountOfCurrency = 0;
        amountOfActions = 1;
        amountOfBuys = 1;
    }
}
