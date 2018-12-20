package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import java.security.MessageDigest;

public class Digest {
    
    static String data = "abcdef";
    
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // you can invoke the update function several times with different data
        md.update(data.getBytes());
        md.update(data.getBytes());
        // then you finalize and compute the resulting hash
        byte[] result = md.digest(data.getBytes());
        System.out.println("Hash / Digest: " + Util.bytesToHexString(result));
    }
}
