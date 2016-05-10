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

    public TurnSegment() {
        this.currency = 0;
        this.instancedCurrency = 0;
        this.action = 1;
        this.buy = 1;
    }

    /* METHODS */
//Add
    public void addCoin(int amount) {
            currency += amount;
    }

    public void addInstancedCoin(int amount) {
            instancedCurrency += amount;
    }

    public void addAction(int amount) {
            action += amount;
    }

    public void addBuy(int amount) {
            buy += amount;
    }

//Remove   
    public void removeCoin(int amount) {
            currency -= amount;
    }

    public void removeInstancedCoin(int amount) {
            instancedCurrency -= amount;
    }

    public void removeAction(int amount) {
            action -= amount;
    }

    public void removeBuy(int amount) {
            buy -= amount;

    }

    /* GETTERS */
    public int getCoin() {
        return currency;
    }

    public int getInstancedCoin() {
        return instancedCurrency;
    }

    public int getAction() {
        return action;
    }

    public int getBuy() {
        return buy;
    }
}
