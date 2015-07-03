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
public class VijandTest {
    
    public VijandTest() {
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
     * Test of toString method, of class Vijand.
     */
   

    /**
     * Test of teken method, of class Vijand.
     */
    @Test
    public void testverHoogstappen() {
        
        Vijand instance = new Vijand(2,2);
        //instance.verhoogStappen();
        int expResult = 10;
         int result = Doolhof.getStappen();
         assertEquals(expResult, result);

    }
    
}
