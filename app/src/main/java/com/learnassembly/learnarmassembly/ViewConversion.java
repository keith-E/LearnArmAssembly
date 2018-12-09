package com.learnassembly.learnarmassembly;

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
}
