package com.learnassembly.learnarmassembly;

import android.content.Intent;
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
    private Button mBranchButton;
    private Button mLabelButton;
    private Button mOperationsButton;
    private Button mPlayButton;
    private Button mStepButton;
    private Button mStopButton;

    List<String> mBranchNameList;
    Map<Integer, TextView> mEditorContentsMap;
    Map<Integer, ArmCode> mCodeMap;
    int mEditorFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize logic elements
        mBranchNameList = new ArrayList<>();
        mEditorContentsMap = new HashMap<>();
        mCodeMap = new HashMap<>();
        mEditorFocus = 0;
        // Initialize UI/UX elements
        initializeLayouts();
        initializeButtons();
        initializeEditorLines();
        initializeEditorLinesMap();
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
        mStopButton = (Button) findViewById(R.id.button_main_stop);
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
//                executeArmCode.playCode();

            }
        });
        mStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
        startActivity(intent);
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
        }
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
