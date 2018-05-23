/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class WeightExerciseEntryTest {
    
    public WeightExerciseEntryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    public LocalDateTime date;
    public Set set1;
    public Set set2;
    
    /**
     * Test of getSet1 method, of class WeightExerciseEntry.
     */
    @Test
    public void testGetSet1() {
        System.out.println("getSet1");
        WeightExerciseEntry instance = new WeightExerciseEntry(date, set1, set2);
        Set expResult = set1;
        Set result = instance.getSet1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSet2 method, of class WeightExerciseEntry.
     */
    @Test
    public void testGetSet2() {
        System.out.println("getSet2");
        WeightExerciseEntry instance = new WeightExerciseEntry(date, set1, set2);
        Set expResult = set2;
        Set result = instance.getSet2();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class WeightExerciseEntry.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WeightExerciseEntry instance = new WeightExerciseEntry(date, set1, set2);
        String expResult = "Entry{" + "set1=" + set1 + ", set2=" + set2 + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
