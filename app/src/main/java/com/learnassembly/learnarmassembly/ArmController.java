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
