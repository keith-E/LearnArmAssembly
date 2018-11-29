package com.learnassembly.learnarmassembly;
import java.util.HashMap;
import java.util.ArrayList;

/*
    Represents the available memory.
 */
public class Memory {
    private HashMap<ArrayList<Integer>, int[]> memory = new HashMap<>();

    /*
        Initializes the memory with the memory
        addresses.
     */
    public Memory() {
        for (int i = 0; i < 4096; i+=32) {
            ArrayList<Integer> address = createAddress(i);
            int[] zeros = new int[32];
            memory.put(address, zeros);
        }
    }

    /*
        Sets the given memory address to the given value.
     */
    public void setMemory(ArrayList<Integer> address, int[] value) {
        if (memory.containsKey(address))
            memory.put(address, value);

        else
            System.err.println("Invalid memory address.");
    }

    /*
        Retrieves the binary number stored in the
        given memory address.
     */
    public int[] getMemory(ArrayList<Integer> address) {
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
    private ArrayList<Integer> createAddress(int decimal) {
        ArrayList<Integer> address = new ArrayList<>();
        int power = 31;
        int dec = Math.abs(decimal);

        for (int i = 0; i < 32; i++) {
            int currValue = (int)Math.pow(2, power);
            power--; // update power for next time around

            if (dec - currValue >= 0) {
                address.add(i, 1);
                dec -= currValue;
            }

            else
                address.add(i, 0);
        }

        return address;
    }
}