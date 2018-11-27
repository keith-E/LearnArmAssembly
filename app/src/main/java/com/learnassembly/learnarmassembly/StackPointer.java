package com.learnassembly.learnarmassembly;

/*
    Represents a stack pointer.
 */
public class StackPointer {
    private int[] sp;

    /*
        Initializes stack pointer.
     */
    public StackPointer(int[] startValue) {
        this.sp = startValue;
    }

    /*
        Initializes a stack pointer given no start value.
     */
    public StackPointer() {
        int[] zero = new int[32];
        this.sp = zero;
    }

    /*
        Sets the stack pointer to point to the updated
        address.
     */
    public void setSP(int[] increment) {
        this.sp = addIncrement(increment);
    }

    /*
        Returns the current stack pointer address.
     */
    public int[] getSP() {
        return sp;
    }

    /*
        Adds the increment to the stack pointer.
     */
    private int[] addIncrement(int[] increment) {
        int[] result = new int[increment.length];
        int carry = 0;  // start without carry

        for (int i = increment.length - 1; i >= 0; i--) {
            if (this.sp[i] == 0 && increment[i] == 0 && carry == 0)
                result[i] = 0;
            else if (this.sp[i] == 0 && increment[i] == 0 && carry == 1) {
                result[i] = 1;
                carry = 0;
            }
            else if (((this.sp[i] == 0 && increment[i] == 1) ||
                    (this.sp[i] == 1 && increment[i] == 0)) && carry == 0) {
                result[i] = 1;
            }
            else if (((this.sp[i] == 0 && increment[i] == 1) ||
                    (this.sp[i] == 1 && increment[i] == 0)) && carry == 1) {
                result[i] = 0;
                carry = 1;
            }
            else if (this.sp[i] == 1 && increment[i] == 1 && carry == 0) {
                result[i] = 0;
                carry = 1;
            }
            else {
                result[i] = 1;
                carry = 1;
            }
        }

        return result;
    }
}
