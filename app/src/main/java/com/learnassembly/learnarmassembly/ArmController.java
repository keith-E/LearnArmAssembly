package com.learnassembly.learnarmassembly;

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
    public ArmController(RegisterBank register, Memory mem, StackPointer, sp) {
        this.register = register;
        this.mem = mem;
        this.sp = sp;
    }

    /*
        Mov operation for two registers.
     */
    public void mov(int rd, int rs) {

    }

    /*
        Mov operation for register and constant.
     */
    public void mov(int rd, int constant) {

    }
}
