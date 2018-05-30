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
    public int minutes = 5;
    public int steps = 10;
    
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
     * 
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        
        Client user = new Client("King", "queen", "George", "England", "Ryan");
        broke.removeUser(user);      
        boolean result = broke.addClient(user);
        boolean expResult = true;
        
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
        Practitioner user = new Practitioner("Prac06", "Jerry", "Lion", "Scary");
        broke.addPractitioner(user);
        User expResult = user;
        User result = broke.getUser(user.getUsername());
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
    //@Test
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
        int expResult = 11;
        int result = broke.getDBVersionNum();
        assertEquals(expResult, result);

    }

    /**
     * Test of addPractitioner method, of class Broker.
     * //will only work once if the parameters for the practitioner is changed. 
     * Expected to fail if run for a second time or more, since there is no method
     * implemented to remove a practitioner account. 
     */
    @Test
    public void testAddPractitioner() {
        System.out.println("addPractitioner");
        Practitioner user = new Practitioner("Prac06", "Jerry", "Lion", "Scary"); 
        boolean result = broke.addPractitioner(user);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class Broker.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        User sample = new User("Royal", "fqac", "Elizabeth", "Mary");
        String practitioner = sample.getUsername();
        Client user = new Client(sample, practitioner);
        broke.removeUser(user);
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
        User sample = new User("Use", "pear", "Hamilton", "Pope");
        Client client = new Client(sample, "practitioner01");
        broke.addClient(client);
        boolean expResult = true;
        boolean result = broke.addExercise(exercise, client);
        broke.removeUser(client);
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
        User sample = new User("Royal", "fqac", "Elizabeth", "Mary");
        String practitioner = sample.getUsername(); 
        Client client = new Client(sample, practitioner);
        ArrayList<Goal> expResult = new ArrayList<>();
        ArrayList<Goal> result = broke.getGoals(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of setUpSchema method, of class Broker.
     */
    @Test
    public void testSetUpSchema() {
        System.out.println("setUpSchema");
        broke.setUpSchema();
    }

    /**
     * Test of addExercise method, of class Broker.
     * The only way for this test to pass is to change the exercise every
     * time the test is run.
     */
    @Test
    public void testAddExercise() {
        System.out.println("addExercise");
        AerobicExercise exercise = new AerobicExercise("Walking");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary"); 
        Client sample = new Client(user, "Practitioner01");  
        broke.addClient(sample);
        boolean expResult = true;
        boolean result = broke.addExercise(exercise, sample);
        broke.removeUser(sample);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getWeightExercise method, of class Broker.
     */
    @Test
    public void testGetWeightExercise() {
        System.out.println("getWeightExercise");
        String exerciseName = "Walk";
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01"); 
        broke.addClient(sample);
        WeightExercise expResult = new WeightExercise(exerciseName);
        WeightExercise result = broke.getWeightExercise(exerciseName, sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllWeightExercisesOfClient method, of class Broker.
     */
    @Test
    public void testGetAllWeightExercisesOfClient() {
        System.out.println("getAllWeightExercisesOfClient");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01");  
        ArrayList<WeightExercise> expResult = new ArrayList<>();
        ArrayList<WeightExercise> result = broke.getAllWeightExercisesOfClient(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllExercisesOfClient method, of class Broker.
     */
    @Test
    public void testGetAllExercisesOfClient() {
        System.out.println("getAllExercisesOfClient");
        User user = new User();
        Client sample = new Client(user, "Practitioner01");  
        ArrayList<Exercise> expResult = new ArrayList<>();
        ArrayList<Exercise> result = broke.getAllExercisesOfClient(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAerobicExerciseEntry method, of class Broker.
     */
    @Test
    public void testAddAerobicExerciseEntry() {
        System.out.println("addAerobicExerciseEntry");
        LocalDateTime today = LocalDateTime.now();
        int minute = 5;
        AerobicExercise exercise = new AerobicExercise("Rowing");
        AerobicExerciseEntry exerciseEntry = new AerobicExerciseEntry(today, minute);
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01");
        broke.addClient(sample);
        boolean expResult = true;
        boolean result = broke.addAerobicExerciseEntry(exercise, exerciseEntry, sample);
        broke.removeUser(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of addWeightExerciseEntry method, of class Broker.
     */
    @Test
    public void testAddWeightExerciseEntry() {
        System.out.println("addWeightExerciseEntry");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "practitioner01");
        broke.removeUser(sample);
        WeightExercise exercise = new WeightExercise("Chest Press");
        LocalDateTime today = LocalDateTime.now();
        Set setA = new Set(1, 5); 
        Set setB = new Set(3, 9);
        WeightExerciseEntry exerciseEntry = new WeightExerciseEntry(today, setA, setB);
        
        broke.addClient(sample);
        boolean expResult = true;
        boolean result = broke.addWeightExerciseEntry(exercise, exerciseEntry, sample);
    
        assertEquals(expResult, result);
    }

    /**
     * Test of addPedometerEntry method, of class Broker.
     */
//    @Test
//    public void testAddPedometerEntry() {
//        System.out.println("addPedometerEntry");
//        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
//        Client sample = new Client(user, "Practitioner01");  
//        Pedometer.Entry entry = new Pedometer.Entry(date, steps);
//        boolean expResult = true;
//        boolean result = broke.addPedometerEntry(sample, entry);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getPedometer method, of class Broker.
     */
//    @Test
    public void testGetPedometer() {
        System.out.println("getPedometer");
        User user = new User("Royal", "fqac", "Elizabeth", "Mary");
        Client sample = new Client(user, "Practitioner01");  
        Pedometer expResult = new Pedometer();
        Pedometer result = broke.getPedometer(sample);
        assertEquals(expResult, result);
    }
}
