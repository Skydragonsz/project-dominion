/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Card;
import dominion.DataConnection;
import dominion.Login;

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
        String lastline = "";
        String result = "Adventurer || 6 || Action";
        



        for (Card card : databaseConnection.getAllCards(2)){

        System.out.println(card.getName() + " || "+ card.getCost() + " || "+ card.getType());

        lastline = card.getName() + " || "+ card.getCost() + " || "+ card.getType();
        }
        
        assertEquals(lastline, result);
    
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
    
    
    @Test
    public void testLogon(){

    	Login l = new Login();

    	System.out.println(l.logon("root", "toor"));
    }
    
    
    
}
