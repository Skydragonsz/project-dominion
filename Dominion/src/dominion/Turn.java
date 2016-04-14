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
   private int amountOfInstancedCurrency = 0; //Bijvoorbeeld; "WORKSHOP: Gain a card costing up to 4coins"
   private int amountOfActions = 1;
   private int amountOfBuys = 1;
   private int turnNumber = 1;

   public Turn(){
       
   }
   
//ADD
   public void addCoin(int amount)
   {
       if (amountOfCurrency >=0){
        amountOfCurrency += amount;
       }
   }
   
   public void addInstancedCoin(int amount)
   {
       if (amountOfInstancedCurrency >=0){
        amountOfInstancedCurrency += amount;
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
   
   public void addTurn()
   {
      this.turnNumber += 1;
       
   }
//REMOVE   
   public void removeCoin(int amount)
   {
       if (amountOfCurrency - amount >=0){
       amountOfCurrency -= amount;
       }
   }
   
   public void removeInstancedCoin(int amount)
   {
       if (amountOfInstancedCurrency - amount >=0){
       amountOfInstancedCurrency -= amount;
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
    
    public int getInstancedCoin(){
        return amountOfInstancedCurrency;
    }
    
    public int getAction(){
        return amountOfActions;
    }
    
    public int getBuy(){
        return amountOfBuys;
    }
    
    public int getCurrentTurn(){
        return turnNumber;
    }
    
//RESET
    public void cleanUp(){
        amountOfCurrency = 0;
        amountOfInstancedCurrency = 0;
        amountOfActions = 1;
        amountOfBuys = 1;
    }
}
