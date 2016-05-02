/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Card;
import dominion.DataConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quint
 */
public class dbConnectionTester {
    
    public dbConnectionTester() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConnection(){
        DataConnection databaseConnection = new DataConnection();
        //databaseConnection.getAllCards();
        
        for (Card card : databaseConnection.getAllCards()){
        System.out.println(card.getName() + " || "+ card.getCost() + " || "+ card.getType());
        
        }
    
    }
    
    @Test
    public void testExecuteSQL(){
    	DataConnection dbCon = new DataConnection();
    	String sql;
    	
//    	sql = "INSERT INTO account(account.name,pass)";
//    	sql += " VALUES ('test','test')";
    	
    	sql = "SELECT * FROM card";
    	
    	dbCon.executeSQL(sql);
    }
    
    
    
}
