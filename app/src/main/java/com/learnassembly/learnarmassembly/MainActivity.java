package com.learnassembly.learnarmassembly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout beginningButtonLayout = (LinearLayout) findViewById(R.id.begButtonLayout);
        final LinearLayout labelButtonLayout = (LinearLayout) findViewById(R.id.labelButtonLayout);

        Button clickLabelButton = (Button) findViewById(R.id.labelButton);
        clickLabelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginningButtonLayout.setVisibility(View.INVISIBLE);
                labelButtonLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}
