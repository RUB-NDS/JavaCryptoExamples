package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {
    
    static byte[] keyBytes = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
    static String data = "abcdef";
    static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    
    public static void main(String[] args) throws Exception {
        SecretKey key = new SecretKeySpec(keyBytes, HMAC_SHA256_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(key);
        byte[] result = mac.doFinal(data.getBytes());
        System.out.println("MAC: " + Util.bytesToHexString(result));
        
        // to verify a provided MAC value, compute MAC and compare the result
        // with the provided value
    }
}
