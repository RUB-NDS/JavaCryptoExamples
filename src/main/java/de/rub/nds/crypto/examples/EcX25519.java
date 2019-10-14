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
        
        // create a array for the public key
        byte[] publicKey = new byte[32];
        
        //init the X25519 class
        X25519.precompute();
        
        //multipy the privateKey with the base of the X22519 curve and save the result the publicKey
        X25519.scalarMultBase(privateKey, 0, publicKey, 0);
        System.out.println("Public key:           " + Util.bytesToHexString(publicKey)); 
    }
}
