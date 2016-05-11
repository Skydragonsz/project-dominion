package dominion;

import java.util.*;

public class GameEngine {

    // Player
    private final static ArrayList<Player> playerList = new ArrayList<>();
    private final static ArrayList<Player> otherPlayerList = new ArrayList<>();
    private int PlayerCounter = 1;

    // Turn
    private ArrayList<Turn> turnList = new ArrayList<>();
    
    // Board
    private Board board;

    // Cards
    private ArrayList<Card> allCards;
    private DataConnection databaseConnection = new DataConnection();
    
    public GameEngine() {

    }

    public static void main(String[] args) {

    }
    
    /* INIT */
    public void initAmountPlayers(int amount) {
        for (int i = 0; i < amount; i++) {
            playerList.add(new Player());
        }
    }

    public void initPlayer(int playernr, String name) {
        getPlayer(playernr).setDeck(generateDeck()); //Generates deck (Each player needs a DIFFERENT deck object)
        getPlayer(playernr).getDeck().shuffle(); // Shuffle deck
        getPlayer(playernr).getHand().addAmountOfCardsFrom(5, getPlayer(playernr).getDeck()); // Puts 5 cards from deck into hand
        getPlayer(playernr).setName(name); // Sets name
    }
    
    public void initCards(){ //NAME CHANGE
        allCards = databaseConnection.getAllCards();   	
    	generateBoard();
    }

    /* METHODS */
    public Pile generateDeck() {
    	Card copper = CallCard("Copper");
    	Card estate = CallCard("Estate");
        return new Pile(copper,copper,copper,copper,copper,copper,copper,estate,estate,estate);
    }
    
    public void generateBoard(){
    	// TEMP -- First game
    	Card copper = CallCard("Copper");
    	Card silver = CallCard("Silver");
    	Card gold = CallCard("Gold");
    	Card estate = CallCard("Estate");
    	Card duchy = CallCard("Duchy");
    	Card province = CallCard("Province");
    	Card curse = CallCard("Curse");
    	Card cellar = CallCard("Cellar");
    	Card market = CallCard("Market");
    	Card militia = CallCard("Militia");
    	Card mine = CallCard("Mine");
    	Card moat = CallCard("Moat");
    	Card remodel = CallCard("Remodel");
    	Card smithy = CallCard("Smithy");
    	Card village = CallCard("Village");
    	Card woodcutter = CallCard("Woodcutter");
    	Card workshop = CallCard("Workshop");

    	Board board = new Board(copper,silver, gold, estate, duchy, province, curse, cellar, market, militia, mine, moat, remodel, smithy, village, woodcutter, workshop);
    	this.board = board;
    }
    
    
    public Card CallCard(String name){
    	Card foundCard = null;
        for (Card card : allCards){
        	if (name.equals(card.getName())){
        		foundCard = card;
        		break;
        	}
        }
        return foundCard;
    }  
    
    public Board getBoard() {
		return board;
	}

	public ArrayList<Card> getAllCards() {
		return allCards;
	}

    //Will not change since many testers use this parameter configuration
	public void playCard(String cardName, Player player, ArrayList<Player> otherPlayerList, GameEngine gameEngine){
    	CardSpecialAction.playSpecialAction(cardName, player, otherPlayerList, gameEngine);
    }

	public void playCard(Card card, GameEngine gameEngine){
    	card.PlayCard(getCurrentPlayer(), getOtherPlayersList(getCurrentPlayer()), getCurrentTurnSegment(), gameEngine);
    }

    /* GETTERS */
//Player    
    public Player getPlayer(int playernr) {
        return playerList.get(playernr - 1);
    }

    public Player getCurrentPlayer() {
        return playerList.get(PlayerCounter - 1);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public int getMaxPlayers() {
        return playerList.size();
    }

    public Player getLastPlayers() {
        return playerList.get(playerList.size() - 1);
    }

    public ArrayList<Player> getOtherPlayersList(Player player) {
        //TEMP FIX
        otherPlayerList.clear();
        for (int i = 0; i < playerList.size(); i++) {
            if (player != playerList.get(i)) {
                otherPlayerList.add(playerList.get(i));
            }
        }
        return otherPlayerList;
    }

//Other
    public void PlayCardEffect(int index) {

    }

//Turn        
    public Turn getTurn(int NthTurn) {
        return turnList.get(NthTurn);
    }

    public int getTurnNumber(int NthTurn) {
        return turnList.get(NthTurn - 1).getCurrentTurnNumber();
    }

    public TurnSegment getCurrentTurnSegment() {
        return getCurrentTurn().getCurrentTurnSegment(PlayerCounter - 1);
    }
    
    
    public int getPlayerCounter() {
		return PlayerCounter;
	}

	public Turn getCurrentTurn(){
    	return turnList.get(turnList.size() - 1);
    }
    
    public void nextTurn(int turnNumber){
    	turnList.add(new Turn(turnNumber));
    }
    
    public void nextPlayer(){
    	PlayerCounter = PlayerCounter % 3 + 1;
    	//TEMP 3
    }

//other    
    public void reset() {
        otherPlayerList.clear();
        playerList.clear();
    }

	public void CleanedUp() {
		getCurrentPlayer().getDiscardPile().addAllFrom(getCurrentPlayer().getHand(), getCurrentPlayer().getPlayingField());
		if (getCurrentPlayer().getDeck().getAmount() == 0){
			getCurrentPlayer().getDeck().addAllFrom(getCurrentPlayer().getDiscardPile());
	}
		getCurrentPlayer().getHand().getPile().clear();
		getCurrentPlayer().getPlayingField().getPile().clear();
		getCurrentPlayer().getHand().addAmountOfCardsFrom(5, getCurrentPlayer().getDeck());
		
}
}
