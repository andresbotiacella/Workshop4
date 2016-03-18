/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Andy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestController.SizeControllerTest.class})
public class ControllerSuite {

    /**
     *Set Up Class Method
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     *Tear Down Class Method
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *Set Up Method
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     *Tear Down Method
     */
    @After
    public void tearDown() throws Exception {
    }
    
}
