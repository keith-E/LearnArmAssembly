package com.learnassembly.learnarmassembly;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    public static final int BRANCH_NAME_PICK_REQUEST = 2;

    public static final String TAB = "     ";
    public static final String LABEL_COLON = ":";

    LinearLayout beginningButtonLayout;
    TextView editorLineOneContent;
    TextView editorLineTwoContent;

    List<String> branchNameList;
    Map<Integer, String> editorContentsMap;
    int editorFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beginningButtonLayout = (LinearLayout) findViewById(R.id.begButtonLayout);
        editorLineOneContent = (TextView) findViewById(R.id.line_1_content);
        editorLineTwoContent = (TextView) findViewById(R.id.line_2_content);

        branchNameList = new ArrayList<>();
        editorContentsMap = new HashMap<>();
        editorFocus = 0;

        for(int i = 1; i <= 10; i++) {
            editorContentsMap.put(i, "");
        }
        editorContentsLogic();

        labelAndBranchButtonLogic();
    }

    private void editorContentsLogic() {
        editorLineOneContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginningButtonLayout.setVisibility(View.VISIBLE);
                editorFocus = 1;
            }
        });
        editorLineTwoContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginningButtonLayout.setVisibility(View.VISIBLE);
                editorFocus = 2;
            }
        });
    }

    private void labelAndBranchButtonLogic() {
        Button clickLabelButton = (Button) findViewById(R.id.labelButton);
        clickLabelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLabelNameActivity(v);
            }
        });
        Button clickBranchButton = (Button) findViewById(R.id.branchButton);
        clickBranchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchBranchNameActivity(v);
            }
        });
    }

    private void launchLabelNameActivity(View view) {
        Intent intent = new Intent(this, LabelNameActivity.class);
        intent.putExtra("LIST_TO_SEND", (Serializable) branchNameList);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    private void launchBranchNameActivity(View view) {
        Intent intent = new Intent(this, BranchNameActivity.class);
        intent.putExtra("LABEL_NAMES_TO_SEND", (Serializable) branchNameList);
        startActivityForResult(intent, BRANCH_NAME_PICK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                String labelName = data.getStringExtra(LabelNameActivity.LABEL_NAME);

                branchNameList.add(labelName);
                setLabelInEditor(labelName);
                beginningButtonLayout.setVisibility(View.INVISIBLE);
               /* Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                for(String name : branchNameList) {
                    Toast toast = Toast.makeText(context, name, duration);
                    toast.show();
                }*/
            }
        } else if(requestCode == BRANCH_NAME_PICK_REQUEST) {
            if(resultCode == RESULT_OK) {
                String branchName = data.getStringExtra(BranchNameActivity.BRANCH_NAME);
                setBranchInEditor(branchName);
                beginningButtonLayout.setVisibility(View.INVISIBLE);
                /*Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, branchName, duration);
                toast.show();*/
            }
        }
    }

    private void setLabelInEditor(String labelName) {
        String labelText = labelName + LABEL_COLON;
        if(editorFocus == 1) {
            editorLineOneContent.setText(labelText);
        }
    }

    private void setBranchInEditor(String branchName) {
        String branchText = TAB + TAB + TAB + "b " + branchName;
        if(editorFocus == 2) {
            editorLineTwoContent.setText(branchText);
        }
    }
}
