/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class WeightExerciseTest {
    
    public WeightExerciseTest() {
    }
    
    @Before
    public void setUp() {
    }
    public LocalDateTime date;

    /**
     * Test of addEntry method, of class WeightExercise.
     */
    @Test
    public void testAddEntry_4args() {
        System.out.println("addEntry");
        int set1Weight = 4;
        int set1Reps = 8;
        int set2Weight = 1;
        int set2Reps = 3;
        WeightExercise instance = new WeightExercise("lift");
        WeightExerciseEntry result = instance.addEntry(set1Weight, set1Reps, set2Weight, set2Reps); 
        WeightExerciseEntry expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntry method, of class WeightExercise.
     */
    @Test
    public void testAddEntry_5args() {
        System.out.println("addEntry");
        int set1Weight = 4;
        int set1Reps = 1;
        int set2Weight = 3;
        int set2Reps = 6;
//        LocalDateTime date = null;
        WeightExercise instance = new WeightExercise("Rowing");
        boolean expResult = true;
        boolean result = instance.addEntry(set1Weight, set1Reps, set2Weight, set2Reps, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntries method, of class WeightExercise.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");
        WeightExercise instance = new WeightExercise("Rowing");
        ArrayList<WeightExerciseEntry> expResult = new ArrayList<>();
        ArrayList<WeightExerciseEntry> result = instance.getEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfEntries method, of class WeightExercise.
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("getNumberOfEntries");
        WeightExercise instance = new WeightExercise("Rowing");
        int set1Weight = 4; int set1Reps = 8; int set2Weight = 1; int set2Reps = 3;
        instance.addEntry(set1Weight, set1Reps, set2Weight, set2Reps, date);
        int expResult = 1;
        int result = instance.getNumberOfEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveEntry method, of class WeightExercise.
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("RemoveEntry");
        int i = 3;
        WeightExercise instance = new WeightExercise("Rowing");
        int set1Weight = 4; int set1Reps = 8; int set2Weight = 1; int set2Reps = 3;
        instance.addEntry(set1Weight, set1Reps, set2Weight, set2Reps, date);
        boolean expResult = false;
        boolean result = instance.RemoveEntry(i);
        assertEquals(expResult, result);
    }
    
}
