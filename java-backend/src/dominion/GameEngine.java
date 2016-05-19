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
    private static ArrayList<Card> allCards;
    private static Pile currentDiscardPile;
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
        nextTurn(1);
    }

    public void initPlayer(int playernr, String name) {
        getPlayer(playernr).setName(name); // Sets name
        getPlayer(playernr).setDeck(generateDeck()); //Generates deck (Each player needs a DIFFERENT deck object)
        getPlayer(playernr).init(); //init player

    }
    
    public void init(){
        initCards();
    }
    
    public void initCards(){
        allCards = databaseConnection.getAllCards(); //placeholder 1   	
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
    
    
    public static Card CallCard(String name){
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

	public void playCard(Card card){
		if(card.getType().equals("Treasure") || getCurrentTurnSegment().getAction() > 0){
			if(!card.getType().equals("Victory")){
		    	card.PlayCard(getCurrentPlayer(), getOtherPlayersList(getCurrentPlayer()), getCurrentTurnSegment());
		    	getCurrentPlayer().getPlayingField().addFrom(card, getCurrentPlayer().getHand());

		    	if(!card.getType().equals("Treasure")){
		    		getCurrentTurnSegment().removeAction(1);

		    	}
	    	
			}
		}
		
    }
	
	
	public void buyCard(int option){

		
		Card card = getBoard().getFromIndex(option).getFromIndex(0);
		
		
        if (getCurrentTurnSegment().getCoin() >= card.getCost()){
        	getCurrentPlayer().getDiscardPile().addAmountOfCardsFrom(1, getBoard().getFromIndex(option));
        	getCurrentTurnSegment().removeBuy(1);
        	getCurrentTurnSegment().removeCoin(getCurrentTurnSegment().getCoin());
        	
        }
        
		
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

    public static int getMaxPlayers() {
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
    	PlayerCounter = PlayerCounter % getMaxPlayers() + 1;
    }

//other    
    public void reset() {
        otherPlayerList.clear();
        playerList.clear();
    }

	public void CleanedUp() {
		getCurrentPlayer().getDiscardPile().addAllFrom(getCurrentPlayer().getHand(), getCurrentPlayer().getPlayingField());
		getCurrentPlayer().getDeck().drawCards(5, getCurrentPlayer().getHand(), getCurrentPlayer().getDiscardPile());

		
}
	// I don't know.. is this correct?
	public void setCurrentDiscardPile(){
		currentDiscardPile = getCurrentPlayer().getDiscardPile();
	}
	
	public static Pile getCurrentdiscardPile(){
		return currentDiscardPile;
	}
	
}
