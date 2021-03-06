package com.learnassembly.learnarmassembly;
import java.util.ArrayList;

/*
    Represents an ArmController.
 */
public class ArmController {
    private RegisterBank register;
    private Memory mem;
    private StackPointer sp;

    /*
        Initializes the ArmController.
     */
    public ArmController(RegisterBank register, Memory mem, StackPointer sp) {
        this.register = register;
        this.mem = mem;
        this.sp = sp;
    }

    /*
        Initializes the ArmController.
     */
    public ArmController() {
        this.register = new RegisterBank();
        this.mem = new Memory();
        this.sp = new StackPointer();
    }

    /*
        Mov operation for two registers.
     */
    public void mov(int rd, int rs) {
        int[] cons = this.register.getRegister(rs);
        this.register.setRegister(rd, cons);
    }

    /*
        Mov operation for register and constant.
     */
    public void mov(int rd, int[] constant) {

        this.register.setRegister(rd, constant);
    }

    /*
        Add operation.
     */
    public void add(int rd, int rs1, int rs2) {
        int[] rs1Binary = this.register.getRegister(rs1);
        int[] rs2Binary = this.register.getRegister(rs2);
        int[] result = new int[32];

        int carry = 0;  // start without carry

        for (int i = rs1Binary.length - 1; i >= 0; i--) {
            if (rs1Binary[i] == 0 && rs2Binary[i] == 0 && carry == 0)
                result[i] = 0;
            else if (rs1Binary[i] == 0 && rs2Binary[i] == 0 && carry == 1) {
                result[i] = 1;
                carry = 0;
            } else if (((rs1Binary[i] == 0 && rs2Binary[i] == 1) ||
                    (rs1Binary[i] == 1 && rs2Binary[i] == 0)) && carry == 0) {
                result[i] = 1;
            } else if (((rs1Binary[i] == 0 && rs2Binary[i] == 1) ||
                    (rs1Binary[i] == 1 && rs2Binary[i] == 0)) && carry == 1) {
                result[i] = 0;
                carry = 1;
            } else if (rs1Binary[i] == 1 && rs2Binary[i] == 1 && carry == 0) {
                result[i] = 0;
                carry = 1;
            } else {
                result[i] = 1;
                carry = 1;
            }
        }

        // store result in destination register
        this.register.setRegister(rd, result);
    }

    /*
        Basic sub operation.
     */
    public void sub(int rd, int rs1, int rs2) {
        int[] rs1Binary = this.register.getRegister(rs1);
        int[] rs2Binary = this.register.getRegister(rs2);
        int[] result = new int[32];

        int index = 0 ; // helper index

        for (int i = rs1Binary.length - 1; i >= 0; i--) {
            if (rs1Binary[i] == 1 && rs2Binary[i] == 0) {
                result[i] = 1;
            } else if (rs1Binary[i] == 1 && rs2Binary[i] == 1) {
                result[i] = 0;
            } else if (rs1Binary[i] == 0 && rs2Binary[i] == 0) {
                result[i] = 0;
            } else if (rs1Binary[i] == 0 && rs2Binary[i] == 1) {
                result[i] = 1;
                index = i - 1; // start looking at next digit

                // find next place can borrow from
                while (index >= 0) {
                    if (rs1Binary[index] == 0) {
                        rs1Binary[index] = 1;
                        index--;
                    } else if (rs1Binary[index] == 1) {
                        rs1Binary[index] = 0;
                        index = 0;  // reset index for later use
                        break;
                    }
                }
            }
        }

        this.register.setRegister(rd, result);
    }


    /*
        Basic store operation. Uses whatever memory
        address the stack pointer is currently pointing
        to.
     */
    public void str(int rs) {
        int[] valToBeStored = this.register.getRegister(rs);
        ArrayList<Integer> memAddress = convert(this.sp.getSP());

        this.mem.setMemory(memAddress, valToBeStored);
    }

    /*
        Pre-Index str operation. Either modified or not modified.
     */
    public void strPre(int rs, int[] increment, boolean modified) {
        int[] valToBeStored = this.register.getRegister(rs);

        if (modified) {
            this.sp.setSP(increment);   // increment stack pointer first
            ArrayList<Integer> memAddress = convert(this.sp.getSP());
            this.mem.setMemory(memAddress, valToBeStored);
        }

        else {
            int[] oldSPAddress = this.sp.getSP();
            this.sp.setSP(increment);   // determine memory address location first
            ArrayList<Integer> memAddress = convert(this.sp.getSP());
            this.mem.setMemory(memAddress, valToBeStored);
            this.sp.resetSP(oldSPAddress);  // leave stack pointer unchanged
        }
    }

    /*
        Post-Index str operation.
     */
    public void strPost(int rs, int[] increment) {
        int[] valToBeStored = this.register.getRegister(rs);
        ArrayList<Integer> memAddress = convert(this.sp.getSP());
        this.mem.setMemory(memAddress, valToBeStored);
        this.sp.setSP(increment);   // update the stack pointer
    }

    /*
        Basic load operation. Uses whatever memory address the
        stack pointer is currently pointing to.
     */
    public void ldr(int rd) {
        ArrayList<Integer> memAddress = convert(this.sp.getSP());
        int[] val = this.mem.getMemory(memAddress);

        this.register.setRegister(rd, val);
    }

    /*
        Pre-Index ldr operation. Can be either modified or not modified.
     */
    public void ldrPre(int rd, int[] increment, boolean modified) {
        if (modified) {
            this.sp.setSP(increment);   // update stack pointer
            ArrayList<Integer> memAddress = convert(this.sp.getSP());
            int[] valToBeLoaded = this.mem.getMemory(memAddress);
            this.register.setRegister(rd, valToBeLoaded);
        }

        else {
            int[] oldSP = this.sp.getSP();
            this.sp.setSP(increment); // determine new address first
            ArrayList<Integer> memAddress = convert(this.sp.getSP());
            int[] valToBeLoaded = this.mem.getMemory(memAddress);
            this.register.setRegister(rd, valToBeLoaded);
            this.sp.resetSP(oldSP); // leave stack pointer unmodified
        }
    }

    /*
        Post-Index ldr operation.
     */
    public void ldrPost(int rd, int[] increment) {
        ArrayList<Integer> memAddress = convert(this.sp.getSP());
        int[] valToBeLoaded = this.mem.getMemory(memAddress);
        this.register.setRegister(rd, valToBeLoaded);
        this.sp.setSP(increment);   // update stack pointer
    }

    /*
        Converts decimal to unsigned binary.
     */
    public int[] decimalToUnsignedBinary(int value, int bits)
    {
        int[] unsignedBinary = new int[bits];
        int power = bits - 1;   // start at most significant bit
        int decimal = Math.abs(value);  // ignore sign

        for (int i = 0; i < unsignedBinary.length; i++)
        {
            int currValue = (int)Math.pow(2, power);
            power--;    // update power for next time

            if (decimal - currValue >= 0)
            {
                unsignedBinary[i] = 1;
                decimal -= currValue;
            }

            else
            {
                unsignedBinary[i] = 0;
            }
        }

        return unsignedBinary;
    }

    /*
        Helper method for use in converting StackPointer to an
        ArrayList for compatibility with Memory class.
     */
    private ArrayList<Integer> convert(int[] sp) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < sp.length; i++) {
            result.add(sp[i]);
        }

        return result;
    }
}
