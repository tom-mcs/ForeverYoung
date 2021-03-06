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
 * @author Ryan
 * This is the test class for the AerobicExercise class. The class manipulates code
 * to check if the methods from the AerobicExcerise class are performing as they should. 
 */
public class AerobicExerciseTest {
    
    public AerobicExerciseTest() {
    }
    
    Broker broke;
    public LocalDateTime date;
    
    @Before
    public void setUp() throws SQLException {
        broke = new Broker();
    }

    /**
     * Test of getEntries method, of class AerobicExercise.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");
        AerobicExercise instance = new AerobicExercise("Rowing");
        ArrayList<AerobicExerciseEntry> expResult = new ArrayList<>();
        ArrayList<AerobicExerciseEntry> result = instance.getEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfEntries method, of class AerobicExercise.
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("getNumberOfEntries");
        AerobicExercise instance = new AerobicExercise("");
        int expResult = 0;
        int result = instance.getNumberOfEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class AerobicExercise.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        AerobicExercise instance = new AerobicExercise("Rowing");
        String expResult = "Rowing";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntry method, of class AerobicExercise.
     * This test is expected to fail due to the time being unable to 
     * match with exact precision
     */
    @Test
    public void testAddEntry_int() {
        System.out.println("addEntry");
        int minutes = 3;
        AerobicExercise instance = new AerobicExercise("Rowing");
        AerobicExerciseEntry expResult = instance.addEntry(minutes);
        AerobicExerciseEntry result = instance.addEntry(minutes);
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntry method, of class AerobicExercise.
     */
    @Test
    public void testAddEntry_int_LocalDateTime() {
        System.out.println("addEntry");
        int minutes = 0;
        AerobicExercise instance = new AerobicExercise("Rowing");
        boolean expResult = true;
        boolean result = instance.addEntry(minutes, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveEntry method, of class AerobicExercise.
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("RemoveEntry");
        int i = 1;
        AerobicExercise instance = new AerobicExercise("Rowing");
        boolean expResult = false;
        boolean result = instance.RemoveEntry(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class AerobicExercise.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AerobicExercise instance = new AerobicExercise("Rowing");;
        String expResult = "Rowing";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
