package com.example.lv.duplicateobserveddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private EditText startEditText;

    private EditText endEditText;

    private EditText lengthEditText;

    private Interval interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        interval = new Interval();
        interval.addObserver(this);
        update(interval, null);

        startEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    startFieldFocusLost();
                }
            }
        });
        endEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    endFieldFocusLost();
                }
            }
        });
        lengthEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    lengthFieldFocusLost();
                }
            }
        });
    }

    private void initViews() {
        startEditText = (EditText) findViewById(R.id.start_edit_text);
        endEditText = (EditText) findViewById(R.id.end_edit_text);
        lengthEditText = (EditText) findViewById(R.id.length_edit_text);
    }

    private void lengthFieldFocusLost() {
        setLength(Integer.parseInt(lengthEditText.getText().toString()));
    }

    private void endFieldFocusLost() {
        setEnd(Integer.parseInt(endEditText.getText().toString()));
    }

    private void startFieldFocusLost() {
        setStart(Integer.parseInt(startEditText.getText().toString()));
    }

    @Override
    public void update(Observable o, Object arg) {
        startEditText.setText(String.valueOf(interval.getStart()));
        endEditText.setText(String.valueOf(interval.getEnd()));
        lengthEditText.setText(String.valueOf(interval.getLength()));
    }

    private void setStart(int start) {
        interval.setStart(start);
    }

    private void setEnd(int end) {
        interval.setEnd(end);
    }

    private void setLength(int length) {
        interval.setLength(length);
    }
}
