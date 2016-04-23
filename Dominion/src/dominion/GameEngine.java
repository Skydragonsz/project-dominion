package dominion;

import java.util.*;

/**
 *
 * @author Arthur
 */
//TODO -- transfer Player methods to GameEngine
public class GameEngine {

    // Player
    private final static ArrayList<Player> playerList = new ArrayList<>();
    private final static ArrayList<Player> otherPlayerList = new ArrayList<>();
    private Player currentPlayer;
    private int PlayerCounter = 0;

    // Turn
    private ArrayList<Turn> turnList = new ArrayList<>();

    // KINGDOM SET
    private final static ArrayList<Integer> kingdomSetCards = new ArrayList<>();

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
        getPlayer(playernr).setDeck(generateDeck());
        getPlayer(playernr).setName(name);
    }
    
    public void initConnection(){
        allCards = databaseConnection.getAllCards();   	
    }

    /* METHODS */
    public Pile generateDeck() {
    	Card copper = CallCard("Copper");
    	Card estate = CallCard("Estate");
        return new Pile(copper,copper,copper,copper,copper,copper,copper,estate,estate,estate);
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
    
    public void playCard(String cardName, Player player, ArrayList<Player> otherPlayerList){
    	CardSpecialAction.playSpecialAction(cardName, player, otherPlayerList);
    }


    /* GETTERS */
//Player    
    public Player getPlayer(int playernr) {
        return playerList.get(playernr - 1);
    }

    public String getPlayerName(Player player) {
        return player.getName();
    }

    public Player getCurrentPlayer() {
        return playerList.get(PlayerCounter);
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

    public TurnSegment getTurnSegment(int NthTurn) {
        return turnList.get(NthTurn).getCurrentTurnSegment();
    }

    public int getTurnSegmentCoin(int NthTurn) {
        return turnList.get(NthTurn).getCurrentTurnSegment().getCoin();
    }

    public int getTurnSegmentActions(int NthTurn) {
        return turnList.get(NthTurn).getCurrentTurnSegment().getAction();
    }

//other    
    public void reset() {
        otherPlayerList.clear();
        playerList.clear();
    }
}
