/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Before;
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
     * This is the test class for the Broker class. This test class can be considered the most
     * essential of all the test classes, as the program actually relies on the broker class
     * for main functionality
     * @author Ryan
     */
    
    Broker broke;
    public LocalDateTime date;
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
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01");      
        boolean result = broke.addClient(sample);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Broker.
     * This test is expected to fail since it is dealing with two separate objects
     * that holds the same value. 
     */
    
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Practitioner samp = new Practitioner("Practitioner01", "Richard", "Scary", "apple"); 
        User expResult = samp;
        User result = broke.getUser(samp.getUsername());
        assertEquals(expResult, result);
    }

    /**
     * Test of getClients method, of class Broker.
     */
    
    @Test
    public void testGetClients() {
        System.out.println("getClients");
        User user = new User();
        user.getUsername(); 
        ArrayList<Practitioner> expResult = new ArrayList<>();
        ArrayList<Client> result = new ArrayList<>();
        assertEquals(expResult, result); 
    }

    /**
     * Test of buildDB method, of class Broker.
     */
    @Test
    public void testBuildDB() {
        System.out.println("buildDB");
        broke.buildDB();
    }

    /**
     * Test of deleteDB method, of class Broker.
     */
    @Test
    public void testDeleteDB() {
        System.out.println("deleteDB");
        broke.deleteDB();
    }

    /**
     * Test of getDBVersionNum method, of class Broker.
     */
    @Test
    public void testGetDBVersionNum() {
        System.out.println("getDBVersionNum");
        int expResult = 4;
        int result = broke.getDBVersionNum();
        assertEquals(expResult, result);

    }

    /**
     * Test of addPractitioner method, of class Broker.
     */
    @Test
    public void testAddPractitioner() {
        System.out.println("addPractitioner");
        Practitioner user = new Practitioner("Practitioner01", "Richard", "Scary", "apple"); 
        boolean result = broke.addPractitioner(user);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class Broker.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        User sample = new User();
        String practitioner = sample.getUsername();
        Client user = new Client(sample, practitioner);
        broke.removeUser(user);
    }

    /**
     * Test of addAerobicExercise method, of class Broker.
     */
    @Test
    public void testAddAerobicExercise() {
        System.out.println("addAerobicExercise");
        AerobicExercise exercise = new AerobicExercise("Rowing");
        User sample = new User();
        String practitioner = sample.getUsername();
        Client client = new Client(sample, practitioner);
        int minutes = 12;
        boolean expResult = false;
        boolean result = broke.addAerobicExercise(date, minutes);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAerobicExercise method, of class Broker.
     */
    @Test
    public void testGetAerobicExercise() {
        System.out.println("getAerobicExercise");
        String exerciseName = "Rowing";
        User sample = new User();
        String practitioner = sample.getUsername();
        Client client = new Client(sample, practitioner);
        AerobicExercise expResult = null;
        AerobicExercise result = broke.getAerobicExercise(exerciseName, client);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllAerobicExercisesOfClient method, of class Broker.
     */
    @Test
    public void testGetAllAerobicExercisesOfClient() {
        System.out.println("getAllAerobicExercisesOfClient");
        User sample = new User();
        String practitioner = sample.getUsername();
        Client client = new Client(sample, practitioner);
        ArrayList<AerobicExercise> expResult = new ArrayList<>();
        ArrayList<AerobicExercise> result = broke.getAllAerobicExercisesOfClient(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of addExerciseEntry method, of class Broker.
     */
    @Test
    public void testAddExerciseEntry() {
        System.out.println("addExerciseEntry");
        AerobicExercise exercise = new AerobicExercise("Walk");
        User sample = new User();
        String practitioner = sample.getUsername();
        Client client = new Client(sample, practitioner);
        boolean expResult = false;
        boolean result = broke.addExercise(exercise, client);
        assertEquals(expResult, result);
    }

    /**
     * Test of addGoal method, of class Broker.
     */
    @Test
    public void testAddGoal() {
        System.out.println("addGoal");
        Goal goal = new Goal("Sell burgers", "Sell 2 burgers");
        User sample = new User();
        String practitioner = sample.getUsername(); 
        Client client = new Client(sample, practitioner);
        boolean expResult = false;
        boolean result = broke.addGoal(goal, client);
        assertEquals(expResult, result);
    }

    /**
     * Test of setGoalAsCompleted method, of class Broker.
     */
    @Test
    public void testSetGoalAsCompleted() {
        System.out.println("setGoalAsCompleted");
        Goal goal = new Goal("Sell burgers", "Sell 2 burgers");
        User sample = new User();
        String practitioner = sample.getUsername(); 
        Client client = new Client(sample, practitioner);
        boolean expResult = true;
        boolean result = broke.setGoalAsCompleted(goal, client);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGoals method, of class Broker.
     */
    @Test
    public void testGetGoals() {
        System.out.println("getGoals");
        User sample = new User();
        String practitioner = sample.getUsername(); 
        Client client = new Client(sample, practitioner);
        ArrayList<Goal> expResult = new ArrayList<>();
        ArrayList<Goal> result = broke.getGoals(client);
        assertEquals(expResult, result);
    }
}
