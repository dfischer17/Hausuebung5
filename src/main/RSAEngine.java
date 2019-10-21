/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfischer17
 */
public class RSAEngine {
    private int p;
    private int q;
    private BigInteger N;
    private BigInteger e;
    private BigInteger d;

    public RSAEngine(int p, int q) {
        this.p = p;
        this.q = q;
        this.N = BigInteger.valueOf(p * q);
        
        // e
        BigInteger amountOfStrangeNdividers = BigInteger.valueOf((p - 1) * (q - 1));
        for (int i = 2; i < amountOfStrangeNdividers.intValue(); i++) {
            if (isPrime(i) && i < amountOfStrangeNdividers.intValue()) {
                this.e = BigInteger.valueOf(i);
                break;
            }
        }
        
        // d
        this.d = this.e.modInverse(amountOfStrangeNdividers);
    }
    
    public static void main(String[] args) {
        RSAEngine rsa = new RSAEngine(11, 13);
        System.out.println("p " + rsa.getP());
        System.out.println("q " + rsa.getQ());
        System.out.println("N " + rsa.getN());
        System.out.println("e " + rsa.getE());
        System.out.println("d " + rsa.getD());
        
        System.out.println(rsa.encryptNumber(7));
    }
    
    public BigInteger encryptNumber(int plain) {
        BigInteger b = new BigInteger(String.valueOf(plain));
        BigInteger temp = new BigInteger(String.valueOf(b.pow(e.intValue()).mod(N)));
        return temp;
    }
    
    public int decryptNumber(BigInteger encrypted) {
        return 0;
        
    }
    
    public BigInteger encryptChar(char plain) {
        return null;
        
    }
    
    public BigInteger decryptChar(char plain) {
        return null;
        
    }
    
    public BigInteger[] encryptString(String plain) {
        return null;
    }
    
    public String decryptString(BigInteger[] encrypted) {
        return null;
        
    }
    
    private static void createPublicKey() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            
            KeyPair kp = kpg.generateKeyPair();
            
            // Schluessel ausgeben
            System.out.println("public key: " + kp.getPublic().getEncoded());
            System.out.println("private key: " + kp.getPrivate());
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RSAEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BigInteger getN() {
        return N;
    }
    
    private boolean isPrime(int p) {
        if (p < 2) {
            return false;
        } else {
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public double getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    } 
}
