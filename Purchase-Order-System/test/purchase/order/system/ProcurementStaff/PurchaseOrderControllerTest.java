/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.ProcurementStaff;

import java.sql.ResultSet;
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
public class PurchaseOrderControllerTest {
    
    public PurchaseOrderControllerTest() {
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
     * Test of getRequisitionNo method, of class PurchaseOrderController.
     */
    @Test
    public void testGetRequisitionNo() {
        System.out.println("getRequisitionNo");
        int purchaseReference = 0;
        PurchaseOrderController instance = new PurchaseOrderController();
        int expResult = 0;
        int result = instance.getRequisitionNo(purchaseReference);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

       
    /**
     * Test of getRequisitionerUser method, of class PurchaseOrderController.
     */
    @Ignore
    public void testGetRequisitionerUser() {
        System.out.println("getRequisitionerUser");
        int requisitionNo = 0;
        PurchaseOrderController instance = new PurchaseOrderController();
        String expResult = "Ashif";
        String result = instance.getRequisitionerUser(requisitionNo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRequisitionerAddress method, of class PurchaseOrderController.
     */
    @Test
    public void testGetRequisitionerAddress() {
        System.out.println("getRequisitionerAddress");
        String requisitioner = "Ashif";
        PurchaseOrderController instance = new PurchaseOrderController();
        String expResult = "48 kandy road palle";
        String result = instance.getRequisitionerAddress(requisitioner);
        assertEquals(expResult, result);
        
    }

    
    
}
