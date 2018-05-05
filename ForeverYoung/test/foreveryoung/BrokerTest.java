/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static foreveryoung.Broker.statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class BrokerTest {
    
    public BrokerTest() {
    }
    
    /**
     * Only the shutdown method appears to be working in the JUNIT testing.
     * For some unknown reason is showing NullPointerExceptions every time
     * the broker class is called or trying to obtain information.
     * 
     * The failures appear to only occur in this test but the program runs 
     * perfectly fine outside of these tests in particular. 
     * @author Ryan
     */
    
    Broker broke;
    
    @Before
    public void setUp() throws SQLException {
        broke = new Broker();
    }

    /**
     * Test of shutdown method, of class Broker.
     */
    @Test
    public void testShutdown() {
        System.out.println("shutdown");
        broke.shutdown();
    }

    /**
     * Test of addUser method, of class Broker.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary", "Ryan");
        boolean expResult = true;
        boolean result = broke.addClient(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Broker.
     */
    
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String username = "Ryan";
        String expResult = "Ryan";
        User result = broke.getUser(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClients method, of class Broker.
     */
    
    @Test
    public void testGetClients() throws SQLException {
        System.out.println("getClients");
        User practitioner = new User(); 
        ArrayList<User> expResult = null;
        ArrayList<User> result = broke.getClients(practitioner);
        assertEquals(expResult, result); 
    }
    
}
