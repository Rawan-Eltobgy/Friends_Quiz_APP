package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        CheckBox a11 = (CheckBox) findViewById(R.id.a11);
        CheckBox a12 = (CheckBox) findViewById(R.id.a12);
        CheckBox a13 = (CheckBox) findViewById(R.id.a13);
        CheckBox a14 = (CheckBox) findViewById(R.id.a14);
        RadioButton a23 = (RadioButton) findViewById(R.id.a23);
        RadioButton a32 = (RadioButton) findViewById(R.id.a32);
        RadioButton a44 = (RadioButton) findViewById(R.id.a44);
        EditText a51 = (EditText) findViewById(R.id.a5);
        String a5 = a51.getText().toString();
        int A5 = Integer.parseInt(a5);
        boolean A11 = a11.isChecked();
        boolean A12 = a12.isChecked();
        boolean A13 = a13.isChecked();
        boolean A14 = a14.isChecked();
        boolean A23 = a23.isChecked();
        boolean A32 = a32.isChecked();
        boolean A44 = a44.isChecked();
        int score = calculateScore(A11, A12, A13, A14, A23, A32, A44, A5);
        if (score == 5) {


            Toast.makeText(getApplicationContext(), "You're a true FRIENDS fan 5/5!", Toast.LENGTH_SHORT).show();
        } else if (score == 4) {

            Toast.makeText(getApplicationContext(), "I know that you know 4/5!", Toast.LENGTH_SHORT).show();
        } else if (score == 3) {

            Toast.makeText(getApplicationContext(), "OMG! 3/5!", Toast.LENGTH_SHORT).show();
        } else if (score == 2) {

            Toast.makeText(getApplicationContext(), "Don't be so proud 2/5!", Toast.LENGTH_SHORT).show();
        } else if (score == 1) {

            Toast.makeText(getApplicationContext(), "WE'RE ON A BREAK :(  1/5!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Are you even watching the show? 0/5", Toast.LENGTH_SHORT).show();

        }
    }

    private int calculateScore(boolean A11, boolean A12, boolean A13, boolean A14, boolean A23, boolean A32, boolean A44, int a5) {
        int baseScore = 0;
        if (A44) {
            baseScore++;
        }
        if (A32) {
            baseScore++;
        }
        if (A23) {
            baseScore++;
        }
        if ((A11 && !A12 && A13 && A14)) {
            baseScore++;
        }
        if (a5 == 20) {
            baseScore++;
        }
        return baseScore;
    }
}
