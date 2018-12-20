package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class EcdsaSignature {
    
    static String data = "abcdef";
    
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        // genearate an EC key pair with 256 bits
        keyGen.initialize(256, random);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();

        // init signature with the private key for signing
        Signature sig = Signature.getInstance("SHA256withECDSA");
        sig.initSign(priv);

        // sign data
        sig.update(data.getBytes());
        byte[] signature = sig.sign();
        System.out.println("Signature:       " + Util.bytesToHexString(signature));
        
        // init signature with the public key for signature verification
        sig = Signature.getInstance("SHA256withECDSA");
        sig.initVerify(pub);
        
        // verify data
        sig.update(data.getBytes());
        System.out.println("Signature valid: " + sig.verify(signature));
    }
}
