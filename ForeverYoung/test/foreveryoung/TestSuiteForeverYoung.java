/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ryan
 * This suite can be used to test all of the test classes at the same time. This allows
 * the tester to validate working code without having spend additional time accessing
 * each individual test class
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({foreveryoung.UserTest.class, foreveryoung.PractitionerTest.class, foreveryoung.AerobicExerciseTest.class, foreveryoung.PedometerTest.class, foreveryoung.BrokerTest.class, foreveryoung.ClientTest.class, foreveryoung.GoalTest.class, foreveryoung.SetTest.class,
                     foreveryoung.AerobicExerciseEntryTest.class, foreveryoung.WeightExerciseEntryTest.class, foreveryoung.WeightExerciseTest.class})
public class TestSuiteForeverYoung {

    @Before
    public void setUp() throws Exception {
    }
    
}
