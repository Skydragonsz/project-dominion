/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;
import java.sql.*;

/**
 *
 * @author Quinten
 */
public class DataConnection {
// JDBC driver name and database URL
   static final String driver = "com.mysql.jdbc.Driver";  
   static final String databaseConnection = "jdbc:mysql://178.117.108.9:3306/dominiondb";

   //  Database credentials
   static final String username = "dominion";
   static final String password = "dominion";
   private static int  idValue;
   
   public void connect() {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(databaseConnection,username,password);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM card;";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  =+ rs.getInt("id");
         String name = rs.getString("name");

         //Display values
         System.out.println("ID: " + id + ", Name: " + name);
         idValue = id;
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
   public int returnSomething(){
   return idValue;
   }
}//end FirstExample
