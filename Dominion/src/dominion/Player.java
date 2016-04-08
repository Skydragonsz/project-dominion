package dominion;

import java.util.*;

//TODO: clean up code
public class Player extends GameEngine {
//PLAYER
    //PLAYER INFO

    private String name;
    private int victoryPoints;
    private boolean HasReaction;

    //CARDS INFO
    private ArrayList currentSetArray = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList deckArray = new ArrayList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    private ArrayList handArray;
    private ArrayList playingFieldArray;
    private ArrayList discardArray;

    //OBJECTS
    private final cards.Functions.Collection collection = new cards.Functions.Collection();
    private GameEngine ge;

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
        handArray = new ArrayList();
        playingFieldArray = new ArrayList();
        discardArray = new ArrayList();

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
        System.out.println("-- VOOR DE LOOP -- ");
        System.out.println(handArray.size());
        System.out.println(handArray.size() - 1);
        for (int i = 0; i < handArray.size(); i++) {
            System.out.println("-- IN DE LOOP -- ");
            //TODO: check voor betere manier
            CardID = Integer.parseInt(handArray.get(i).toString());
            System.out.println(CardID);
            if ("REACTION".equals(collection.getCard(CardID).getCardType())) {
                System.out.println("-- IN DE IF -- ");
                System.out.println(collection.getCard(CardID).getCardType());

                HasReaction = true;
            }
        }
        System.out.println("-- NA DE LOOP DE LOOP -- ");
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

    public ArrayList<Integer> getPlayingField() {
        return playingFieldArray;
    }

//SETTERS    
    public void setName(String name) {
        this.name = name;
    }
        //Geeft de bovenste hoeveelheid gekozen kaarten van het deck naar de speler zijn hand.

    public void setNthAmountOfCards(int amount) {

        for (int i = 0; i < amount; i++) {
            isDeckEmpty();
            handArray.add(deckArray.get(0));
            deckArray.remove(0);
        }
    }
}
