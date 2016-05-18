package dominion;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Quinten
 */
public class DataConnection {
	// Info connection
	static final String driver = "com.mysql.jdbc.Driver";
	static final String databaseConnection = "jdbc:mysql://178.117.108.9:3306/dominiondb";

	static final String username = "dominion";
	static final String password = "dominion";
	
	private ArrayList<Card> allCards = new ArrayList<Card>();

	//om te Testen
	public ArrayList<Card> getAllCards() {
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
	
	public int getLoginID(String accountUsername, String accountPass){
		Connection conn = null;
		Statement stmt = null;
		int ID = 0;
		
		try {
			// JDBC Driver
			Class.forName(driver);

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();
			String sql;

			sql = "SELECT ID FROM account";
			sql += " WHERE username = '" + accountUsername + "' AND pass = '"+ accountPass + "' LIMIT 1";
			
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			ID = rs.getInt("ID");
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
		return ID;
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

	
}


