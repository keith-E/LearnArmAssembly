package com.learnassembly.learnarmassembly;

public class Label implements ArmCode {

    private String mLabelName;
    private int editorPosition;

    public Label(int position, String labelName) {
        mLabelName = labelName;
        editorPosition = position;
    }

    public String getLabelName() {
        return mLabelName;
    }

    public int returnPosition() {
        return editorPosition;
    }
}
