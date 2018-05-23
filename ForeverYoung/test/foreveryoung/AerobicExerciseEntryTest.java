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
public class AerobicExerciseEntryTest {
    
    public AerobicExerciseEntryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    
    public LocalDateTime date;
    public int minutes;
    /**
     * Test of toString method, of class AerobicExerciseEntry.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AerobicExerciseEntry instance = new AerobicExerciseEntry(date, minutes);
        String expResult = "Entry{" + "date=" + date + ", minutes=" + minutes + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
