/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.sql.ResultSet;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author wickr
 */
public class PurchaseRequisitionControllerTest {
    
    public PurchaseRequisitionControllerTest() {
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
     * Test of getItemPrice method, of class PurchaseRequisitionController.
     */
    @Test
    public void testGetItemPrice() {
        System.out.println("getItemPrice");
        int itemId = 1;
        PurchaseRequisitionController instance = new PurchaseRequisitionController();
        double expResult = 10;
        double result = instance.getItemPrice(itemId);
        assertEquals(expResult, result, 0.0);
        
    }


    @Ignore
    public void testUpdateRequisitionItemPrice() {
        System.out.println("UpdateRequisitionItemPrice");
        HashMap<Integer, Double> hs = null;
        int reqNo = 0;
        PurchaseRequisitionController instance = new PurchaseRequisitionController();
        boolean expResult = false;
        boolean result = instance.UpdateRequisitionItemPrice(hs, reqNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
       
}
