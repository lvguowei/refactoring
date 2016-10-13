package com.example.lv.duplicateobserveddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText startEditText;

    private EditText endEditText;

    private EditText lengthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEditText = (EditText) findViewById(R.id.start_edit_text);
        endEditText = (EditText) findViewById(R.id.end_edit_text);
        lengthEditText = (EditText) findViewById(R.id.length_edit_text);

        startEditText.setText("0");
        endEditText.setText("0");
        lengthEditText.setText("0");

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

    private void lengthFieldFocusLost() {
        calculateEnd();
    }

    private void endFieldFocusLost() {
        calculateLength();
    }

    private void startFieldFocusLost() {
        calculateLength();
    }

    private void calculateLength() {
        int start = Integer.parseInt(startEditText.getText().toString());
        int end = Integer.parseInt(endEditText.getText().toString());
        int length = end - start;
        lengthEditText.setText(String.valueOf(length));
    }

    private void calculateEnd() {
        int start = Integer.parseInt(startEditText.getText().toString());
        int length = Integer.parseInt(lengthEditText.getText().toString());
        endEditText.setText(String.valueOf(start + length));
    }
}
