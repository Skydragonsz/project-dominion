package dominion;

import java.util.*;
import cards.Functions.Collection;

//TODO: clean up code
public class Player extends TurnSegment {
//PLAYER
    //PLAYER INFO

    private String name;
    private int victoryPoints;
    private boolean HasReaction;

    //CARDS INFO
    private ArrayList currentSetArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList deckArray = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    private ArrayList handArray;
    private ArrayList playingFieldArray;
    private ArrayList discardArray;

    //OBJECTS
    private final Collection collection = new Collection();
    private GameEngine gameEngine;

//CONSTRUCTOR    
    public Player() {
        init();
    }

    public Player(String name) {
        this.name = name;
        init();
    }

//START-UP     
    public void init() {
        handArray = new ArrayList<Integer>();
        playingFieldArray = new ArrayList<Integer>();
        discardArray = new ArrayList<Integer>();

        shuffleDeck();
        setNthAmountOfCards(5);
    }

//FUNCTIONS
    //OTHER
    public void shuffleDeck() {
        Collections.shuffle(deckArray);
    }

    //Bekijkt heel de speler zijn hand voor een rection card.
    public Boolean checkForReactionCard() {
        //vlug declareren
        //TODO: clean code
        int CardID;
        HasReaction = false;
        for (int i = 0; i < handArray.size(); i++) {
            //TODO: check voor betere manier
            CardID = Integer.parseInt(handArray.get(i).toString());
            if ("REACTION".equals(collection.getCard(CardID).getCardType())) {
                HasReaction = true;
            }
        }
        return HasReaction;
    }

    public void isDeckEmpty() {
        if (deckArray.isEmpty()) {
            deckArray.addAll(discardArray);
            discardArray.clear();
            shuffleDeck();
        }
    }

    //ADD   
    //Voegt hoeveelheid aantal kaart(en) toe aan het deck.
    public void addCardToDeck(int CardID) {
        deckArray.add(CardID);
    }

    public void addCardToHand(int CardID) {
        handArray.add(CardID);
    }

    //Voegt kaart toe aan playingField
    //Bekijk welke van addToPlayingField effectief gebruikt wordt.
    public void addToPlayingField(int Index) {
        //VV Werkt VV
        playingFieldArray.add(handArray.get(Index));
        handArray.remove(Index);
    }

    public void addHandFromBuyTransaction(int Index) {
        handArray.add(currentSetArray.get(Index));
        // -1 bij amount van gekozen kaart.

    }

    public void addNthAmountOfPoints(int amount) {
        victoryPoints += amount;
    }

    //DISCARD
    public void discardNthCardFromDeck(int index) {
        deckArray.remove(index);
    }

    public void discardDeckToPile() {
        discardArray.addAll(deckArray);
        deckArray.clear();
    }

    public void discardHandToPile() {
        discardArray.addAll(handArray);
        handArray.clear();
    }

//GETTERS        
    public ArrayList<Integer> getDiscardPile() {
        return discardArray;
    }

    public ArrayList<Integer> getCurrentSetArray() {
        return currentSetArray;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getDeck() {
        return deckArray;
    }

    //Geeft het hele hand terug als een ArrayList.
    public ArrayList<Integer> getCardsInHand() {
        return handArray;
    }

    public Integer getCardInHand(int index) {
        return Integer.parseInt(handArray.get(index).toString());
    }
    
    public ArrayList<Integer> getPlayingField() {
        return playingFieldArray;
    }

//SETTERS    
    public void setName(String name) {
        this.name = name;
    }
    //Geeft de bovenste hoeveelheid gekozen kaarten van het deck naar de speler zijn hand.

    public void setNthAmountOfCards(int amount) {
        //Je kan niet meer kaarten trekken dan er in je deck zitten. Bijvoorbeeld: 3 kaarten in je deck en jij wilt 5 kaarten!
        if (amount <= (deckArray.size() + discardArray.size())) {
            for (int i = 0; i < amount; i++) { isDeckEmpty();
                handArray.add(deckArray.get(0));
                deckArray.remove(0);
            }
        } else { isDeckEmpty();
            for (int i = 0; i <= deckArray.size(); i++) {
                isDeckEmpty();
                handArray.add(deckArray.get(0));
                deckArray.remove(0);
            }
        }
    }
}
