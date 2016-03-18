/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestController;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import workshop4.Controller.*;
import workshop4.Model.*;

/**
 *
 * @author Andy
 */
public class SizeControllerTest {
    
    public SizeControllerTest() {
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
     * Test for loadSizeInfo method, from class SizeController.
     */
    @Test
    public void testLoadSizeInfo() {
        System.out.println("Testing loadSizeInfo Method:");
        String fileName = "List1.txt";
        SizeController testController = new SizeController();
        List<SizeInfo> dataList = testController.loadSizeInfo(fileName);
        assertTrue("Data List must have values.", dataList.size() > 0);
    }
    
    
    /**
     * Test for calculateSizeRange method, from class SizeController.
     */
    @Test
    public void testCalculateSize() {
        System.out.println("Testing calculateSizeRange Method:");
        String fileName = "List2.txt";
        SizeController testController = new SizeController();
        List<SizeInfo> dataList = testController.loadSizeInfo(fileName);
        
        SizeRange sizeResult = testController.calculateSizeRange(dataList);
        assertTrue("Size Range must be defined.", sizeResult != null);
    }
    
}
