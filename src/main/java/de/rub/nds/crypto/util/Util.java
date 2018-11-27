package de.rub.nds.crypto.util;

/**
 * A collection of Util functions which appear helpful for tls development
 *
 */
public class Util {

    /**
     * Concatenates an array of byte[] to one big byte[]
     *
     * @param arrays the array of byte[] to concatenate
     * @return an array of byte[] as one big byte[]
     */
    public static byte[] concatenate(byte[]... arrays) {
        if (arrays == null || arrays.length == 0) {
            throw new IllegalArgumentException("The minimal number of parameters for this function is one");
        }
        int length = 0;
        for (final byte[] a : arrays) {
            if (a != null) {
                length += a.length;
            }
        }
        byte[] result = new byte[length];
        int currentOffset = 0;
        for (final byte[] a : arrays) {
            if (a != null) {
                System.arraycopy(a, 0, result, currentOffset, a.length);
                currentOffset += a.length;
            }
        }
        return result;
    }

    /**
     * Converts a byte[] into an integer
     *
     * @param value the byte[] to convert
     * @return the converted value
     */
    public static int convertToInt(byte[] value) {
        int result = 0;
        int shift = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            result += (value[i] & 0xFF) << shift;
            shift += 8;
        }
        return result;
    }

    /**
     * Converts an integer into its byte[size] representation
     *
     * @param value value to convert
     * @param size size of the target byte[]
     * @return the integer converte to a byte[size]
     */
    public static byte[] convertIntToBytes(int value, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("The array must be at least of size 1");
        }
        byte[] result = new byte[size];
        int shift = 0;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = (byte) (value >>> shift);
            shift += 8;
        }
        return result;
    }

    /**
     * Converts a long to an byte[size] representation
     *
     * @param value Value to convert
     * @param size Size of the resulting byte[]
     * @return the byte[size] representation
     */
    public static byte[] longToBytes(long value, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("The array must be at least of size 1");
        }
        byte[] result = new byte[size];
        int shift = 0;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = (byte) (value >>> shift);
            shift += 8;
        }

        return result;
    }

    /**
     * Converts a long as a 64bit unsinged int into a byte[]
     *
     * @param l long to convert
     * @return byte[] representation
     */
    public static byte[] longToUint64Bytes(long l) {
        byte[] result = new byte[8];
        result[0] = (byte) (l >>> 56);
        result[1] = (byte) (l >>> 48);
        result[2] = (byte) (l >>> 40);
        result[3] = (byte) (l >>> 32);
        result[4] = (byte) (l >>> 24);
        result[5] = (byte) (l >>> 16);
        result[6] = (byte) (l >>> 8);
        result[7] = (byte) (l);
        return result;
    }

    /**
     * Converts a hexstring into a byte[]
     *
     * @param input the hex string that shold
     * @return the byte[] representation of the hexstring
     */
    public static byte[] hexStringToByteArray(String input) {
        if ((input == null) || (input.length() % 2 != 0)) {
            throw new IllegalArgumentException("The input must not be null and "
                    + "shall have an even number of hexadecimal characters. Found: " + input);
        }
        byte[] output = new byte[input.length() / 2];
        for (int i = 0; i < output.length; i++) {
            output[i] = (byte) ((Character.digit(input.charAt(i * 2), 16) << 4) + Character.digit(
                    input.charAt(i * 2 + 1), 16));
        }
        return output;
    }

    /**
     * Converts a byte[] into a hex string
     *
     * @param array array to convert
     * @return a hex string representation of the byte[]
     */
    public static String bytesToHexString(byte[] array) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            byte b = array[i];
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    private Util() {
    }
}