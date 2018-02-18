package com.example.android.quiz;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int countScore = 0;
    int currentColor;
    ArrayList<Integer> radioButtensList = new ArrayList<>();
    ArrayList<Integer> checkBoxList = new ArrayList<>();
    ArrayList<Integer> editTextList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radioButton = findViewById(R.id.q1rb1);
        currentColor = radioButton.getCurrentTextColor();
    }

    public void checkAnswers(View view) {

        //Question 1
        badRadioButton(R.id.q1rb1);
        goodRadioButton(R.id.q1rb2);
        badRadioButton(R.id.q1rb3);
        badRadioButton(R.id.q1rb4);

        //Question 2
        badRadioButton(R.id.q2rb1);
        badRadioButton(R.id.q2rb2);
        goodRadioButton(R.id.q2rb3);
        badRadioButton(R.id.q2rb4);

        //Question 3
        checkAnswerText(R.id.q3et1, "3");

        //Question 4
        boolean q4a1 = checkBoxState(R.id.q4ch1, true);
        boolean q4a2 = checkBoxState(R.id.q4ch2, false);
        boolean q4a3 = checkBoxState(R.id.q4ch3, true);
        boolean q4a4 = checkBoxState(R.id.q4ch4, false);

        if (q4a1 && !q4a2 && q4a3 && !q4a4) {
            countScore += 1;
        }

        //Question 5
        badRadioButton(R.id.q5rb1);
        badRadioButton(R.id.q5rb2);
        goodRadioButton(R.id.q5rb3);
        badRadioButton(R.id.q5rb4);

        //Question 6
        badRadioButton(R.id.q6rb1);
        goodRadioButton(R.id.q6rb2);
        badRadioButton(R.id.q6rb3);
        badRadioButton(R.id.q6rb4);

        //Question 7
        checkAnswerText(R.id.q7et1, "0");

        //Question 8
        boolean q8a1 = checkBoxState(R.id.q8ch1, true);
        boolean q8a2 = checkBoxState(R.id.q8ch2, true);
        boolean q8a3 = checkBoxState(R.id.q8ch3, true);
        boolean q8a4 = checkBoxState(R.id.q8ch4, false);

        if (q8a1 && q8a3 && q8a2 && !q8a4) {
            countScore += 1;
        }

        Toast.makeText(getApplicationContext(), "Your score is " + countScore + " out of 8",
                Toast.LENGTH_LONG).show();

        countScore = 0;

    }

    private boolean checkBoxState(int id, boolean isTrue) {
        CheckBox checkBox = findViewById(id);
        boolean checked = checkBox.isChecked();
        if (isTrue) {
            checkBox.setTextColor(Color.parseColor("#43a047"));
        } else if (checked) {
            checkBox.setTextColor(Color.RED);
        }
        checkBoxList.add(id);
        return checked;
    }

    private void goodRadioButton(int id) {
        RadioButton radioButton = findViewById(id);
        radioButton.setTextColor(Color.parseColor("#43a047"));
        if (radioButton.isChecked()) {
            countScore += 1;
        }
        radioButtensList.add(id);
    }

    private void badRadioButton(int id) {
        RadioButton radioButton = findViewById(id);
        if (radioButton.isChecked()) {
            radioButton.setTextColor(Color.RED);
        }
        radioButtensList.add(id);
    }

    private void checkAnswerText(int id, String trueAnswer) {
        EditText answerView = findViewById(id);
        String answer = answerView.getText().toString();
        if (answer.equals(trueAnswer)) {
            countScore += 1;
            answerView.setTextColor(Color.parseColor("#43a047"));
        } else {
            answerView.setTextColor(Color.RED);
            answerView.setText("Incorrect: " + answer + ". Correct: " + trueAnswer);
        }
        editTextList.add(id);
    }

    public void reset(View v) {

        for (int id : radioButtensList) {
            RadioButton radioButton = findViewById(id);
            radioButton.setChecked(false);
            radioButton.setTextColor(currentColor);
        }

        for (int id : checkBoxList) {
            CheckBox checkBox = findViewById(id);
            checkBox.setChecked(false);
            checkBox.setTextColor(currentColor);
        }

        for (int id : editTextList) {
            EditText answerView = findViewById(id);
            answerView.setText("");
            answerView.setTextColor(currentColor);
        }
    }
}
