/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class PractitionerTest {
    
    public PractitionerTest() {
    }
    
    Broker broke;
    Client cli;
    @Before
    public void setUp() throws SQLException {
        broke = new Broker();
    }

    /**
     * Test of newClient method, of class Practitioner.
     * Working with two objects with matching values. Expected to fail the test. 
     */
    @Test
    public void testNewClient() {        
        Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        Client client = new Client("client011", "password", "John", "Doe", "Ryan");
        Client expResult = client;
        Client result = pract.newClient("client011", "password", "John", "Doe");
        assertEquals(expResult, result);
    }

    /**
     * Test of addClient method, of class Practitioner.
     * This test is expected to fail, due to the program unable to return a client. 
     * The test is actually dealing with two separate objects
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        User user = new User();
        Client client = new Client(user, "Ryan");
        Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        boolean expResult = true;
        boolean result = pract.addClient(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeClient method, of class Practitioner.
     */
    @Test
    public void testRemoveClient() {
        Client client = new Client("client01", "password", "John", "Doe", "Ryan");
        Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        pract.addClient(client);
        boolean expResult = true;
        boolean result = pract.removeClient(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClients method, of class Practitioner.
     */
    @Test
    public void testGetClients() {
        System.out.println("getClients");
         Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        ArrayList<Client> expResult = new ArrayList<>();
        ArrayList<Client> result = pract.getClients();
        assertEquals(expResult, result);
    }

    /**
     * Test of ClientsToString method, of class Practitioner.
     */
    @Test
    public void testClientsToString() {
        System.out.println("ClientsToString");
         Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        String expResult = "[]";
        String result = pract.ClientsToString();
        assertEquals(expResult, result);

    }
    
}
