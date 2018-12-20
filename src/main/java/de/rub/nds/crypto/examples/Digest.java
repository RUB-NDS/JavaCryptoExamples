package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import java.security.MessageDigest;

public class Digest {
    
    static String dataPart1 = "abcdef";
    static String dataPart2 = "ghijkl";
    static String dataPart3 = "mn";
    
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // you can invoke the update function several times with different data
        md.update(dataPart1.getBytes());
        md.update(dataPart2.getBytes());
        // then you finalize and compute the resulting hash
        byte[] result = md.digest(dataPart3.getBytes());
        System.out.println("Hash / Digest: " + Util.bytesToHexString(result));
    }
}
