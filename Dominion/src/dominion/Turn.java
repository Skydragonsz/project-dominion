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
       if (this.amountOfCurrency <=0){
        this.amountOfCurrency += amount;
       }
   }
   
   public void addAction(int amount)
   {
       if (this.amountOfActions <=0){
       this.amountOfActions += amount;
       }
   }
   
   public void addBuy(int amount)
   {
       if (this.amountOfBuys <=0){
       this.amountOfBuys += amount;
       }
   }
   
//REMOVE   
   public void removeCoin(int amount)
   {
       if (this.amountOfCurrency - amount >=0){
       this.amountOfCurrency -= amount;
       }
   }
   
   public void removeAction(int amount)
   {
       if (this.amountOfActions - amount >=0){
            this.amountOfActions -= amount;
       }
   }
   
   public void removeBuy(int amount)
   {
       if (this.amountOfCurrency - amount >=0){
       this.amountOfBuys -= amount;
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
}
