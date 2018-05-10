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
public class PedometerTest {
    
    public PedometerTest() {
    }
    
    Broker broke;
    
    @Before
    public void setUp() throws SQLException{
        broke = new Broker();
    }

    /**
     * Test of addEntry method, of class Pedometer.
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        int steps = 10;
        Pedometer instance = new Pedometer("entry01");
        boolean expResult = true;
        boolean result = instance.addEntry(steps);
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveEntry method, of class Pedometer.
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("RemoveEntry");
        int i = 1;
        Pedometer instance = new Pedometer("entry01");
        boolean expResult = false;
        boolean result = instance.RemoveEntry(i);
        assertEquals(expResult, result);
    }
    
}
