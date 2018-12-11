package com.learnassembly.learnarmassembly;

import java.util.HashMap;

public class Branch implements ArmCode {
    private int mCodePosition;
    private String mBranchToLabelName;

    public Branch(int position, String name) {
        mCodePosition = position;
        mBranchToLabelName = name;
    }

    public String getmBranchToLabelName() {
        return mBranchToLabelName;
    }

    @Override
    public int returnPosition() {
        return 0;
    }
}
