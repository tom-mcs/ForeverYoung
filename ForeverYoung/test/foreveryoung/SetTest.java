/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class SetTest {
    
    public SetTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of toString method, of class Set.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int set1 = 2; int set2 = 3;
        Set instance = new Set(set1, set2);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
