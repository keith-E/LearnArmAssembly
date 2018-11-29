package com.learnassembly.learnarmassembly;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        branchButtonLogic();
    }

    private void branchButtonLogic() {
        final LinearLayout beginningButtonLayout = (LinearLayout) findViewById(R.id.begButtonLayout);
        final LinearLayout labelButtonLayout = (LinearLayout) findViewById(R.id.labelButtonLayout);
        final LinearLayout branchButtonLayout = (LinearLayout) findViewById(R.id.branchButtonLayout);
        final LinearLayout branchNameEditTextLayout = (LinearLayout) findViewById(R.id.editBranchNameLayout);

        final EditText branchNameEditText = (EditText) findViewById(R.id.branchNameText);

        Button clickLabelButton = (Button) findViewById(R.id.labelButton);
        clickLabelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginningButtonLayout.setVisibility(View.INVISIBLE);
                labelButtonLayout.setVisibility(View.VISIBLE);
            }
        });

        Button clickBranchButton = (Button) findViewById(R.id.branchButton);
        clickBranchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelButtonLayout.setVisibility(View.INVISIBLE);
                branchButtonLayout.setVisibility(View.VISIBLE);
            }
        });

        final Button clickBranchNameButton = (Button) findViewById(R.id.branchNameButton);
        clickBranchNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                branchButtonLayout.setVisibility(View.INVISIBLE);
                branchNameEditTextLayout.setVisibility(View.VISIBLE);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                String branchName = clickBranchNameButton.getText().toString();


                Toast toast = Toast.makeText(context, branchName, duration);

//                while(branchNameEditText.getText().toString().isEmpty()) {
//                    toast.show();
//                    try {
//                        Thread.sleep(2000);
//                    } catch(InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                String branchNameInput = branchNameEditText.getText().toString();
//                beginningButtonLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}
