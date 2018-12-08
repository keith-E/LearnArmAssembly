package com.learnassembly.learnarmassembly;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ExecuteArmCode  {

    private Map<Integer, ArmCode> mCodeMap;
    private int mPosition;
    private Context context;

    public ExecuteArmCode(Context context, Map<Integer, ArmCode> code) {
        this.context = context;
        mCodeMap = code;
        mPosition = 1;
    }

    public void playCode() {
        while(mPosition <= mCodeMap.size()) {
            ArmCode lineOfCode = mCodeMap.get(mPosition);
            if(lineOfCode != null) {
                highlightEditorLine();
                processLine(lineOfCode);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    // do nothing
//                }
//                deHighlightEditorLine();
            }
            mPosition++;
        }
    }

    public void stepCode() {

    }

    public void stopCode() {

    }

    private void processLine(ArmCode lineOfCodeToProcess) {
        if(lineOfCodeToProcess instanceof Label) {


        }
    }

    private void highlightEditorLine() {
        TextView editorLine;
        switch(mPosition) {
            case 1:
                editorLine =(TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_one_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 2:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_two_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 3:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_three_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 4:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_four_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 5:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_five_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 6:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_six_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 7:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_seven_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 8:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_eight_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 9:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_nine_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 10:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_ten_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 11:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_eleven_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 12:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_twelve_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 13:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_thirteen_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 14:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_fourteen_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
            case 15:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_fifteen_contents);
                editorLine.setHighlightColor(Color.YELLOW);
                break;
        }
    }
    private void deHighlightEditorLine() {
        TextView editorLine;
        switch(mPosition) {
            case 1:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_one_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 2:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_two_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 3:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_three_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 4:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_four_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 5:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_five_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 6:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_six_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 7:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_seven_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 8:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_eight_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 9:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_nine_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 10:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_ten_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 11:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_eleven_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 12:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_twelve_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 13:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_thirteen_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 14:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_fourteen_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
            case 15:
                editorLine = (TextView) ((Activity)context).findViewById(R.id.textview_main_editor_line_fifteen_contents);
                editorLine.setHighlightColor(Color.WHITE);
                break;
        }
    }
}
