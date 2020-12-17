package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc7748.X25519;


public class EcX25519 {
    
    public static void main(String[] args) {
        //Create a secure random and fill 32 Bytes with random for a private Key
        SecureRandom secureRandom = new SecureRandom();
        byte[] privateKey = new byte[32];
        secureRandom.nextBytes(privateKey);
        System.out.println("Private key:          " + Util.bytesToHexString(privateKey));
        
        // create an array for the public key
        byte[] publicKey = new byte[32];
        
        //init the X25519 class
        X25519.precompute();
        
        //multipy the private key with the base of the X22519 curve and save the result in the public key
        X25519.scalarMultBase(privateKey, 0, publicKey, 0);
        System.out.println("Public key:           " + Util.bytesToHexString(publicKey));
        
        
        
        //multipy two factors as points on the X22519 curve and save the result in the product
        byte[] factor1 = Util.hexStringToByteArray("00112233445566778899AABBCCDDEEFF00112233445566778899AABBCCDDEEFF");
        byte[] factor2 = Util.hexStringToByteArray("0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF");
        byte[] product = new byte[32];
        X25519.scalarMult(factor1, 0, factor2, 0, product, 0);
        System.out.println("product:           " + Util.bytesToHexString(product));
    }
}
