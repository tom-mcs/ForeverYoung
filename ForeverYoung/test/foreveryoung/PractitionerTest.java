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
    
    @Before
    public void setUp() throws SQLException {
        broke = new Broker();
    }

    /**
     * Test of newClient method, of class Practitioner.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String username = "client1";
        String password = "111";
        String firstName = "Charles";
        String lastName = "Darwin";
        Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
        User user = new User(username, password, firstName, lastName);
        Client client = new Client(user, "Ryan");
        Client expResult = client;
        Client result = pract.newClient(username, password, firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of addClient method, of class Practitioner.
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
        System.out.println("removeClient");
        User user = new User();
        Client client = new Client(user, "Ryan");
        Practitioner pract = new Practitioner("Ryan", "pass", "R","C");
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
