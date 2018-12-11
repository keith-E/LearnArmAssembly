package com.learnassembly.learnarmassembly;

import java.util.HashMap;
import java.util.Map;

public class ExecuteArmCode  {

    private static final int MAX_CODE_MAP_SIZE = 15;

    private Map<Integer, ArmCode> mCodeMap;
    private Map<Integer, String> mRegisterBankValues;
    private int mPosition;

    public ExecuteArmCode(Map<Integer, ArmCode> code) {
        mCodeMap = code;
        mPosition = 1;
        mRegisterBankValues = new HashMap<>();
    }

    public void playCode() {
        while(mPosition <= MAX_CODE_MAP_SIZE) {
            ArmCode lineOfCode = mCodeMap.get(mPosition);
            if(lineOfCode != null) {
                processLineOfCode(lineOfCode);
            }
            mPosition++;
        }
    }

    public void stepCode() {
        boolean codeFound = false;
        while(!codeFound || mPosition <= MAX_CODE_MAP_SIZE) {
            ArmCode lineOfCode = mCodeMap.get(mPosition);
            if(lineOfCode != null) {
                codeFound = true;
                processLineOfCode(lineOfCode);
            }
            mPosition++;
        }
        codeFound = false;
    }

    public void stopCode() {

    }

    public Map<Integer, String> getRegisterBankValues() {
        return mRegisterBankValues;
    }

    private void processLineOfCode(ArmCode lineOfCodeToProcess) {
        if(lineOfCodeToProcess instanceof Label) {
            // do nothing
        } else if(lineOfCodeToProcess instanceof Branch) {
            String labelNameToBranchTo = ((Branch)lineOfCodeToProcess).getmBranchToLabelName();
            changePositionToLabel(labelNameToBranchTo);
        } else if(lineOfCodeToProcess instanceof Mov) {
            // TODO: UPDATE THIS! blah blah blah
            mRegisterBankValues.put(0, "0000 0001 1110 0000 1101 0010 0110 0000");
            mRegisterBankValues.put(3, "0110 0001 1010 0010 1101 0010 0110 0000");
        }
        // TROUBLESHOOTING
        mRegisterBankValues.put(0, "0000 0001 1110 0000 1101 0010 0110 0000");
        mRegisterBankValues.put(3, "0110 0001 1010 0010 1101 0010 0110 0000");
    }

    private void changePositionToLabel(String labelNameToBranchTo) {
        for(Map.Entry<Integer, ArmCode> code : mCodeMap.entrySet()) {
            if(code instanceof Label) {
                if(((Label)code).getLabelName().equalsIgnoreCase(labelNameToBranchTo)) {
                    mPosition = ((Label)code).returnPosition();
                }
            }
        }
    }

}
