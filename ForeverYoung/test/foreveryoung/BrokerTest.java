/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.sql.Connection;
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
    
    
    @Before
    public void setUp() {
    }

    /**
     * Test of shutdown method, of class Broker.
     */
    @Test
    public void testShutdown() {
        System.out.println("shutdown");
        Broker.shutdown();
    }

    /**
     * Test of addUser method, of class Broker.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User();
        boolean expResult = true;
        boolean result = Broker.addUser(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Broker.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String username = "Ryan";
        User expResult = new User();
        User result = Broker.getUser(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClients method, of class Broker.
     */
    @Test
    public void testGetClients() {
        System.out.println("getClients");
        User practitioner = new User();
        ArrayList<User> expResult = new ArrayList();
        expResult.add(practitioner);
        ArrayList<User> result = Broker.getClients(practitioner);
        assertEquals(expResult, result);
     
    }
    
}
