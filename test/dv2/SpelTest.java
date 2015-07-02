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
public class SpelTest {
    
    public SpelTest() {
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
     * Test of main method, of class Spel.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Spel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startScherm method, of class Spel.
     */
    @Test
    public void testStartScherm() {
        System.out.println("startScherm");
        Spel.startScherm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Spel.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        int level = 0;
        Spel.start(level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restart method, of class Spel.
     */
    @Test
    public void testRestart() throws Exception {
        System.out.println("restart");
        Spel.restart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keuzeMenu method, of class Spel.
     */
    @Test
    public void testKeuzeMenu() {
        System.out.println("keuzeMenu");
        Spel.keuzeMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highScores method, of class Spel.
     */
    @Test
    public void testHighScores() {
        System.out.println("highScores");
        Spel.highScores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Spel.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Spel instance = new Spel();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoolhof method, of class Spel.
     */
    @Test
    public void testGetDoolhof() {
        System.out.println("getDoolhof");
        Doolhof expResult = null;
        Doolhof result = Spel.getDoolhof();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Spel.
     */
  

    /**
     * Test of startScherm method, of class Spel.
     */


    /**
     * Test of start method, of class Spel.
     */


    
    
}
