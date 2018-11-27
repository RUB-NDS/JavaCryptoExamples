package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import java.security.MessageDigest;

public class Digest {
    
    static String data = "abcdef";
    
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] result = md.digest(data.getBytes());
        System.out.println("Hash / Digest: " + Util.bytesToHexString(result));
    }
}
