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
        // TODO
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
}