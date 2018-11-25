package com.learnassembly.learnarmassembly;
import java.util.ArrayList;

/*
    Represents the registers on the ARM.
 */
public class RegisterBank {
    private ArrayList<int[]> rb = new ArrayList<int[]>();

    /*
        Initializes RegisterBank to contain all 0s to start.
     */
    public RegisterBank() {
        for (int i = 0; i < 32; i++) {
            int[] empty = new int[32];
            rb.add(empty);
        }
    }

    /*
        Retrieve binary number at given register number.
     */
    public int[] getRegister(int register) {
        try {
            return this.rb.get(index);
        }

        catch {
            System.err.print("Invalid register.");
        }
    }

    /*
        Set binary number at given register number.
     */
    public void setRegister(int register, int[] num) {
        try {
            this.rb.set(register, num);
        }

        catch {
            System.err.print("Invalid register.");
        }
    }
}