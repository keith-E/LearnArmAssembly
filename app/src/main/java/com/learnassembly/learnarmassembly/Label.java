package com.learnassembly.learnarmassembly;

public class Label implements ArmCode {

    private String mLabelName;

    public Label(String labelName) {
        mLabelName = labelName;
    }

    @Override
    public String getCodeType() {
        return null;
    }

    @Override
    public String processLine() {
        return null;
    }
}
