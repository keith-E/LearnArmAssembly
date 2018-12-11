package com.learnassembly.learnarmassembly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class OperationNameActivity extends MainActivity implements AdapterView.OnItemSelectedListener{

    public static final String OPERATION_RESULT = "com.learnassembly.learnarmassembly.OperationNameActivity.OP_RESULT";

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

        // operator listeners
        movExecute();
        addExecute();
        subExecute();
        ldrExecute();
        strExecute();
    }

    public void movExecute() {
        Button movExecuteButton = (Button) findViewById(R.id.EXE_MOV);

        movExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioCons = (RadioButton) findViewById(R.id.MOV_CONS);
                RadioButton radioReg = (RadioButton) findViewById(R.id.MOV_REG);
                EditText dest = (EditText) findViewById(R.id.MOV_DEST);
                EditText src = (EditText) findViewById(R.id.MOV_SRC);
                int destination = Integer.parseInt(dest.getText().toString());
                int source = Integer.parseInt(src.getText().toString());
                String operation = "";

                if (radioCons.isChecked() && !radioReg.isChecked()) {
                    int[] cons = ac.decimalToUnsignedBinary(source, 32);
                    ac.mov(destination, cons);
                    operation = "MOV r" + destination + ", " + source;

                } else if (radioReg.isChecked() && !radioCons.isChecked()) {
                    ac.mov(destination, source);
                    operation = "MOV r" + destination + ", r" + source;
                }

                Intent movIntent = new Intent();
                movIntent.putExtra(OPERATION_RESULT, operation);
                setResult(RESULT_OK, movIntent);
                finish();
            }
        });
    }

    public void addExecute() {
        Button addExecuteButton = (Button) findViewById(R.id.EXE_ADD);

        addExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dest = (EditText) findViewById(R.id.ADD_DEST);
                EditText op1 = (EditText) findViewById(R.id.ADD_OP1);
                EditText op2 = (EditText) findViewById(R.id.ADD_OP2);
                int destination = Integer.parseInt(dest.getText().toString());
                int operator1 = Integer.parseInt(op1.getText().toString());
                int operator2 = Integer.parseInt(op2.getText().toString());

                ac.add(destination, operator1, operator2);

                String operation = "ADD r" + destination + ", r" + operator1 + ", r" + operator2;

                Intent addIntent = new Intent();
                addIntent.putExtra(OPERATION_RESULT, operation);
                setResult(RESULT_OK, addIntent);
                finish();
            }
        });
    }

    public void subExecute() {
        Button subExecuteButton = (Button) findViewById(R.id.EXE_SUB);

        subExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dest = (EditText) findViewById(R.id.SUB_DEST);
                EditText op1 = (EditText) findViewById(R.id.SUB_OP1);
                EditText op2 = (EditText) findViewById(R.id.SUB_OP2);
                int destination = Integer.parseInt(dest.getText().toString());
                int operator1 = Integer.parseInt(op1.getText().toString());
                int operator2 = Integer.parseInt(op2.getText().toString());

                ac.sub(destination, operator1, operator2);

                String operation = "SUB r" + destination + ", r" + operator1 + ", r" + operator2;

                Intent subIntent = new Intent();
                subIntent.putExtra(OPERATION_RESULT, operation);
                setResult(RESULT_OK, subIntent);
                finish();
            }
        });
    }

    public void ldrExecute() {
        Button ldrExecuteButton = (Button) findViewById(R.id.EXE_LDR);

        ldrExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioReg = (RadioButton) findViewById(R.id.LDR_REG);
                RadioButton radioPreMod = (RadioButton) findViewById(R.id.LDR_PREMOD);
                RadioButton radioPre = (RadioButton) findViewById(R.id.LDR_PRE);
                RadioButton radioPost = (RadioButton) findViewById(R.id.LDR_POST);
                EditText dest = (EditText) findViewById(R.id.LDR_DEST);
                EditText inc = (EditText) findViewById(R.id.LDR_INCREMENT);
                int destination = Integer.parseInt(dest.getText().toString());
                int increment = Integer.parseInt(inc.getText().toString());
                String operation = "";

                if (radioReg.isChecked() && !radioPreMod.isChecked() &&
                        !radioPre.isChecked() && !radioPost.isChecked()) {
                    ac.ldr(destination);
                    operation = "LDR r" + destination + ", [sp]";

                } else if (radioPreMod.isChecked() && !radioReg.isChecked() &&
                        !radioPre.isChecked() && !radioPost.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.ldrPre(destination, i, true);
                    operation = "LDR r" + destination + ", [sp, #" + increment + "]!";

                } else if (radioPre.isChecked() && !radioPreMod.isChecked() &&
                        !radioReg.isChecked() && !radioPost.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.ldrPre(destination, i, false);
                    operation = "LDR r" + destination + ", [sp, #" + increment + "]";

                } else if (radioPost.isChecked() && !radioPreMod.isChecked() &&
                        !radioPre.isChecked() && !radioReg.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.ldrPost(destination, i);
                    operation = "LDR r" + destination + ", [sp], #" + increment;
                }

                Intent ldrIntent = new Intent();
                ldrIntent.putExtra(OPERATION_RESULT, operation);
                setResult(RESULT_OK, ldrIntent);
                finish();
            }
        });
    }

    public void strExecute() {
        Button strExecuteButton = (Button) findViewById(R.id.EXE_STR);

        strExecuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioReg = (RadioButton) findViewById(R.id.STR_REG);
                RadioButton radioPreMod = (RadioButton) findViewById(R.id.STR_PREMOD);
                RadioButton radioPre = (RadioButton) findViewById(R.id.STR_PRE);
                RadioButton radioPost = (RadioButton) findViewById(R.id.STR_POST);
                EditText dest = (EditText) findViewById(R.id.STR_DEST);
                EditText inc = (EditText) findViewById(R.id.STR_INCREMENT);
                int destination = Integer.parseInt(dest.getText().toString());
                int increment = Integer.parseInt(inc.getText().toString());
                String operation = "";

                if (radioReg.isChecked() && !radioPreMod.isChecked() &&
                        !radioPre.isChecked() && !radioPost.isChecked()) {
                    ac.str(destination);
                    operation = "STR r" + destination + ", [sp]";

                } else if (radioPreMod.isChecked() && !radioReg.isChecked() &&
                        !radioPre.isChecked() && !radioPost.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.strPre(destination, i, true);
                    operation = "STR r" + destination + ", [sp, #" + increment + "]!";

                } else if (radioPre.isChecked() && !radioPreMod.isChecked() &&
                        !radioReg.isChecked() && !radioPost.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.strPre(destination, i, false);
                    operation = "STR r" + destination + ", [sp, #" + increment + "]";

                } else if (radioPost.isChecked() && !radioPreMod.isChecked() &&
                        !radioPre.isChecked() && !radioReg.isChecked()) {
                    int[] i = ac.decimalToUnsignedBinary(increment, 32);
                    ac.strPost(destination, i);
                    operation = "STR r" + destination + ", [sp], #" + increment;

                }

                Intent strIntent = new Intent();
                strIntent.putExtra(OPERATION_RESULT, operation);
                setResult(RESULT_OK, strIntent);
                finish();
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
