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
    public void testMove() throws Exception {
        Spel spel = new Spel();
        spel.start(0);
        System.out.println("move");
        
        Speler instance = new Speler(2,2);
        
        instance.move("left");
         int expResult = 1;
         int result = instance.getX();
         assertEquals(expResult, result);
        
    }

    /**
     * Test of checkCurrent method, of class Speler.
     */
    



    
}
