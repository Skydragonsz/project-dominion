package dominion;

public class Player {

    private String name;
    private int victoryPoints;

    private Pile deck = new Pile();
    private Pile hand = new Pile();
    private Pile selectedHand = new Pile();
    private Pile pickedHand = new Pile();
    private Pile discardPile = new Pile();
    private Pile playingField = new Pile();

    private boolean HasReaction;

    /* CONSTRUCTOR */
    public Player() {
    }

    /* INIT */
    public void init() {
        deck.shuffle();
        hand.addAmountOfCardsFrom(5, deck);
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
    
    public Pile getSelectedHand() {
        return selectedHand;
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

	public Pile getPickedHand() {
		return pickedHand;
	}
}
