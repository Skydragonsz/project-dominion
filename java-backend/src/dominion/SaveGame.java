package dominion;

import java.util.ArrayList;



public class SaveGame {
	private DataConnection dc = new DataConnection();
	private String sql = new String();
	
	public SaveGame(){
		
	}
	
	
	private String stringify(Pile pile){
		String newPile = new String();
		
		for(int i = 0; i < pile.getAmount(); i++){

			if(i == pile.getAmount() -1){
				newPile += pile.getFromIndex(i).getName();
			}else{
				newPile += pile.getFromIndex(i).getName() + ",";
			}
		}
		return newPile;
	}
	
	private Pile splitify(String string){
		String[] list = string.split(",");
		Pile pile = new Pile();
		if(!(list[0].length() == 0)){
			for(int i = 0; i < list.length ; i++){

				pile.add(GameEngine.CallCard(list[i]));
			}
		}
		return pile;
	}
	
	public void save(GameEngine ge,String name){
		
		saveGameSQL(ge,name);
		savePlayerSQL(ge,getLastGameID());
		saveBoardSQL(ge,getLastGameID());
		
		
	}
	
	public void save(GameEngine ge){
		
		saveGameSQL(ge,"");
		savePlayerSQL(ge,getLastGameID());
		saveBoardSQL(ge,getLastGameID());
		
		
	}
	
	private void savePlayerSQL(GameEngine ge, int gameID){
		
		sql = "INSERT INTO player VALUES";
		
		
		for(int i = 1; i <= ge.getMaxPlayers();i++){
			//sql += "(" + i +","+gameID+",'deck','hand','discard','playing','name')";
			sql += "(" + i +","+gameID+",'";
			sql += stringify(ge.getPlayer(i).getDeck()) + "','";
			sql += stringify(ge.getPlayer(i).getHand()) + "','";
			sql += stringify(ge.getPlayer(i).getDiscardPile()) + "','";
			sql += stringify(ge.getPlayer(i).getPlayingField()) + "','";
			sql += ge.getPlayer(i).getName() + "')";
			
			
			if(!(i == ge.getMaxPlayers())){sql += ",";}		
			else{sql += ";";}
		}
		
		//System.out.println(sql);
		dc.executeSQL(sql);
	}
	
	private void saveGameSQL(GameEngine ge,String name){
		
		if(name.isEmpty()){name="NOW()";}
		int amountPlayers = ge.getMaxPlayers();
		int turn = ge.getCurrentTurn().getCurrentTurnNumber();
		int currentPlayer = ge.getPlayerCounter();
		
		sql = "INSERT INTO game(amountOfPlayers,turn,currentPlayer,DATE,name) VALUES (" + amountPlayers + "," + turn + "," + currentPlayer + ",NOW(), "+ name + ")";
		dc.executeSQL(sql);
	}
	
	public int getLastGameID(){
		
		String strGameID = new String();
		int gameID;
		sql = "SELECT gameID FROM game ORDER BY gameID DESC LIMIT 1";
		
		strGameID = dc.executeSelectSQL(sql).toString();
		strGameID = strGameID.substring(0, strGameID.length()-1);
		
		gameID = Integer.parseInt(strGameID);
		return gameID;
	}
	
	
	
	private void saveBoardSQL(GameEngine ge, int gameID){
		
		sql = "INSERT INTO board VALUES ";
		for(int i = 0; i < ge.getBoard().getPiles().size();i++){
			
			sql += "(" + gameID + ",'" + ge.getBoard().getFromIndex(i).getFromIndex(0).getName() +  "'," + ge.getBoard().getFromIndex(i).getAmount() + "," + i + ")";
			
			if(!(i == ge.getBoard().getPiles().size() -1)){sql += ",";}		
			else{sql += ";";}
		}
		dc.executeSQL(sql);
	}
	
	public void load(GameEngine ge,int gameID){
		loadGame(ge,gameID);
		loadBoard(ge,gameID);
		loadPlayers(ge,gameID);
		
	}
	
	private int getGameInfo(String info, int gameID){
		sql = "SELECT * FROM game WHERE gameID = " + gameID;
		return dc.getIntFromSelect(sql, info);
	}
	
	public ArrayList<Integer> loadAllGameID(GameEngine ge){
		ArrayList<Integer> value = new ArrayList<Integer>();
		
		return value;
	}
	
	private void loadGame(GameEngine ge, int gameID){
		
		
		ge.nextTurn(getGameInfo("turn",gameID));
		ge.setPlayerCounter(getGameInfo("currentPlayer",gameID));	
	}
	
	private void loadPlayers(GameEngine ge, int gameID){
		ArrayList<String> playerData = new ArrayList<String>();
		Pile deck;
		Pile hand;
		Pile discardPile;
		Pile playingField;
		String name = new String();
		for(int i = 1; i <= ge.getMaxPlayers();i++){
			sql ="SELECT * FROM player WHERE gameID = " + gameID + " AND playerID= " + i;
			playerData = dc.getStringFromSelect(sql, "deck","hand","discardPile","playingField","name");
			
			deck = splitify(playerData.get(0));
			hand = splitify(playerData.get(1));
			discardPile = splitify(playerData.get(2));
			playingField = splitify(playerData.get(3));
			name = playerData.get(4);
			
			ge.initPlayer(i, name, deck, hand, discardPile, playingField);
		}
		
	}
	
	
    private void loadBoard(GameEngine ge, int gameID){
    	
    	// TEMP fix
    	ge.generateBoard();
    	ge.getBoard().getPiles().clear();
    	
    	
    	for(int i = 0; i < 17;i++){
    		sql = "SELECT name, amount FROM board WHERE (boardID = "+gameID+" AND `index` = "+i +")";
    		//sql = "SELECT name FROM board WHERE (boardID = "+gameID+" AND `index` = "+i +")";
    		String[] cardAndAmount = dc.executeSelectSQL(sql).split(",");
    		cardAndAmount[1] = cardAndAmount[1].substring(0, cardAndAmount[1].length()-1);
    		
    		
    		Card card = GameEngine.CallCard(cardAndAmount[0]);


    		int amount = Integer.parseInt(cardAndAmount[1]);
    		
    		ge.getBoard().addPileToBoardWithAmount(card, amount);
    		
    	}
    }
	
	 
	

	
	
	
	
}
