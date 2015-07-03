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
        spel.start(1);
        
        Speler instance = new Speler(1,1);
        
        instance.move("left");
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
        
        
        instance.move("down");
        expResult = 2;
        result = instance.getY();
        assertEquals(expResult, result);
        
        
        instance.move("right");
        expResult = 1;
        result = instance.getX();
        assertEquals(expResult, result);
        
        
        instance.move("up");
        expResult = 1;
        result = instance.getY();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSchiet12() throws Exception //1-2, geen ammo
    {
        Spel spel = new Spel();
        spel.start(1);
        
        Speler instance = new Speler(1,1);
        instance.ammo = 0;
        instance.setLastDirection("east");
        instance.schiet();
        int expResult = 1;
        int result;
        if(Spel.doolhof.grid[1][2] instanceof Binnenmuur)
        {
            result = 1;
        }
        else
        {
            result = 0;
        }
        assertEquals(expResult, result);      
    }
    
    @Test
    public void testSchiet1348() throws Exception
    {
        Spel spel = new Spel();
        spel.start(1);
        
        Speler instance = new Speler(1,1);
        instance.ammo = 1;
        instance.setLastDirection("east");
        instance.schiet();       
        int expResult = 0;
        int result;
        if(Spel.doolhof.grid[1][2] instanceof Binnenmuur)
        {
            result = 1;
        }
        else
        {
            result = 0;
        }
        assertEquals(expResult, result); 
    }
    
    
    @Test
    public void testSchiet135657() throws Exception
    {
        Spel spel = new Spel();
        spel.start(1);
        
        Speler instance = new Speler(1,13);
        instance.ammo = 1;
        instance.setLastDirection("east");
        instance.schiet();       
        int expResult = 0;
        int result;
        if(Spel.doolhof.grid[14][13] instanceof Binnenmuur)
        {
            result = 1;
        }
        else
        {
            result = 0;
        }
        assertEquals(expResult, result); 
    }
    
    
    @Test
    public void testSchiet135648() throws Exception
    {
        Spel spel = new Spel();
        spel.start(1);
        
        Speler instance = new Speler(1,9);
        instance.ammo = 1;
        instance.setLastDirection("east");
        instance.schiet();       
        int expResult = 0;
        int result;
        if(Spel.doolhof.grid[9][6] instanceof Binnenmuur)
        {
            result = 1;
        }
        else
        {
            result = 0;
        }
        assertEquals(expResult, result); 
    }
    //test
    
}
