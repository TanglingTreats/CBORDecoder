package com.tanglingtreats;

import com.tanglingtreats.templates.Template;

public class Decoder {

    /**
     * Get major type of a byte value
     * @param value
     * @return
     */
    private static int getMajorType(byte value) {
        return value >> 5 & 0b111;
    }


    /**
     * Decodes a CBOR-formatted string into JSON-style string
     * @param input
     * @return
     */
    public static String decode(String input) {

        if (input.length() % 2 != 0) {
            return Template.ERR_INVALID_INPUT;
        }

        byte[] ba = Util.hexStringToByteArray(input);

        StringBuilder sb = new StringBuilder();

        int majorType = getMajorType(ba[0]);
        if (majorType == -1) {
            return Template.ERR_INVALID_INPUT;
        }

        sb.append(getMajorType(ba[0]));

        return sb.toString();
    }
}
