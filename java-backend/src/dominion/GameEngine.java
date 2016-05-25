package dominion;

import java.util.*;

public class GameEngine {

    // Player
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<Player> otherPlayerList = new ArrayList<>();
    private int playerCounter = 1;

    // Turn
    private ArrayList<Turn> turnList = new ArrayList<>();
    
    // Board
    private Board board = new Board();

    // Cards
    private ArrayList<Card> allCards;
    private Pile currentDiscardPile;
    private DataConnection databaseConnection = new DataConnection();
    
    //Extra
    private SaveGame saveGame = new SaveGame();
    
    public GameEngine() {
    }


    
    /* INIT */
    public void initAmountPlayers(int amount) {
        for (int i = 0; i < amount; i++) {
            playerList.add(new Player());
        }
        
    }

    public void initPlayer(int playernr, String name) {
        getPlayer(playernr).setName(name); // Sets name
        getPlayer(playernr).setDeck(generateDeck()); //Generates deck (Each player needs a DIFFERENT deck object)
        getPlayer(playernr).init(); //init player

    }
    
    public void initPlayer(int playernr, String name, Pile deck, Pile hand, Pile discardPile,Pile playingField) {
        getPlayer(playernr).setName(name);
        getPlayer(playernr).setDeck(deck);  
        getPlayer(playernr).getHand().add(hand);
        getPlayer(playernr).getDiscardPile().add(discardPile);
        getPlayer(playernr).getPlayingField().add(playingField);
        

    }
    
    public void init(){
        nextTurn(1);
    }
    
    public void initAllCards(){
    	allCards = databaseConnection.getAllCards();
    }
    
    public void initAllCards(int set){
    	allCards = databaseConnection.getAllCards(set);
    }
    
    public void initCards(){
    	initAllCards(); //placeholder 1   	
    	generateBoard();
    }
    
    public void initCards(int set){
    		
    		generateBoard(set);
    }

    /* METHODS */
    public Pile generateDeck() {
    	System.out.print("\n generateDeck:" + getAllCards() + "\n");
    	Card copper = CallCard("Copper");
    	//System.out.print("Een copper kaart in generateDeck -- GameEngine CallCard: " + CallCard("Copper")  + " " + CallCard("Copper").getName() + "\n");
    	//System.out.print("Een copper kaart in generateDeck -- GameEngine: " + copper  + " " + copper.getName() + "\n");
    	Card estate = CallCard("Estate");
        return new Pile(copper,copper,copper,copper,copper,copper,copper,estate,estate,estate);
    }
    
    public void generateBoard(){
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

    	Board board = new Board(this,copper,silver, gold, estate, duchy, province, curse, cellar, market, militia, mine, moat, remodel, smithy, village, woodcutter, workshop);
    	this.board = board;
    	
    	
    }
    
    public void generateBoard(int set){
    	if(set == 0){
    		generateRandomBoard();
    	}else{
    		initAllCards(set);
	    	Card card1 = CallCard(0);
	    	Card card2 = CallCard(1);
	    	Card card3 = CallCard(2);
	    	Card card4 = CallCard(3);
	    	Card card5 = CallCard(4);
	    	Card card6 = CallCard(5);
	    	Card card7 = CallCard(6);
	    	Card card8 = CallCard(7);
	    	Card card9 = CallCard(8);
	    	Card card10 = CallCard(9);
	    	Card card11 = CallCard(10);
	    	Card card12 = CallCard(11);
	    	Card card13 = CallCard(12);
	    	Card card14 = CallCard(13);
	    	Card card15 = CallCard(14);
	    	Card card16 = CallCard(15);
	    	Card card17 = CallCard(16);
	    	
	    	Board board = new Board(this,card1,card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17);
	    	this.board = board;
    	}
    	
    }
    
    private void generateRandomBoard(){
    	ArrayList<Integer> random = generateRandomSet();

    	initAllCards();

    	Card card1 = CallCard(0);
    	Card card2 = CallCard(1);
    	Card card3 = CallCard(2);
    	Card card4 = CallCard(3);
    	Card card5 = CallCard(4);
    	Card card6 = CallCard(5);
    	Card card7 = CallCard(6);
    	Card card8 = CallCard(random.get(0));
    	Card card9 = CallCard(random.get(1));
    	Card card10 = CallCard(random.get(2));
    	Card card11 = CallCard(random.get(3));
    	Card card12 = CallCard(random.get(4));
    	Card card13 = CallCard(random.get(5));
    	Card card14 = CallCard(random.get(6));
    	Card card15 = CallCard(random.get(7));
    	Card card16 = CallCard(random.get(8));
    	Card card17 = CallCard(random.get(9));

    	Board board = new Board(this,card1,card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17);
    	this.board = board;
    	
    	
    }
    
    private ArrayList<Integer> generateRandomSet() {
        int RandomNumber;
        Random r = new Random();
        ArrayList<Integer> RandomSet = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            RandomSet.add(i);
        }
        int Low = 8;
        int High = 32;
        for (int i = 0; i < RandomSet.size(); i++) {
            RandomNumber = r.nextInt(High - Low) + Low;
            while (RandomSet.contains(RandomNumber)) {
                RandomNumber = r.nextInt(High - Low) + Low;
            }
            RandomSet.set(i, RandomNumber);
        }
        return RandomSet;
    }
    
    
    public Card CallCard(String name){
    	if(allCards.isEmpty()){
    		initAllCards();
    		
    	}
    	Card foundCard = null;
        for (Card card : allCards){
        	if (name.equals(card.getName())){
        		foundCard = card;
        		break;
        	}
        }
        return foundCard;
    }  
    
    public Card CallCard(int index){
    	if(allCards == null){
    		initAllCards(1);
    		
    	}
        return allCards.get(index);
    } 
    
    public Board getBoard() {
		return board;
	}

	public ArrayList<Card> getAllCards() {
		return allCards;
	}

	public void playCard(String cardName){
		Card card = CallCard(cardName);
    	
		if((!card.getType().equals("Victory") && getCurrentTurnSegment().getAction() > 0) || card.getType().equals("Treasure")){
			System.out.print("Een kaart in playCard -- GameEngine: " + card  + " " + card.getName() + "\n");
		    	card.PlayCard(getCurrentPlayer(), getOtherPlayersList(getCurrentPlayer()), getCurrentTurnSegment());
		    	//			stPlayer.getDiscardPile().addFrom(card, stPlayer.getHand());
		    	getCurrentPlayer().getPlayingField().addFrom(card, getCurrentPlayer().getHand());

		    	if(!card.getType().equals("Treasure")){
		    		getCurrentTurnSegment().removeAction(1);

		    	}
	    	
			}
		
//		System.out.println(card);
//		getCurrentPlayer().getPlayingField().addFrom(card, getCurrentPlayer().getHand());
		
		}
		
	
	
	public void buyCard(int option){
		if(getCurrentTurnSegment().getBuy() > 0){
		
			Card card = getBoard().getFromIndex(option).getFromIndex(0);
		

	        if (getCurrentTurnSegment().getCoin() >= card.getCost()){
	        	getCurrentPlayer().getDiscardPile().addAmountOfCardsFrom(1, getBoard().getFromIndex(option));
	        	getCurrentTurnSegment().removeBuy(1);
	        	getCurrentTurnSegment().removeCoin(card.getCost());
	        }
        }
        
		
	}
	
	public void buyInstancedCard(int option){
		
		Card card = getBoard().getFromIndex(option).getFromIndex(0);
		
		if (getCurrentTurnSegment().getInstancedCoin() >= card.getCost()){
			getCurrentPlayer().getDiscardPile().addAmountOfCardsFrom(1, getBoard().getFromIndex(option));
			getCurrentTurnSegment().removeInstancedCoin();
		} else {
			System.out.println("Error, not enough coins!");
		}
	}
	
public void buyCard(Card card){
	if(getCurrentTurnSegment().getBuy() > 0){
		for (Pile pile : getBoard().getPiles()) {
			if (!pile.isPileEmpty() && card.getName().equals(pile.getFromIndex(0).getName())) {
	
		        if (getCurrentTurnSegment().getCoin() >= card.getCost()){
		        	getCurrentPlayer().getDiscardPile().addAmountOfCardsFrom(1, pile);
		        	getCurrentTurnSegment().removeBuy(1);
		        	getCurrentTurnSegment().removeCoin(card.getCost());
		        	
		        }
			}
		}
	}
	
//        if (getCurrentTurnSegment().getCoin() >= card.getCost()){
//        	getCurrentPlayer().getDiscardPile().addAmountOfCardsFrom(1, getBoard().getFromIndex(option));
//        	getCurrentTurnSegment().removeBuy(1);
//        	getCurrentTurnSegment().removeCoin(getCurrentTurnSegment().getCoin());
//        	
//        }
        
		
	}

	public void loadGame(int gameID){
		if(gameID == 0){
			generateBoard(1);
		}else{
			saveGame.load(this, gameID);
		}
	}
	
	public void saveGame(String name){
		saveGame.save(this,name);	
	}
	
	public boolean isGameOver(){
		return board.isGameEnding();
	}


    /* GETTERS */
//Player    
    public Player getPlayer(int playernr) {
        return playerList.get(playernr - 1);
    }

    public Player getCurrentPlayer() {
        return playerList.get(playerCounter - 1);
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

//Turn        
    public Turn getTurn(int NthTurn) {
        return turnList.get(NthTurn);
    }

    public int getTurnNumber() {
        return turnList.size();
    }

    public TurnSegment getCurrentTurnSegment() {
        return getCurrentTurn().getCurrentTurnSegment(playerCounter - 1);
    }
    
    
    public int getPlayerCounter() {
		return playerCounter;
	}
    
    public void setPlayerCounter(int currentPlayer) {
		this.playerCounter = currentPlayer;
	}

	public Turn getCurrentTurn(){
    	return turnList.get(turnList.size()-1);
    }
    
    public void nextTurn(int turnNumber){
    	turnList.add(new Turn(turnNumber,this));
    }
    
    public void setCurrentTurn(int turnNumber){
    	for (int i = 0; i < turnNumber;i++){
    		turnList.add(new Turn(i,this));
    	}
    }
    
    public void nextPlayer(){
    	playerCounter = playerCounter % getMaxPlayers() + 1;
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
	
	public Pile getCurrentdiscardPile(){
		return currentDiscardPile;
	}
	
}
