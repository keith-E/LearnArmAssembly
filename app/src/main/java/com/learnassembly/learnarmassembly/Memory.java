package com.learnassembly.learnarmassembly;
import java.util.HashMap;

/*
    Represents the available memory.
 */
public class Memory {
    private HashMap<int[], int[]> memory = new HashMap<int[], int[]>();

    /*
        Initializes the memory with the memory
        addresses.
     */
    public Memory() {
        for (int i = 0; i < 128; i+=8) {
            int[] address = createAddress(i);
            int[] zeros = new int[32];  // default to zero if nothing stored
            memory.put(address, zeros);
        }
    }

    /*
        Sets the given memory address to the given value.
     */
    public void setMemory(int[] address, int[] value) {
        if (memory.containsKey(address))
            memory.put(address, value);

        else
            System.err.println("Invalid memory address.");
    }

    /*
        Retrieves the binary number stored in the
        given memory address.
     */
    public int[] getMemory(int[] address) {
        if (memory.get(address) != null)
            return memory.get(address);

        else {
            int[] error = new int[32];
            System.err.print("Invalid memory address.");
            return error;
        }
    }

    /*
        Create 32-bit memory address in binary.
     */
    private int[] createAddress(int decimal) {
        int[] address = new int[32];
        int power = address.length - 1;
        int dec = Math.abs(decimal);

        for (int i = 0; i < address.length; i++) {
            int currValue = (int)Math.pow(2, power);
            power--; // update power for next time around

            if (dec - currValue >= 0) {
                address[i] = 1;
                dec -= currValue;
            }

            else
                address[i] = 0;
        }

        return address;
    }
}