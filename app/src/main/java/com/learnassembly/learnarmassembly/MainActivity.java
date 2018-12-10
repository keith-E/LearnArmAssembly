package com.learnassembly.learnarmassembly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Region;
import android.media.VolumeShaper;
import android.os.Build;
import android.os.Handler;
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
    private Button mBranchButton;
    private Button mLabelButton;
    private Button mOperationsButton;
    private Button mPlayButton;
    private Button mStepButton;
    private Button mStopButton;

    List<String> mBranchNameList;
    Map<Integer, String> editorContentsMap;
    Map<Integer, ArmCode> mCodeMap;
    int editorFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize UI/UX elements
        initializeLayouts();
        initializeButtons();
        initializeEditorLines();
        // Initialize logic elements
        mBranchNameList = new ArrayList<>();
        editorContentsMap = new HashMap<>();
        mCodeMap = new HashMap<>();
        editorFocus = 0;
        for(int i = 1; i <= 15; i++) {
            editorContentsMap.put(i, "");
        }
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

    private void editorContentsClicked() {
        mEditorLineOneContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 1;
            }
        });
        mEditorLineTwoContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 2;
            }
        });
        mEditorLineThreeContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 3;
            }
        });
        mEditorLineFourContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 4;
            }
        });
        mEditorLineFiveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 5;
            }
        });
        mEditorLineSixContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 6;
            }
        });
        mEditorLineSevenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 7;
            }
        });
        mEditorLineEightContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 8;
            }
        });
        mEditorLineNineContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 9;
            }
        });
        mEditorLineTenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 10;
            }
        });
        mEditorLineElevenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 11;
            }
        });
        mEditorLineTwelveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 12;
            }
        });
        mEditorLineThirteenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 13;
            }
        });
        mEditorLineFourteenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 14;
            }
        });
        mEditorLineFifteenContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainButtonLayout();
                editorFocus = 15;
            }
        });
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
                Context context = getApplicationContext();
//                ExecuteArmCode executeArmCode = new ExecuteArmCode(context, mCodeMap);
//                executeArmCode.playCode();
                int mPosition = 1;
                Handler mHandler = new Handler();
                while(mPosition <= 15) {
                    final int runnableInt = mPosition;
                    if(mCodeMap.containsKey(mPosition)) {
    //                    ArmCode lineOfCode = mCodeMap.get(mPosition);
                            highlightEditorLine(mPosition);
    //                        processLine(lineOfCode);
    //                    try {
    //                        Thread.sleep(1000);
    //                    } catch (InterruptedException e) {
    //                        // do nothing
    //                    }
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        deHighlightEditorLine(runnableInt);
                                    }
                                });
                            }
                        };
                        thread.start();
                    }
                    mPosition++;
                }
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
        startActivityForResult(intent, OPERATION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LABEL_NAME_REQUEST) {
            if(resultCode == RESULT_OK) {
                String labelName = data.getStringExtra(LabelNameActivity.LABEL_NAME);
                Label labelCode = new Label(editorFocus, labelName);
                mBranchNameList.add(labelName);
                mCodeMap.put(editorFocus, labelCode);
                setLabelTextInEditor(labelName);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
            }
        } else if(requestCode == BRANCH_NAME_PICK_REQUEST) {
            if(resultCode == RESULT_OK) {
                String branchName = data.getStringExtra(BranchNameActivity.BRANCH_NAME);
                Branch branchCode = new Branch(editorFocus, branchName);
                mCodeMap.put(editorFocus, branchCode);
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
        String labelTextForCodeMap = "b " + labelName;
        setEditorLineBasedOnFocus(labelTextForView, labelTextForCodeMap);
        // TODO: Possibly create code objects for HashMap -- ie interface (...implements Code)
    }

    private void setBranchTextInEditor(String branchName) {
        String branchTextForView = TAB + TAB + TAB + "<font color='red'>b</font> <font color='blue'>"
                                   + branchName + "</font>";
        String branchTextForCodeMap = "b " + branchName;
        setEditorLineBasedOnFocus(branchTextForView, branchTextForCodeMap);
    }

    private void setEditorLineBasedOnFocus(String textToSetInView, String textToSetInMap) {
        switch (editorFocus) {
            case 1:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineOneContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                                                  TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineOneContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                editorContentsMap.put(1, textToSetInMap);
                break;
            case 2:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineTwoContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineTwoContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 3:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineThreeContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineThreeContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 4:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineFourContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineFourContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 5:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineFiveContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineFiveContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 6:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineSixContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineSixContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 7:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineSevenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineSevenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 8:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineEightContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineEightContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 9:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineNineContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineNineContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 10:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineTenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineTenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 11:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineElevenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineElevenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 12:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineTwelveContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineTwelveContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 13:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineThirteenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineThirteenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 14:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineFourteenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineFourteenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
            case 15:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mEditorLineFifteenContent.setText(Html.fromHtml(textToSetInView,  Html.FROM_HTML_MODE_LEGACY),
                            TextView.BufferType.SPANNABLE);
                } else {
                    mEditorLineFifteenContent.setText(Html.fromHtml(textToSetInView), TextView.BufferType.SPANNABLE);
                }
                break;
        }
    }
    private void highlightEditorLine(int mPosition) {
        TextView editorLine;
        switch(mPosition) {
            case 1:
                editorLine =(TextView) findViewById(R.id.textview_main_editor_line_one_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_two_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_three_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_four_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 5:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_five_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 6:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_six_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 7:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_seven_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 8:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_eight_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 9:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_nine_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 10:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_ten_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 11:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_eleven_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 12:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_twelve_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 13:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_thirteen_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 14:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_fourteen_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
            case 15:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_fifteen_contents);
                editorLine.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

    private void deHighlightEditorLine(int mPosition) {
        TextView editorLine;
        switch(mPosition) {
            case 1:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_one_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_two_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_three_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 4:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_four_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 5:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_five_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 6:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_six_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 7:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_seven_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 8:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_eight_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 9:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_nine_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 10:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_ten_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 11:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_eleven_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 12:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_twelve_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 13:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_thirteen_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 14:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_fourteen_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
            case 15:
                editorLine = (TextView) findViewById(R.id.textview_main_editor_line_fifteen_contents);
                editorLine.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}
