/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dv2;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author max
 */
public class CheaterTest {
    
    public CheaterTest() {
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
     * Test of toString method, of class Cheater.
     */
    
    /**
     * Test of verlaagStappen method, of class Cheater.
     */
    @Test
    public void testVerlaagStappen() {
                Cheater instance = new Cheater(2,2);
        instance.verlaagStappen();
        int expResult = -10;
         int result = Doolhof.getStappen();
         assertEquals(expResult, result);
    }
    
}
