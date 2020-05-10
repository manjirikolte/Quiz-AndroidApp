package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Science_quiz extends AppCompatActivity {

    int score;
    String finalScoresStr = "0";
    RadioButton radioBtn, firstAns, secondAns, thirdAns, fourthAns, fifthAns;
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    CheckBox checkBoxAns1, checkBoxAns2, checkBoxAns3, checkBoxOpt;
    Button submit_btn;
    EditText science_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_quiz);

        firstAns = findViewById(R.id.question1_ans);
        secondAns = findViewById(R.id.question2_ans);
        thirdAns = findViewById(R.id.question3_ans);
        fourthAns = findViewById(R.id.question4_ans);
        fifthAns = findViewById(R.id.question5_ans);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup5 = findViewById(R.id.radioGroup5);
        submit_btn = findViewById(R.id.submit_btn);
        science_et = findViewById(R.id.science_et);
        checkBoxAns1 = findViewById(R.id.question7_ans1);
        checkBoxAns2 = findViewById(R.id.question7_ans2);
        checkBoxAns3 = findViewById(R.id.question7_ans3);
        checkBoxOpt = findViewById(R.id.question7_opt);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatingScores();
                finalScoresStr = Integer.toString(score);
                Intent intent = new Intent(Science_quiz.this, Result_activity.class);
                intent.putExtra("SCORES", finalScoresStr);
                intent.putExtra("SCIENCE", "ScienceMarks");
                startActivity(intent);
                score = 0;
            }
        });
    }

    private void calculatingScores() {
        int question1 = radioGroup1.getCheckedRadioButtonId();
        radioBtn = findViewById(question1);
        if (radioBtn == firstAns) {
            score++;
        }
        int question2 = radioGroup2.getCheckedRadioButtonId();
        radioBtn = findViewById(question2);
        if (radioBtn == secondAns) {
            score++;
        }
        int question3 = radioGroup3.getCheckedRadioButtonId();
        radioBtn = findViewById(question3);
        if (radioBtn == thirdAns) {
            score++;
        }
        int question4 = radioGroup4.getCheckedRadioButtonId();
        radioBtn = findViewById(question4);
        if (radioBtn == fourthAns) {
            score++;
        }
        int question5 = radioGroup5.getCheckedRadioButtonId();
        radioBtn = findViewById(question5);
        if (radioBtn == fifthAns) {
            score++;
        }
        String editTextAnswer = science_et.getText().toString().trim();
        if (editTextAnswer.equalsIgnoreCase("H2O")) {
            score = score + 2;
        }
        if (checkBoxAns1.isChecked() && checkBoxAns2.isChecked() && checkBoxAns3.isChecked() && !checkBoxOpt.isChecked()) {
            score = score + 3;
        }
    }
}