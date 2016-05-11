package dominion;

import java.util.ArrayList;
import dominion.CardSpecialAction;
/**
 *
 * @author Quint
 */
public class Card {

    private String name;
    private String type;
    private String description;

    private int cost;
    private int value;

    private int additionalMoney;
    private int additionalCard;
    private int additionalAction;
    private int additionalBuy;

    private boolean hasSpecialAction;

    public Card(String name, String type, String description, int cost, int value, int additionalMoney, int additionalCard, int additionalAction, int additionalBuy, boolean hasSpecialAction) {
        this.name = name;
        this.type = type;
        this.description = description;

        this.cost = cost;
        this.value = value;

        this.additionalMoney = additionalMoney;
        this.additionalCard = additionalCard;
        this.additionalAction = additionalAction;
        this.additionalBuy = additionalBuy;

        this.hasSpecialAction = hasSpecialAction;
    }

    /* METHODS */
    public void PlayCard(Player player, ArrayList<Player> otherPlayerList, TurnSegment currentSegment, GameEngine gameEngine) {

    	currentSegment.addCoin(additionalMoney);
        player.getHand().addAmountOfCardsFrom(additionalCard, player.getDeck());
    	currentSegment.addAction(additionalAction);
    	currentSegment.addBuy(additionalBuy);

        if (hasSpecialAction) {
        	CardSpecialAction.playSpecialAction(name, player, otherPlayerList, gameEngine);        
        }
    }

    /* GETTERS */
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public int getValue() {
        return value;
    }

    public int getAdditionalMoney() {
        return additionalMoney;
    }

    public int getAdditionalAction() {
        return additionalAction;
    }

    public int getAdditionalBuy() {
        return additionalBuy;
    }

    public boolean isHasSpecialAction() {
        return hasSpecialAction;
    }
}
