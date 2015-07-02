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
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of move method, of class Speler.
     */
    @Test
    public void testWallCheck() throws Exception {
        System.out.println("move");
        int i = 0;
        
        GameObject objectWest = new Binnenmuur(1,2);
        
        if(!(objectWest instanceof Binnenmuur) && !(objectWest instanceof Buitenmuur))
            {     
                i=1;
            }
        
         int expResult = 0;
         int result = i;
         assertEquals(expResult, result);
        
    }

    /**
     * Test of checkCurrent method, of class Speler.
     */
    



    
}
