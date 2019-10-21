/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author dfischer17
 */
public class RSAEngine {

    // zwei unterschiedliche Primzahlen
    private BigInteger pn1;
    private BigInteger pn2;

    // Modul (p * q)
    private BigInteger N;

    // Exponent fuer oeffentlichen Schluessel (kann frei gewählt werden)
    private BigInteger e;

    // Eulersche φ-Funktion von n
    private BigInteger φ;

    // verwendet für privaten Schluessel
    private BigInteger d;

    public RSAEngine(int p, int q) {
        this.pn1 = BigInteger.valueOf(p);
        this.pn2 = BigInteger.valueOf(q);
        this.N = pn1.multiply(pn2);
        this.e = BigInteger.valueOf(23);
        this.φ = (pn1.subtract(BigInteger.ONE)).multiply(pn2.subtract(BigInteger.ONE));

        // Ueberpruefung ob der ggt von φ und e == 1 ist
        if (!φ.gcd(this.e).equals(BigInteger.ONE)) {
            System.err.println("Wert der φ-Funktion ist nicht teilerfremd zu e!");
        }

        this.d = e.modInverse(φ);
    }

    public static void main(String[] args) {
        RSAEngine rsa = new RSAEngine(11, 13);
        
        // encrypt/decrypt number test
        BigInteger encrypted = rsa.encryptNumber(100);        
        int decrypted = rsa.decryptNumber(encrypted);
    }

    public BigInteger encryptNumber(int plain) {
        BigInteger temp = new BigInteger(String.valueOf(plain));
        return temp.pow(e.intValue()).mod(N);
    }

    public int decryptNumber(BigInteger encrypted) {
        return encrypted.pow(d.intValue()).mod(N).intValue();
    }

    public BigInteger encryptChar(char plain) {
        BigInteger temp = BigInteger.valueOf(plain);
        return temp.pow(e.intValue()).mod(N);
    }

    public char decryptChar(BigInteger encrypted) {
        return (char) encrypted.pow(d.intValue()).mod(N).intValue();
    }

    public BigInteger[] encryptString(String plain) {
        String[] temp = plain.split("");
        BigInteger[] encrypted = new BigInteger[temp.length];
        
        for (int i = 0; i < encrypted.length; i++) {
            encrypted[i] = BigInteger.valueOf(Long.valueOf(temp[i])).pow(e.intValue()).mod(N);        
        }
        
        return encrypted;
    }

    public String decryptString(BigInteger[] encrypted) {
        Stream<BigInteger> myStream = Arrays.stream(encrypted);
        
        myStream.map(n -> {
            return n.pow(d.intValue()).mod(N);
        });
        
        BigInteger[] decrypted = (BigInteger[]) myStream.toArray();
        String[] plain = new String[encrypted.length];
        
        for (int i = 0; i < encrypted.length; i++) {
            plain[i] = encrypted[i].toString();            
        }
                
        return Arrays.toString(plain);
    }

    public BigInteger getN() {
        return N;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
}
