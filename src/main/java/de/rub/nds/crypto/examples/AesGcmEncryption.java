package de.rub.nds.crypto.examples;

import de.rub.nds.crypto.util.Util;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesGcmEncryption {
    
    static byte[] keyBytes = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
    static String data = "abcdef";
    static byte[] ivBytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    static byte[] aad = {0, 1, 2, 3};
    
    public static void main(String[] args) throws Exception {
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        // We use 16 bytes (128 bit) long tag and 12 bytes of an explicit IV,
        // and four bytes of AAD (Additional Authenticated Data)
        // Please note that reusing IVs is dangerous!!! 
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(128, ivBytes));
        byte[] iv = cipher.getIV();
        cipher.updateAAD(aad);
        byte[] ciphertext = cipher.doFinal(data.getBytes());
        System.out.println("IV:            " + Util.bytesToHexString(iv));
        System.out.println("Cipher + GMAC: " + Util.bytesToHexString(ciphertext));
        
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, ivBytes));
        byte[] plaintext = cipher.doFinal(ciphertext);
        System.out.println("Plain:         " + new String (plaintext));
        System.out.println("Plain in hex   " + Util.bytesToHexString(plaintext));
    }
}
