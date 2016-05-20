package dominion;

import java.util.ArrayList;



public class SaveGame {
	private DataConnection dc = new DataConnection();

	
	public SaveGame(){
		
	}
	
	
	public String stringify(Pile pile){
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
	
	public Pile splitify(String string){
		String[] list = string.split(",");
		Pile pile = new Pile();
		for(int i = 0; i < list.length ; i++){
			if(i == list.length - 1){
				list[i] = list[i].substring(0, list[i].length()-1);
			}
			pile.add(GameEngine.CallCard(list[i]));
		}
		return pile;
	}
	
	public void save(GameEngine ge){
		
		saveGameSQL(ge);
		savePlayerSQL(ge,getGameID());
		saveBoardSQL(ge,getGameID());
		
		
	}
	
	private void savePlayerSQL(GameEngine ge, int gameID){
		String sql = new String();
		sql = "INSERT INTO player VALUES";
		
		
		for(int i = 1; i < ge.getMaxPlayers() +1;i++){
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
	
	private void saveGameSQL(GameEngine ge){
		String sql = new String();

		int amountPlayers = GameEngine.getMaxPlayers();
		int turn = ge.getCurrentTurn().getCurrentTurnNumber();
		int currentPlayer = ge.getPlayerCounter();
		
		sql = "INSERT INTO game(amountOfPlayers,turn,currentPlayer,DATE) VALUES (" + amountPlayers + "," + turn + "," + currentPlayer + ",NOW())";
		dc.executeSQL(sql);
	}
	
	public int getGameID(){
		String sql = new String();
		String strGameID = new String();
		int gameID;
		sql = "SELECT gameID FROM game ORDER BY gameID DESC LIMIT 1";
		
		strGameID = dc.executeSelectSQL(sql).toString();
		strGameID = strGameID.substring(0, strGameID.length()-1);
		
		gameID = Integer.parseInt(strGameID);
		return gameID;
	}
	
	
	
	private void saveBoardSQL(GameEngine ge, int gameID){
		String sql = new String();
		sql = "INSERT INTO board VALUES ";
		for(int i = 0; i < ge.getBoard().getPiles().size();i++){
			
			sql += "(" + gameID + ",'" + ge.getBoard().getFromIndex(i).getFromIndex(0).getName() +  "'," + ge.getBoard().getFromIndex(i).getAmount() + "," + i + ")";
			
			if(!(i == ge.getBoard().getPiles().size() -1)){sql += ",";}		
			else{sql += ";";}
		}
		dc.executeSQL(sql);
	}
	
	public void load(GameEngine ge,int gameID){
		
		loadBoard(ge,gameID);
		loadPlayers(ge,gameID);
		
	}
	
	private void loadPlayers(GameEngine ge, int gameID){
		
	}
	
	
    private void loadBoard(GameEngine ge, int gameID){
    	String sql = new String();
    	
    	ge.getBoard().getPiles().clear();
    	
    	for(int i = 0; i < 17;i++){
    		sql = "SELECT name, amount FROM board WHERE (boardID = "+gameID+" AND `index` = "+i +")";
    		//sql = "SELECT name FROM board WHERE (boardID = "+gameID+" AND `index` = "+i +")";
    		String[] cardAndAmount = dc.executeSelectSQL(sql).split(",");
    		cardAndAmount[1] = cardAndAmount[1].substring(0, cardAndAmount[1].length()-1);
    		
    		
    		Card card = ge.CallCard(cardAndAmount[0]);


    		int amount = Integer.parseInt(cardAndAmount[1]);
    		
    		ge.getBoard().addPileToBoardWithAmount(card, amount);
    		
    	}
    }
	
	 
	

	
	
	
	
}
