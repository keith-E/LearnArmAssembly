package com.learnassembly.learnarmassembly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class BranchNameActivity extends MainActivity {

    public static final String BRANCH_NAME = "com.learnassembly.learnarmassembly.BranchNameActivity.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_name);

        ArrayList<String> branchNames = (ArrayList<String>) getIntent().getSerializableExtra("LABEL_NAMES_TO_SEND");
        final Spinner branchNameSpinner = (Spinner) findViewById(R.id.branchNameSpinner);
        ArrayAdapter<String> branchSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, branchNames);
        branchNameSpinner.setAdapter(branchSpinnerAdapter);

        String selectedBranchName;

        Button submitBranchNameButton = (Button) findViewById(R.id.submitBranchNameButton);
        submitBranchNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branchNameSelected = branchNameSpinner.getSelectedItem().toString();
                Intent branchNameIntent = new Intent();
                branchNameIntent.putExtra(BRANCH_NAME, branchNameSelected);
                setResult(RESULT_OK, branchNameIntent);
                finish();
            }
        });
    }
}
