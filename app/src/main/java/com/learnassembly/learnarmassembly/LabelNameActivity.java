package com.learnassembly.learnarmassembly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LabelNameActivity extends MainActivity {

    EditText labelNameEditText;
    public static final String LABEL_NAME = "com.learnassembly.learnarmassembly.LabelNameActivity.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_name);

        labelNameEditText = (EditText) findViewById(R.id.editLabelName);

        Button labelNameSubmitButton = (Button) findViewById(R.id.submitLabelNameButton);
        labelNameSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String labelName = labelNameEditText.getText().toString();
                Intent labelIntent = new Intent();
                labelIntent.putExtra(LABEL_NAME, labelName);
                setResult(RESULT_OK, labelIntent);
                finish();
            }
        });
    }
}
