package com.learnassembly.learnarmassembly;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> branchNameList;
    public static final int TEXT_REQUEST = 1;
    public static final int BRANCH_NAME_PICK_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        branchNameList = new ArrayList<>();

        branchButtonLogic();
    }

    private void branchButtonLogic() {
        final LinearLayout beginningButtonLayout = (LinearLayout) findViewById(R.id.begButtonLayout);

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

        Button clickOperationButton = (Button) findViewById(R.id.operationsButton);
        clickOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchOperationNameActivity(v);
            }
        });
    }

    private void launchLabelNameActivity(View view) {
        Intent intent = new Intent(this, LabelNameActivity.class);
        intent.putExtra("LIST_TO_SEND", (Serializable) branchNameList);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    private void launchOperationNameActivity(View view) {
        Intent intent = new Intent(this, OperationNameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                String labelName = data.getStringExtra(LabelNameActivity.LABEL_NAME);

                branchNameList.add(labelName);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                for(String name : branchNameList) {
                    Toast toast = Toast.makeText(context, name, duration);
                    toast.show();
                }
            }
        } else if(requestCode == BRANCH_NAME_PICK_REQUEST) {
            if(resultCode == RESULT_OK) {
                String branchName = data.getStringExtra(BranchNameActivity.BRANCH_NAME);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, branchName, duration);
                toast.show();
            }
        }
    }

    private void launchBranchNameActivity(View view) {
        Intent intent = new Intent(this, BranchNameActivity.class);
        intent.putExtra("LABEL_NAMES_TO_SEND", (Serializable) branchNameList);
        startActivityForResult(intent, BRANCH_NAME_PICK_REQUEST);
    }
}