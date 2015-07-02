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
public class HelperTest {
    
    public HelperTest() {
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
     * Test of solve method, of class Helper.
     */
    @Test
    public void testSolve() throws Exception {
        System.out.println("solve");
        Helper instance = null;
        instance.solve();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vindRoute method, of class Helper.
     */
    @Test
    public void testVindRoute() {
        System.out.println("vindRoute");
        Helper instance = null;
        instance.vindRoute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maakRoute method, of class Helper.
     */
    @Test
    public void testMaakRoute() {
        System.out.println("maakRoute");
        Helper instance = null;
        instance.maakRoute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOnderdeelRoute method, of class Helper.
     */
    @Test
    public void testCheckOnderdeelRoute() {
        System.out.println("checkOnderdeelRoute");
        int x = 0;
        int y = 0;
        int solverWaardeVriend = 0;
        Helper.checkOnderdeelRoute(x, y, solverWaardeVriend);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bovenKortsteRoute method, of class Helper.
     */
    @Test
    public void testBovenKortsteRoute() {
        System.out.println("bovenKortsteRoute");
        int x = 0;
        int y = 0;
        Helper.bovenKortsteRoute(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechtsKortsteRoute method, of class Helper.
     */
    @Test
    public void testRechtsKortsteRoute() {
        System.out.println("rechtsKortsteRoute");
        int x = 0;
        int y = 0;
        Helper.rechtsKortsteRoute(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onderKortsteRoute method, of class Helper.
     */
    @Test
    public void testOnderKortsteRoute() {
        System.out.println("onderKortsteRoute");
        int x = 0;
        int y = 0;
        Helper.onderKortsteRoute(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of linksKortsteRoute method, of class Helper.
     */
    @Test
    public void testLinksKortsteRoute() {
        System.out.println("linksKortsteRoute");
        int x = 0;
        int y = 0;
        Helper.linksKortsteRoute(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bovenMogelijk method, of class Helper.
     */
    @Test
    public void testBovenMogelijk() {
        System.out.println("bovenMogelijk");
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Helper.bovenMogelijk(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechtsMogelijk method, of class Helper.
     */
    @Test
    public void testRechtsMogelijk() {
        System.out.println("rechtsMogelijk");
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Helper.rechtsMogelijk(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onderMogelijk method, of class Helper.
     */
    @Test
    public void testOnderMogelijk() {
        System.out.println("onderMogelijk");
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Helper.onderMogelijk(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of linksMogelijk method, of class Helper.
     */
    @Test
    public void testLinksMogelijk() {
        System.out.println("linksMogelijk");
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Helper.linksMogelijk(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Helper.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Helper instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Helper.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Helper instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Helper.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Helper instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Helper.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Helper instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Helper.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Helper instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of teken method, of class Helper.
     */
    @Test
    public void testTeken() {
        System.out.println("teken");
        Graphics g = null;
        Helper instance = null;
        instance.teken(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
