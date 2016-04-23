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

	public ArrayList<Card> getAllCards() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Connection to database
			conn = DriverManager.getConnection(databaseConnection, username, password);

			// Query
			stmt = conn.createStatement();
			String sql;
			// TODO: Query statement still needs joins.
			// ex: [Now] CardType = 1 || [What we need] CardType = Treasure
			sql = "SELECT * FROM card;";
			ResultSet rs = stmt.executeQuery(sql);

			// Processing receive data
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("cardTypeID");
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
}
