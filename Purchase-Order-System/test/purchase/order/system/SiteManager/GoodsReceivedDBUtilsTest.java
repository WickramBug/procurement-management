/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neruppuda
 */
public class GoodsReceivedDBUtilsTest {
    
    public GoodsReceivedDBUtilsTest() {
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
     * Test of checkNull method, of class GoodsReceivedDBUtils.
     */
    @Test
    public void testCheckNull() {
        System.out.println("checkNull");
        String value = "Hello";
        GoodsReceivedDBUtils instance = new GoodsReceivedDBUtils();
        boolean expResult = true;
        boolean result = instance.checkNull(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkPostive method, of class GoodsReceivedDBUtils.
     */
    @Test
    public void testCheckPostive() {
        System.out.println("checkPostive");
        double value = 2.0;
        GoodsReceivedDBUtils instance = new GoodsReceivedDBUtils();
        boolean expResult = true;
        boolean result = instance.checkPostive(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    /**
     * Test of getorderedCount method, of class GoodsReceivedDBUtils.
     */
    @Test
    public void testGetorderedCount() {
        int reqId = 1;
        GoodsReceivedDBUtils instance = new GoodsReceivedDBUtils();
        int expResult = 62;
        int result = instance.getorderedCount(reqId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDeliveredCount method, of class GoodsReceivedDBUtils.
     */
    @Test
    public void testGetDeliveredCount() {
        System.out.println("getDeliveredCount");
        int reqId = 1;
        GoodsReceivedDBUtils instance = new GoodsReceivedDBUtils();
        int expResult = 62;
        int result = instance.getDeliveredCount(reqId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getGoodStatus method, of class GoodsReceivedDBUtils.
     */
    @Test
    public void testGetGoodStatus() {
        System.out.println("getGoodStatus");
        int reqId = 1;
        GoodsReceivedDBUtils instance = new GoodsReceivedDBUtils();
        String expResult = "Received";
        String result = instance.getGoodStatus(reqId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
