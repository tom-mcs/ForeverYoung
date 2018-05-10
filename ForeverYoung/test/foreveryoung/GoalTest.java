/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class GoalTest {
    
    public GoalTest() {
    }
    
    
    Broker broke;
    
    @Before
    public void setUp() throws SQLException {
        broke = new Broker();
    }

    /**
     * Test of getName method, of class Goal.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Goal goal = new Goal("sell burgers", "sell 2 burgers");
        String expResult = goal.getName();
        String result = goal.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setGoal method, of class Goal.
     */
    @Test
    public void testSetGoal() {
        System.out.println("setGoal");
        String task = "sell burgers";
        Goal goal = new Goal(task,"sell 2 burgers");
        goal.setGoal(task);
    }

    /**
     * Test of getDescription method, of class Goal.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Goal goal = new Goal("sell burgers","sell 2 burgers");
        String expResult = goal.getDescription();
        String result = goal.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Goal.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "sell 2 burgers";
        Goal goal = new Goal("sell burgers","sell 2 burgers");
        goal.setDescription(description);
    }

    /**
     * Test of isCompleted method, of class Goal.
     */
    @Test
    public void testIsCompleted() {
        System.out.println("isCompleted");
        Goal goal = new Goal("sell burgers","sell 2 burgers");
        boolean expResult = true;
        boolean result = goal.isCompleted();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompleted method, of class Goal.
     */
    @Test
    public void testSetCompleted() {
        System.out.println("setCompleted");
        boolean completed = true;
        Goal goal = new Goal("sell burgers","sell 2 burgers");
        goal.setCompleted(completed);
    }

    /**
     * Test of toString method, of class Goal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Goal goal = new Goal("sell burgers","sell 2 burgers");
        String expResult = goal.getName();
        String result = goal.toString();
        assertEquals(expResult, result);
    }
    
}
