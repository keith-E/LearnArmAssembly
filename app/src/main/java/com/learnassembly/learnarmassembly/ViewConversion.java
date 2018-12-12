package com.learnassembly.learnarmassembly;

import java.util.ArrayList;

public class ViewConversion {
    public static String binaryToString(int[] binary) {
        String binaryString = "";
        int count = 1;

        for (int i = 0; i < binary.length; i++) {
            if (count % 4 == 0) {
                binaryString += binary[i] + " ";
                count = 1;
            }
            else {
                binaryString += binary[i];
                count++;
            }
        }

        return binaryString;
    }

    public static String memoryAddressHexString(ArrayList<Integer> memoryAddress) {
        String binaryString = getBinaryFromIntList(memoryAddress);
        int decimalValue = Integer.parseInt(binaryString, 2);
        return Integer.toHexString(decimalValue);
    }

    private static String getBinaryFromIntList(ArrayList<Integer> binaryMemoryAddress) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for(int bit : binaryMemoryAddress) {
            binaryStringBuilder.append(bit);
        }
        return binaryStringBuilder.toString();
    }
}
