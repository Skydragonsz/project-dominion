package dominion;

public class Login {
	private DataConnection dbCon = new DataConnection();
	private String sql;
	
	public Login(){
		
	}
	
	public void register(String name, String pass){
		sql = "INSERT INTO account(name,pass) VALUE('" + name + "','" + pass +"');" ;
		dbCon.executeSQL(sql);
	}

	


}
