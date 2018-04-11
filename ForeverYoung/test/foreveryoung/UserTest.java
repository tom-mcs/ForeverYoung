/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class UserTest {
 
    public UserTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        User instance = new User();
        instance.login();
    }

    /**
     * Test of logout method, of class User.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        User instance = new User();
        instance.logout();

    }

    /**
     * Test of isLoggedIn method, of class User.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParent method, of class User.
     * The following variables should be expected to be null, as the attributes
     * should be empty when the program is not being executed. Once the program 
     * is run, then the program should be setting them then. Hence it makes sense 
     * for the expected results to be null.
     * @author Ryan
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        User user = new User();
        String expResult = null;
        String result = user.getParent();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPractitioner method, of class User.
     */
    @Test
    public void testIsPractitioner() {
        System.out.println("isPractitioner");
        User instance = new User();
        boolean expResult = true;
        boolean result = instance.isPractitioner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User user = new User();
        String expResult = null;
        String result = user.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = null;
        User instance = new User();
        instance.setUserName(userName);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = null;
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User user = new User();
        String expResult = null;
        String result = user.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        User instance = new User();
        instance.setPassword(password);

    }
    
}
