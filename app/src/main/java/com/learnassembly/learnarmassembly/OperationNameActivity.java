package com.learnassembly.learnarmassembly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OperationNameActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_name);

        final android.widget.Spinner spinner = findViewById(R.id.operationNameSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button operationNameSubmitButton = (Button) findViewById(R.id.OP_SUBMIT);
        operationNameSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = spinner.getSelectedItem().toString();

                if (selection.equals("MOV")) {
                    LinearLayout layout = findViewById(R.id.MOV_OP);
                    LinearLayout layout2 = findViewById(R.id.ADD_OP);
                    LinearLayout layout3 = findViewById(R.id.SUB_OP);
                    LinearLayout layout4 = findViewById(R.id.LDR_OP);
                    LinearLayout layout5 = findViewById(R.id.STR_OP);
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);

                } else if (selection.equals("ADD")) {
                    LinearLayout layout = findViewById(R.id.ADD_OP);
                    LinearLayout layout2 = findViewById(R.id.MOV_OP);
                    LinearLayout layout3 = findViewById(R.id.SUB_OP);
                    LinearLayout layout4 = findViewById(R.id.LDR_OP);
                    LinearLayout layout5 = findViewById(R.id.STR_OP);
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);

                } else if (selection.equals("SUB")) {
                    LinearLayout layout = findViewById(R.id.SUB_OP);
                    LinearLayout layout2 = findViewById(R.id.MOV_OP);
                    LinearLayout layout3 = findViewById(R.id.ADD_OP);
                    LinearLayout layout4 = findViewById(R.id.LDR_OP);
                    LinearLayout layout5 = findViewById(R.id.STR_OP);
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);

                } else if (selection.equals("LDR")) {
                    LinearLayout layout = findViewById(R.id.LDR_OP);
                    LinearLayout layout2 = findViewById(R.id.MOV_OP);
                    LinearLayout layout3 = findViewById(R.id.ADD_OP);
                    LinearLayout layout4 = findViewById(R.id.SUB_OP);
                    LinearLayout layout5 = findViewById(R.id.STR_OP);
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);

                } else if (selection.equals("STR")) {
                    LinearLayout layout = findViewById(R.id.STR_OP);
                    LinearLayout layout2 = findViewById(R.id.MOV_OP);
                    LinearLayout layout3 = findViewById(R.id.ADD_OP);
                    LinearLayout layout4 = findViewById(R.id.LDR_OP);
                    LinearLayout layout5 = findViewById(R.id.SUB_OP);
                    layout.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
