package dominion;

//Extends needed?
public class Player extends TurnSegment {

    private String name;
    private int victoryPoints;

    private Pile deck = new Pile();
    private Pile hand = new Pile();
    private Pile discardPile = new Pile();
    private Pile playingField = new Pile();

    private boolean HasReaction;

    /* CONSTRUCTOR */
    public Player() {
        //init(); <-gives error
    }

    public Player(String name) {
        this.name = name;
        init();
    }

    /* INIT */
    public void init() {
        deck.shuffle();
        hand.addAmountOfCardsFrom(5, deck);
    }
    
    /* METHODS */
    public Boolean checkForReactionCard() {
        HasReaction = false;
        for (int i = 0; i < hand.getAmount(); i++) {
            if ("Reaction".equals(deck.getFromIndex(i).getType())) {
                HasReaction = true;
            }
        }
        return HasReaction;
    }

    /* GETTERS */
    public int getVictoryPoints() {
        return victoryPoints;
    }

    public String getName() {
        return name;
    }

    public Pile getDeck() {
        return deck;
    }

    public Pile getHand() {
        return hand;
    }

    public Pile getDiscardPile() {
        return discardPile;
    }

    public Pile getPlayingField() {
        return playingField;
    }

    /* SETTERS */
    public void setVictoryPoints(int amount) {
        victoryPoints += amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeck(Pile deck) {
        this.deck = deck;
    }
}
