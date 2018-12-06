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

    List<String> mBranchNameList;
    Map<Integer, String> editorContentsMap;
    Map<Integer, ArmCode> codeMap;
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
        codeMap = new HashMap<>();
        editorFocus = 0;
        for(int i = 1; i <= 15; i++) {
            editorContentsMap.put(i, "");
        }
        // Handle UI/UX events
        editorContentsClicked();
        coreBranchButtonClicked();
    }

    private void initializeLayouts() {
        mCoreButtonLinearLayout = (LinearLayout) findViewById(R.id.linearlayout_main_core_buttonlayout);
    }

    private void initializeButtons() {
        mBranchButton = (Button) findViewById(R.id.button_main_branch);
        mLabelButton = (Button) findViewById(R.id.button_main_label);
        mOperationsButton = (Button) findViewById(R.id.operationsButton);
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

    private void coreBranchButtonClicked() {
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
                Label labelCode = new Label(editorFocus, labelName);
                mBranchNameList.add(labelName);
                codeMap.put(editorFocus, labelCode);
                setLabelTextInEditor(labelName);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
               /* Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                for(String name : mBranchNameList) {
                    Toast toast = Toast.makeText(context, name, duration);
                    toast.show();
                }*/
            }
        } else if(requestCode == BRANCH_NAME_PICK_REQUEST) {
            if(resultCode == RESULT_OK) {
                String branchName = data.getStringExtra(BranchNameActivity.BRANCH_NAME);
                Branch branchCode = new Branch(editorFocus, branchName);
                codeMap.put(editorFocus, branchCode);
                setBranchTextInEditor(branchName);
                mCoreButtonLinearLayout.setVisibility(View.INVISIBLE);
                /*Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, branchName, duration);
                toast.show();*/
            }
        }
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

    /*private void setEditorlLineTextColorBasedOnFocus(String textType) {
        int textColor;
        if(textType.equalsIgnoreCase("LABEL")) {
            textColor = Color.BLUE;
        } else if(textType.equalsIgnoreCase("BRANCH")) {
            textColor = Color.RED;
        } else {
            textColor = Color.BLACK;
        }
        switch (editorFocus) {
            case 1:
                mEditorLineOneContent.setTextColor(textColor);
                break;
            case 2:
                mEditorLineTwoContent.setTextColor(textColor);
                break;
            case 3:
                mEditorLineThreeContent.setTextColor(textColor);
                break;
            case 4:
                mEditorLineFourContent.setTextColor(textColor);
                break;
            case 5:
                mEditorLineFiveContent.setTextColor(textColor);
                break;
            case 6:
                mEditorLineSixContent.setTextColor(textColor);
                break;
            case 7:
                mEditorLineSevenContent.setTextColor(textColor);
                break;
            case 8:
                mEditorLineEightContent.setTextColor(textColor);
                break;
            case 9:
                mEditorLineNineContent.setTextColor(textColor);
                break;
            case 10:
                mEditorLineTenContent.setTextColor(textColor);
                break;
            case 11:
                mEditorLineElevenContent.setTextColor(textColor);
                break;
            case 12:
                mEditorLineTwelveContent.setTextColor(textColor);
                break;
            case 13:
                mEditorLineThirteenContent.setTextColor(textColor);
                break;
            case 14:
                mEditorLineFourteenContent.setTextColor(textColor);
                break;
            case 15:
                mEditorLineFifteenContent.setTextColor(textColor);
        }
    }*/
}
