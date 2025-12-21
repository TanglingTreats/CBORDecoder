package com.tanglingtreats;

import com.tanglingtreats.templates.Template;

import java.io.ByteArrayInputStream;

public class Decoder {

    /**
     * Get major type of byte value
     * @param value
     * @return
     */
    private static int getMajorType(int value) {
        return (value >> 5) & 0b111;
    }

    private static short getAD(int value) {
        return (short)(value & 0x1F);
    }

    /**
     * Get additional data
     * @param value
     * @return
     */
    private static short getADType(int value) {
        short ad = getAD(value);
        if (ad < 0x18) {
            return 0;
        } else if (ad == 0x18) {
            return 1;
        } else if (ad == 0x19) {
            return 2;
        } else if (ad == 0x1A) {
            return 4;
        } else if (ad == 0x1B) {
            return 8;
        } else if (ad < 0x1F) {
            return -2;
        }
        // If AD is 31 (0x1F)
        return -1;
    }


    /**
     * Decodes a CBOR-formatted string into JSON-style string
     * @param input
     * @return
     */
    public static String decode(String input, Template template) {

        StringBuilder mainSB = new StringBuilder();

        try {
            StringBuilder itemSB = new StringBuilder();
            if (input.length() % 2 != 0) {
                throw new Exception(Template.ERR_INVALID_INPUT);
            }

            int offset = 0;
            byte[] ba = Util.hexStringToByteArray(input);
            ByteArrayInputStream baStream = new ByteArrayInputStream(ba);


            int b = baStream.read();

            int majorType = getMajorType(b);
            ++offset;

            short adType = getADType(b);
            if (majorType == -1) {
                return Template.ERR_INVALID_INPUT;
            }

            switch(majorType) {
                case 0:
                    itemSB.append(readInt(b, adType, baStream));
                    break;
            }
            offset += adType;

            if (baStream.available() != 0) {
                throw new Exception(Template.ERR_INVALID_INPUT);
            }

            mainSB.append(itemSB);

        } catch (NumberFormatException e) {
            mainSB.append(e.getMessage());
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            mainSB.append(e.getMessage());
            System.out.println(e.getStackTrace());
        }


        return mainSB.toString();
    }

    private static int getBytes(short ad, ByteArrayInputStream baInputStream) {
        switch(ad) {
            case 0:
                return baInputStream.read();
            case 1:
            case 2:
            case 4:
            case 8:
            default:
                return -1;
        }
    }

    private static long readInt(int b, short adType, ByteArrayInputStream baInputStream) {

        if (adType != 0 && baInputStream.available() < adType) {
            throw new NumberFormatException(Template.ERR_INVALID_INPUT);
        }

        if (adType == 0) {
            return getAD(b);
        } else {
            long value = 0;
            for (int i = adType; i > 0; i--) {
                value = (value << 8 ) | (baInputStream.read() & 0xFF);
            }

            return value;
        }
    }
}
