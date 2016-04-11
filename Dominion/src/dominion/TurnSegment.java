/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

/**
 *
 * @author Quint
 */
//A turn is shared by all players.
//A turnSegment is for one player specific  
public class TurnSegment {
   private int currency;
   private int instancedCurrency; //Bijvoorbeeld; "WORKSHOP: Gain a card costing up to 4coins"
   private int action;
   private int buy;
    
   public TurnSegment(){
       this.currency = 0;
       this.instancedCurrency = 0;
       this.action = 1;
       this.buy = 1;
   }
   
//ADD
   public void addCoin(int amount)
   {
       if (currency >=0){
        currency += amount;
       }
   }
   
   public void addInstancedCoin(int amount)
   {
       if (instancedCurrency >=0){
        instancedCurrency += amount;
       }
   }
   
   public void addAction(int amount)
   {
       if (action >=0){
       action += amount;
       }
   }
   
   public void addBuy(int amount)
   {
       if (buy >=0){
       buy += amount;
       }
   }
   
//REMOVE   
   public void removeCoin(int amount)
   {
       if (currency - amount >=0){
       currency -= amount;
       }
   }
   
   public void removeInstancedCoin(int amount)
   {
       if (instancedCurrency - amount >=0){
       instancedCurrency -= amount;
       }
   }
   
   public void removeAction(int amount)
   {
       if (action - amount >=0){
            action -= amount;
       }
   }
   
   public void removeBuy(int amount)
   {
       if (currency - amount >=0){
       buy -= amount;
       }
   }
//GET   
    public int getCoin(){
        return currency;
    }
    
    public int getInstancedCoin(){
        return instancedCurrency;
    }
    
    public int getAction(){
        return action;
    }
    
    public int getBuy(){
        return buy;
    }
}
