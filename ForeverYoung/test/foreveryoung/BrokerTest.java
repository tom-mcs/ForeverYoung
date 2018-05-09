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
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Ryan");      
        boolean result = broke.addClient(sample);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Broker.
     */
    
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        User samp = new User();
        String username = samp.getUsername();
        String expResult = username;
        User result = broke.getUser(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClients method, of class Broker.
     */
    
    @Test
    public void testGetClients() throws SQLException {
        System.out.println("getClients");
        User user = new User();
        user.getUsername(); 
        ArrayList<User> expResult = new ArrayList<>();
        expResult.add(user);
    //    ArrayList<Practitioner> result = broke.getClients(user);
    //    assertEquals(expResult, result); 
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
        boolean expResult = false;
        boolean result = broke.addAerobicExercise(exercise, client);
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
        ArrayList<AerobicExercise> expResult = null;
        ArrayList<AerobicExercise> result = broke.getAllAerobicExercisesOfClient(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of addExerciseEntry method, of class Broker.
     */
    @Test
    public void testAddExerciseEntry() {
        System.out.println("addExerciseEntry");
        AerobicExercise exercise = new AerobicExercise("");
        AerobicExercise.Entry entry = null;
        User sample = new User();
        String practitioner = sample.getUsername();
        Client client = new Client(sample, practitioner);
        boolean expResult = false;
        boolean result = broke.addExerciseEntry(exercise, entry, client);
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
        ArrayList<Goal> expResult = null;
        ArrayList<Goal> result = broke.getGoals(client);
        assertEquals(expResult, result);
    }
}
