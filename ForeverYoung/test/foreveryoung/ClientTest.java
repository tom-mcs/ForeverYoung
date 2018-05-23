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
 * This is the Client test class. Like the other test classes, this test class 
 * specifies some code and verifies if the code is functioning correctly
 * @author Ryan
 */
public class ClientTest {
    
    public ClientTest() {
    }
    
   Broker broke;
    
    @Before
    public void setUp() throws SQLException {
       broke = new Broker(); 
    }

    /**
     * Test of loadStats method, of class Client.
     */
    @Test
    public void testLoadStats() {
        System.out.println("loadStats");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        boolean expResult = true;
        boolean result = client.loadStats(broke);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPractitionerName method, of class Client.
     */
    @Test
    public void testGetPractitionerName() {
        System.out.println("getPractitionerName");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        String expResult = "Ryan";
        String result = client.getPractitionerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAerobicExercise method, of class Client.
     */
    @Test
    public void testAddAerobicExercise() {
        System.out.println("addAerobicExercise");
        AerobicExercise ae = new AerobicExercise("Jogging");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        boolean expResult = true;
        boolean result = client.addAerobicExercise(ae);
        assertEquals(expResult, result);
    }

    /**
     * Test of addGoal method, of class Client.
     */
    @Test
    public void testAddGoal() {
        System.out.println("addGoal");
        Goal goal = new Goal("Jog 1m","you must run 1 metre");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        boolean expResult = true;
        boolean result = client.addGoal(goal);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGoals method, of class Client.
     */
    @Test
    public void testGetGoals() {
        System.out.println("getGoals");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        ArrayList<Goal> expResult = new ArrayList<>();
        ArrayList<Goal> result = client.getGoals();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAerobicExercises method, of class Client.
     */
    @Test
    public void testGetAerobicExercises() {
        System.out.println("getAerobicExercises");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        ArrayList<AerobicExercise> expResult = new ArrayList<>();
        ArrayList<AerobicExercise> result = client.getAerobicExercises();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client client = new Client(user, "Ryan");
        String expResult = client.getName();
        String result = client.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addWeightExercise method, of class Client.
     */
    @Test
    public void testAddWeightExercise() {
        System.out.println("addWeightExercise");
        WeightExercise we = new WeightExercise("Rowing");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01"); 
        boolean expResult = true;
        boolean result = sample.addWeightExercise(we);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeightExercises method, of class Client.
     */
    @Test
    public void testGetWeightExercises() {
        System.out.println("getWeightExercises");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01"); 
        ArrayList<WeightExercise> expResult = new ArrayList<>();
        ArrayList<WeightExercise> result = sample.getWeightExercises();
        assertEquals(expResult, result);
    }
    
}
