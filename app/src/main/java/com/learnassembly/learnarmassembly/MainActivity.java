package com.learnassembly.learnarmassembly;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Region;
import android.media.VolumeShaper;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final int LABEL_NAME_REQUEST = 1;
    public static final int BRANCH_NAME_PICK_REQUEST = 2;
    public static final int OPERATION_REQUEST = 3;
    public static RegisterBank registerBank = new RegisterBank();
    public static Memory memory = new Memory();
    public static StackPointer stackPointer = new StackPointer();
    public static ArmController ac = new ArmController(registerBank, memory, stackPointer);

    public static final String TAB = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
    public static final String LABEL_COLON = ":";

    private LinearLayout mCoreButtonLinearLayout;
    private TextView mEditorLineOneContent;
    private TextView mEditorLineTwoContent;
    private TextView mEditorLineThreeContent;
    private TextView mEditorLineFourContent;
    private TextView mEditorLineFiveContent;
    private TextView mEditorLineSixContent;
    private TextView mEditorLineSevenContent;
    private TextView mEditorLineEightContent;
    private TextView mEditorLineNineContent;
    private TextView mEditorLineTenContent;
    private TextView mEditorLineElevenContent;
    private TextView mEditorLineTwelveContent;
    private TextView mEditorLineThirteenContent;
    private TextView mEditorLineFourteenContent;
    private TextView mEditorLineFifteenContent;
    private TextView mRegisterBankZeroContent;
    private TextView mRegisterBankOneContent;
    private TextView mRegisterBankTwoContent;
    private TextView mRegisterBankThreeContent;
    private TextView mRegisterBankFourContent;
    private TextView mRegisterBankFiveContent;
    private TextView mRegisterBankSixContent;
    private TextView mRegisterBankSevenContent;
    private TextView mRegisterBankEightContent;
    private TextView mRegisterBankNineContent;
    private TextView mRegisterBankTenContent;
    private TextView mRegisterBankElevenContent;
    private TextView mRegisterBankTwelveContent;
    private TextView mRegisterBankStackPointerContent;
    private TextView mRegisterBankLinkRegisterContent;
    private TextView mRegisterBankProgramCounterContent;
    private Button mBranchButton;
    private Button mLabelButton;
    private Button mOperationsButton;
    private Button mPlayButton;
    private Button mStepButton;
    private Button mResetButton;

    List<String> mBranchNameList;
    Map<Integer, TextView> mEditorContentsMap;
    Map<Integer, TextView> mRegisterBankContentsMap;
    Map<Integer, ArmCode> mCodeMap;
    int mEditorFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize logic elements
        mBranchNameList = new ArrayList<>();
        mEditorContentsMap = new HashMap<>();
        mRegisterBankContentsMap = new HashMap<>();
        mCodeMap = new HashMap<>();
        mEditorFocus = 0;
        // Initialize UI/UX elements
        initializeLayouts();
        initializeButtons();
        initializeEditorLines();
        initializeEditorLinesMap();
        initializeRegisterBank();
        initializeRegisterBankMap();
        // Handle UI/UX events
        editorContentsClicked();
        coreButtonClicked();
        executeButtonClicked();
    }

    private void initializeLayouts() {
        mCoreButtonLinearLayout = (LinearLayout) findViewById(R.id.linearlayout_main_core_buttonlayout);
    }

    private void initializeButtons() {
        mBranchButton = (Button) findViewById(R.id.button_main_branch);
        mLabelButton = (Button) findViewById(R.id.button_main_label);
        mOperationsButton = (Button) findViewById(R.id.operationsButton);
        mPlayButton = (Button) findViewById(R.id.button_main_play);
        mStepButton = (Button) findViewById(R.id.button_main_step);
        mResetButton = (Button) findViewById(R.id.button_main_reset);
    }

    private void initializeEditorLines() {
        mEditorLineOneContent = (TextView) findViewById(R.id.textview_main_editor_line_one_contents);
        mEditorLineTwoContent = (TextView) findViewById(R.id.textview_main_editor_line_two_contents);
        mEditorLineThreeContent = (TextView) findViewById(R.id.textview_main_editor_line_three_contents);
        mEditorLineFourContent = (TextView) findViewById(R.id.textview_main_editor_line_four_contents);
        mEditorLineFiveContent = (TextView) findViewById(R.id.textview_main_editor_line_five_contents);
        mEditorLineSixContent = (TextView) findViewById(R.id.textview_main_editor_line_six_contents);
        mEditorLineSevenContent = (TextView) findViewById(R.id.textview_main_editor_line_seven_contents);
        mEditorLineEightContent = (TextView) findViewById(R.id.textview_main_editor_line_eight_contents);
        mEditorLineNineContent = (TextView) findViewById(R.id.textview_main_editor_line_nine_contents);
        mEditorLineTenContent = (TextView) findViewById(R.id.textview_main_editor_line_ten_contents);
        mEditorLineElevenContent = (TextView) findViewById(R.id.textview_main_editor_line_eleven_contents);
        mEditorLineTwelveContent = (TextView) findViewById(R.id.textview_main_editor_line_twelve_contents);
        mEditorLineThirteenContent = (TextView) findViewById(R.id.textview_main_editor_line_thirteen_contents);
        mEditorLineFourteenContent = (TextView) findViewById(R.id.textview_main_editor_line_fourteen_contents);
        mEditorLineFifteenContent = (TextView) findViewById(R.id.textview_main_editor_line_fifteen_contents);
    }

    private void initializeEditorLinesMap() {
        mEditorContentsMap.put(1, mEditorLineOneContent);
        mEditorContentsMap.put(2, mEditorLineTwoContent);
        mEditorContentsMap.put(3, mEditorLineThreeContent);
        mEditorContentsMap.put(4, mEditorLineFourContent);
        mEditorContentsMap.put(5, mEditorLineFiveContent);
        mEditorContentsMap.put(6, mEditorLineSixContent);
        mEditorContentsMap.put(7, mEditorLineSevenContent);
        mEditorContentsMap.put(8, mEditorLineEightContent);
        mEditorContentsMap.put(9, mEditorLineNineContent);
        mEditorContentsMap.put(10, mEditorLineTenContent);
        mEditorContentsMap.put(11, mEditorLineElevenContent);
        mEditorContentsMap.put(12, mEditorLineTwelveContent);
        mEditorContentsMap.put(13, mEditorLineThirteenContent);
        mEditorContentsMap.put(14, mEditorLineFourteenContent);
        mEditorContentsMap.put(15, mEditorLineFifteenContent);
    }

    private void initializeRegisterBank() {
        mRegisterBankZeroContent = (TextView) findViewById(R.id.r0Contents);
        mRegisterBankOneContent = (TextView) findViewById(R.id.r1Contents);
        mRegisterBankTwoContent = (TextView) findViewById(R.id.r2Contents);
        mRegisterBankThreeContent = (TextView) findViewById(R.id.r3Contents);
        mRegisterBankFourContent = (TextView) findViewById(R.id.r4Contents);
        mRegisterBankFiveContent = (TextView) findViewById(R.id.r5Contents);
        mRegisterBankSixContent = (TextView) findViewById(R.id.r6Contents);
        mRegisterBankSevenContent = (TextView) findViewById(R.id.r7Contents);
        mRegisterBankEightContent = (TextView) findViewById(R.id.r8Contents);
        mRegisterBankNineContent = (TextView) findViewById(R.id.r9Contents);
        mRegisterBankTenContent = (TextView) findViewById(R.id.r10Contents);
        mRegisterBankElevenContent = (TextView) findViewById(R.id.r11Contents);
        mRegisterBankTwelveContent = (TextView) findViewById(R.id.r12Contents);
        mRegisterBankStackPointerContent = (TextView) findViewById(R.id.spContents);
        mRegisterBankLinkRegisterContent = (TextView) findViewById(R.id.lrContents);
        mRegisterBankProgramCounterContent = (TextView) findViewById(R.id.pcContents);
    }

    private void initializeRegisterBankMap() {
        mRegisterBankContentsMap.put(0, mRegisterBankZeroContent);
        mRegisterBankContentsMap.put(1, mRegisterBankOneContent);
        mRegisterBankContentsMap.put(2, mRegisterBankTwoContent);
        mRegisterBankContentsMap.put(3, mRegisterBankThreeContent);
        mRegisterBankContentsMap.put(4, mRegisterBankFourContent);
        mRegisterBankContentsMap.put(5, mRegisterBankFiveContent);
        mRegisterBankContentsMap.put(6, mRegisterBankSixContent);
        mRegisterBankContentsMap.put(7, mRegisterBankSevenContent);
        mRegisterBankContentsMap.put(8, mRegisterBankEightContent);
        mRegisterBankContentsMap.put(9, mRegisterBankNineContent);
        mRegisterBankContentsMap.put(10, mRegisterBankTenContent);
        mRegisterBankContentsMap.put(11, mRegisterBankElevenContent);
        mRegisterBankContentsMap.put(12, mRegisterBankTwelveContent);
        mRegisterBankContentsMap.put(13, mRegisterBankStackPointerContent);
        mRegisterBankContentsMap.put(14, mRegisterBankLinkRegisterContent);
        mRegisterBankContentsMap.put(15, mRegisterBankProgramCounterContent);
    }

    private void editorContentsClicked() {
        for(int i = 1; i <= 15; i++) {
            final int lineToFocusOn = i;
            TextView editorLineContent = mEditorContentsMap.get(i);
            editorLineContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMainButtonLayout();
                    mEditorFocus = lineToFocusOn;
                }
            });
        }
    }

    private void showMainButtonLayout() {
        if(mBranchNameList.isEmpty()) {
            mBranchButton.setVisibility(View.GONE);
        } else {
            mBranchButton.setVisibility(View.VISIBLE);
        }
        mCoreButtonLinearLayout.setVisibility(View.VISIBLE);
    }

    private void coreButtonClicked() {
        mLabelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLabelNameActivity(v);
            }
        });
        mBranchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchBranchNameActivity(v);
            }
        });
        mOperationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchOperationNameActivity(v);
            }
        });
    }

    private void executeButtonClicked() {
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteArmCode executeArmCode = new ExecuteArmCode(mCodeMap);
                executeArmCode.playCode();
                Map<Integer, String> registerBankResults = executeArmCode.getRegisterBankValues();
                setRegisterBankContentsBasedOnExecuteResults(registerBankResults);
            }
        });
        mStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetUi();
                resetVariables();
            }
        });
    }

    private void setRegisterBankContentsBasedOnExecuteResults(Map<Integer, String> registerBankResults) {
        for(int i = 0; i <= 15; i++) {
            if(registerBankResults.get(i) != null) {
                String valueToSet = registerBankResults.get(i);
                TextView registerBankToSet = mRegisterBankContentsMap.get(i);
                registerBankToSet.setText(valueToSet);
            }
        }
    }

    private void resetUi() {
        for(int i = 1; i <= 15; i++) {
            TextView editorLineContents = mEditorContentsMap.get(i);
            editorLineContents.setText("");
        }
        for(int i = 0; i <= 15; i++) {
            TextView registerBankContents = mRegisterBankContentsMap.get(i);
            registerBankContents.setText(R.string.thirtyTwoBitBinaryZero);
        }
    }

    private void resetVariables() {
        mCodeMap.clear();
        mEditorFocus = 0;
        mBranchNameList.clear();
        mBranchButton.setVisibility(View.GONE);
        mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
    }

    private void launchLabelNameActivity(View view) {
        Intent intent = new Intent(this, LabelNameActivity.class);
        intent.putExtra("LIST_TO_SEND", (Serializable) mBranchNameList);
        startActivityForResult(intent, LABEL_NAME_REQUEST);

    }

    private void launchBranchNameActivity(View view) {
        Intent intent = new Intent(this, BranchNameActivity.class);
        intent.putExtra("LABEL_NAMES_TO_SEND", (Serializable) mBranchNameList);
        startActivityForResult(intent, BRANCH_NAME_PICK_REQUEST);
    }

    private void launchOperationNameActivity(View view) {
        Intent intent = new Intent(this, OperationNameActivity.class);
        startActivityForResult(intent, OPERATION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LABEL_NAME_REQUEST) {
            if(resultCode == RESULT_OK) {
                String labelName = data.getStringExtra(LabelNameActivity.LABEL_NAME);
                Label labelCode = new Label(mEditorFocus, labelName);
                mBranchNameList.add(labelName);
                mCodeMap.put(mEditorFocus, labelCode);
                setLabelTextInEditor(labelName);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
            }
        } else if(requestCode == BRANCH_NAME_PICK_REQUEST) {
            if(resultCode == RESULT_OK) {
                String branchName = data.getStringExtra(BranchNameActivity.BRANCH_NAME);
                Branch branchCode = new Branch(mEditorFocus, branchName);
                mCodeMap.put(mEditorFocus, branchCode);
                setBranchTextInEditor(branchName);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
            }
        } else if(requestCode == OPERATION_REQUEST) {
            if(resultCode == RESULT_OK) {
                String dr = data.getStringExtra(OperationNameActivity.OPERATION_RESULT);
                int regNum = Integer.parseInt(dr);

                setRegisterBankOnDisplay(regNum);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
            }
        }
    }

    private TextView determineRegisterID(int regNum) {
        TextView registerContent;

        switch (regNum) {
            case 0:
                return (TextView) findViewById(R.id.r0Contents);
            case 1:
                return (TextView) findViewById(R.id.r1Contents);
            case 2:
                return (TextView) findViewById(R.id.r2Contents);
            case 3:
                return (TextView) findViewById(R.id.r3Contents);
            case 4:

                return (TextView) findViewById(R.id.r4Contents);
            case 5:
                return (TextView) findViewById(R.id.r5Contents);
            case 6:
                return (TextView) findViewById(R.id.r6Contents);
            case 7:
                return (TextView) findViewById(R.id.r7Contents);
            case 8:
                return (TextView) findViewById(R.id.r8Contents);
            case 9:
                return (TextView) findViewById(R.id.r9Contents);
            case 10:
                return (TextView) findViewById(R.id.r10Contents);
            case 11:
                return (TextView) findViewById(R.id.r11Contents);
            case 12:
                return (TextView) findViewById(R.id.r12Contents);
            case 13:
                return (TextView) findViewById(R.id.spContents);
            case 14:
                return (TextView) findViewById(R.id.lrContents);
            case 15:
                return (TextView) findViewById(R.id.pcContents);
        }

        return (TextView) findViewById(R.id.r0Contents);    // by default
    }


    private void setRegisterBankOnDisplay(int register) {
        int[] binaryNumber = registerBank.getRegister(register);
        String binaryString = ViewConversion.binaryToString(binaryNumber);

        TextView registerContents = determineRegisterID(register);
        registerContents.setText(binaryString);
    }

    private void setLabelTextInEditor(String labelName) {
        String labelTextForView = "<font color='blue'>" + labelName + "</font>" + LABEL_COLON;
        setEditorLineBasedOnFocus(labelTextForView);
    }

    private void setBranchTextInEditor(String branchName) {
        String branchTextForView = TAB + TAB + TAB + "<font color='red'>b</font> <font color='blue'>"
                                   + branchName + "</font>";
        setEditorLineBasedOnFocus(branchTextForView);
    }

    private void setEditorLineBasedOnFocus(String textToSetInView) {
        TextView focusedEditorLine = mEditorContentsMap.get(mEditorFocus);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            focusedEditorLine.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                    TextView.BufferType.SPANNABLE);
        } else {
            focusedEditorLine.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
        }
    }
}
