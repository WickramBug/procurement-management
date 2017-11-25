/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.Public;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wickr
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserExists method, of class LoginController.
     */
    @Test
    public void testCheckUserExists() {
        System.out.println("checkUserExists");
        String user = "Ashif";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUserExists(user);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getUserRole method, of class LoginController.
     */
    @Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        String user = "Ashif";
        LoginController instance = new LoginController();
        String expResult = "SiteManager";
        String result = instance.getUserRole(user);
        assertEquals(expResult, result);
        
    }
    
}
