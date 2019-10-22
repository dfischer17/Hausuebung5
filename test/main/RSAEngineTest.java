/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Fischer
 */
public class RSAEngineTest {
    
    public RSAEngineTest() {
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
     * Test of encryptNumber method, of class RSAEngine.
     */
    @Test
    public void testEncryptNumber() {
        System.out.println("encryptNumber");
        int plain = 1256;
        RSAEngine instance = new RSAEngine(641, 643);
        BigInteger expResult = BigInteger.valueOf(131383);
        BigInteger result = instance.encryptNumber(plain);
        assertEquals(expResult, result);
    }

    /**
     * Test of decryptNumber method, of class RSAEngine.
     */
    @Test
    public void testDecryptNumber() {
        System.out.println("decryptNumber");
        BigInteger encrypted = BigInteger.valueOf(131383);
        RSAEngine instance = new RSAEngine(641, 643);
        int expResult = 1256;
        int result = instance.decryptNumber(encrypted);
        assertEquals(expResult, result);
    }

    /**
     * Test of encryptChar method, of class RSAEngine.
     */
    @Test
    public void testEncryptChar() {
        System.out.println("encryptChar");
        char plain = 'c';
        RSAEngine instance = new RSAEngine(plain, plain);
        BigInteger expResult = null;
        BigInteger result = instance.encryptChar(plain);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decryptChar method, of class RSAEngine.
     */
    @Test
    public void testDecryptChar() {
        System.out.println("decryptChar");
        BigInteger encrypted = null;
        RSAEngine instance = null;
        char expResult = ' ';
        char result = instance.decryptChar(encrypted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encryptString method, of class RSAEngine.
     */
    @Test
    public void testEncryptString() {
        System.out.println("encryptString");
        String plain = "";
        RSAEngine instance = null;
        BigInteger[] expResult = null;
        BigInteger[] result = instance.encryptString(plain);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decryptString method, of class RSAEngine.
     */
    @Test
    public void testDecryptString() {
        System.out.println("decryptString");
        BigInteger[] encrypted = null;
        RSAEngine instance = null;
        String expResult = "";
        String result = instance.decryptString(encrypted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
