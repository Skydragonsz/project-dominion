package login;

import java.sql.*;

public class Validate {
	static final String driver = "com.mysql.jdbc.Driver";
	static final String dbConnection = "jdbc:mysql://178.117.108.9:3306/dominiondb";

	static final String dbusername = "dominion";
	static final String dbpassword = "dominion";
	
	
     public static boolean checkUser(String username,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName(driver);

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection(dbConnection, dbusername, dbpassword);
         PreparedStatement ps =con.prepareStatement("select * from account where username=? and pass=?");
         ps.setString(1, username);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}
