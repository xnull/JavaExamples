package bynull.bitoperations;

import java.nio.ByteBuffer;

/**
 * Created by null on 4/19/14.
 */
public class PartOfValue {

    public static void main(String[] args) {
        //test();
        //bitShifting();
        //byteBufferOperation();
        //mask();
        maskSergey();
        }

    private static void maskSergey(){
        long a = 124756;
        int offset = 3;
        int count = 4;

        System.out.println("Value bits: " + Long.toBinaryString(a));
        System.out.println("Offset bits: " + Integer.toBinaryString(offset));
        System.out.println("Count bits: " + Integer.toBinaryString(count));

        long mask = 0;
        //заполнение маски единицами count число раз
        for(int i=0; i<count; ++i) {
            mask |= 1 << i;
        }
        //сдвиг на offset
        mask = mask << offset;
        long result = a & mask;

        System.out.println("Mask: " + Long.toBinaryString(mask));
        System.out.println("result: " + Long.toHexString(result));
    }

    private static void mask() {
        long value = 100;
        int offset = 2;
        int length = 2;

        String mask = "";
        for (int i = 0; i < Long.bitCount(value); i++) {
            if (i < offset) {
                mask += "0";
                continue;
            }

            if (i < offset + length) {
                mask += "1";
            }else{
                mask +="0";
            }
        }
        System.out.println(mask);

        long result = value & Long.valueOf(mask, 2);
        System.out.println(result);
    }

    private static void byteBufferOperation() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE / 8);
        buffer.putLong(900000);


        int offset = 1;
        int count = 2;

        String bitResultStr = "";

        int size = Integer.SIZE - Byte.SIZE;
        for (byte octet : buffer.array()) {
            String resultStr = Integer.toBinaryString(octet);
            if (resultStr.length() >= size) {
                String result = resultStr.substring(size);
                System.out.print(result + " ");
                bitResultStr += result;
            }
        }

        System.out.println();
        System.out.println("RESULT bit: " + bitResultStr);
        System.out.println("Long result: " + Long.valueOf(bitResultStr, 2));
    }

    private static void test() {
        long value = 5;
        int offset = 1;
        int count = 2;

        System.out.println("5=" + Long.toBinaryString(value));
        value = value >> offset;

        System.out.println(value + "=" + Long.toBinaryString(value));
    }

    private static void bitShifting() {
        int value = 5;
        int shift = 4;

        System.out.println("value: " + Long.toBinaryString(value));
        System.out.println("shift value: " + Long.toBinaryString(shift));
        System.out.println("shift: " + Long.toBinaryString(value << shift));
    }
}
