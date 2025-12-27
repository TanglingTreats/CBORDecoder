package com.tanglingtreats;

public class Util {
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // Convert each 2-character hex substring to an integer, then cast to a byte
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static boolean isHexadecimal(String input) throws NumberFormatException {
        try {
            Long.parseLong(input, 16);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Constants.ERR_INVALID_FORMAT);
        }
    }
}
