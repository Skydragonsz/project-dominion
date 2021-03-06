package dominion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * @author Quinten
 */
public class DataConnection {
	// Info connection
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String databaseConnection = "jdbc:mysql://localhost:3306/dominiondb";

	private static final String username = "dominion";
	private static final String password = "dominion";
	
	private ArrayList<Card> allCards = new ArrayList<Card>();

	//om te Testen
	public ArrayList<Card> getAllCards() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			allCards.clear();
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();
			String sql;

			sql = "SELECT card.ID, card.name, card.cost, cardtype.cardType, card.info, card.addMoney, card.addBuy, card.addAction, card.addCard, card.hasSpecialAction, card.value";
			sql += " FROM card";
			sql += " INNER JOIN cardtype";
			sql += " ON card.cardTypeID = cardtype.cardTypeID";
			sql += " ORDER BY card.ID;";
			
			
			
			
//			sql = "SELECT card.ID, card.name, card.cost, cardtype.cardType, card.info, card.addMoney, card.addBuy, card.addAction, card.addCard, card.hasSpecialAction, card.value";
//			sql += " FROM kingdomset";
//			sql += " INNER JOIN kingdomset_cards";
//			sql += " ON kingdomset_cards.ID = kingdomset.kingdomSetID";
//			sql += " INNER JOIN card";
//			sql += " ON card.ID = kingdomset_cards.cardID";
//			sql += " INNER JOIN cardtype";
//			sql += " ON cardtype.cardTypeID = card.cardTypeID";
//			sql += " WHERE kingdomset.kingdomSetID = 6 OR kingdomset.kingdomSetID = " + kingdomSetID;
//			sql += " ORDER BY kingdomset_cards.cardID";

			
			
			ResultSet rs = stmt.executeQuery(sql);

			// Processing receive data
			while (rs.next()) {

				String name = rs.getString("name");
				String type = rs.getString("cardType");
				String description = rs.getString("info");

				int cost = rs.getInt("cost");
				int value = rs.getInt("value");

				int additionalMoney = rs.getInt("addMoney");
				int additionalCard = rs.getInt("addCard");
				int additionalAction = rs.getInt("addAction");
				int additionalBuy = rs.getInt("addBuy");

				boolean hasSpecialAction = rs.getBoolean("hasSpecialAction");

				
				
				allCards.add(new Card(name, type, description, cost, value, additionalMoney, additionalCard,
						additionalAction, additionalBuy, hasSpecialAction));

				// Print Test
				// System.out.println("ID: " + id + ", Name: " + name + " : " +
				// description + " : " + type + " : " + cost + " : " + value + "
				// : " + additionalMoney + " : " + hasSpecialAction);
			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return allCards;
	}// end main
	
	
	public ArrayList<Card> getAllCards(int kingdomSetID) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();
			String sql;

//			sql = "SELECT card.ID, card.name, card.cost, cardtype.cardType, card.info, card.addMoney, card.addBuy, card.addAction, card.addCard, card.hasSpecialAction, card.value";
//			sql += " FROM card";
//			sql += " INNER JOIN cardtype";
//			sql += " ON card.cardTypeID = cardtype.cardTypeID";
//			sql += " ORDER BY card.ID;";
			
			
			
			
			sql = "SELECT card.ID, card.name, card.cost, cardtype.cardType, card.info, card.addMoney, card.addBuy, card.addAction, card.addCard, card.hasSpecialAction, card.value";
			sql += " FROM kingdomset";
			sql += " INNER JOIN kingdomset_cards";
			sql += " ON kingdomset_cards.ID = kingdomset.kingdomSetID";
			sql += " INNER JOIN card";
			sql += " ON card.ID = kingdomset_cards.cardID";
			sql += " INNER JOIN cardtype";
			sql += " ON cardtype.cardTypeID = card.cardTypeID";
			sql += " WHERE kingdomset.kingdomSetID = 6 OR kingdomset.kingdomSetID = " + kingdomSetID;
			sql += " ORDER BY kingdomset_cards.cardID";

			
			
			ResultSet rs = stmt.executeQuery(sql);

			// Processing receive data
			while (rs.next()) {

				String name = rs.getString("name");
				String type = rs.getString("cardType");
				String description = rs.getString("info");

				int cost = rs.getInt("cost");
				int value = rs.getInt("value");

				int additionalMoney = rs.getInt("addMoney");
				int additionalCard = rs.getInt("addCard");
				int additionalAction = rs.getInt("addAction");
				int additionalBuy = rs.getInt("addBuy");

				boolean hasSpecialAction = rs.getBoolean("hasSpecialAction");

				
				
				allCards.add(new Card(name, type, description, cost, value, additionalMoney, additionalCard,
						additionalAction, additionalBuy, hasSpecialAction));

				// Print Test
				// System.out.println("ID: " + id + ", Name: " + name + " : " +
				// description + " : " + type + " : " + cost + " : " + value + "
				// : " + additionalMoney + " : " + hasSpecialAction);
			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return allCards;
	}// end main
	
	public Map<Integer,String> loadGameID() {
		Connection conn = null;
		Statement stmt = null;
		Map<Integer,String> data = new LinkedHashMap<Integer, String>();
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();
			String sql;
			
			sql = "SELECT * FROM game;";

			
			
			ResultSet rs = stmt.executeQuery(sql);

			// Processing receive data
			while (rs.next()) {

				data.put(rs.getInt("gameID"), rs.getString("name"));

			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return data;
	}
	
	
	
	public void executeSQL(String sql){
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.prepareStatement(sql);
			stmt.execute(sql);

			//Close
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		
	}
	
	public String executeSelectSQL(String sql){
		String value = new String();
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			// Processing receive data
			while (rs.next()) {

				for (int i = 1; i <= rsmd.getColumnCount();i++){

						if(i >= rsmd.getColumnCount()){
							value += rs.getString(i) + ";";
						}else{
							value += rs.getString(i) + ",";
						}
				}	
			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return value;
	}
	
	public int getIntFromSelect(String sql, String columnName){
		int value = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			

			// Processing receive data
			while (rs.next()) {
				value = rs.getInt(columnName);
				
			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return value;
	}

	
	public ArrayList<String> getStringFromSelect(String sql, String... columnName){
		
		ArrayList<String> value = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			

			// Processing receive data
			while (rs.next()) {
				for(String name : columnName){
					value.add(rs.getString(name));
				}
				
				
			}
			// End
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return value;
	}

	
}


