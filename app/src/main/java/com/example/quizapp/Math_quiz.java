package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Math_quiz extends AppCompatActivity {

    int score;
    String finalScoresStr;

    RadioButton radioBtn, firstAns, secondAns, thirdAns, fourthAns, fifthAns;
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        firstAns = findViewById(R.id.question1_ans);
        secondAns = findViewById(R.id.question2_ans);
        thirdAns  = findViewById(R.id.question3_ans);
        fourthAns = findViewById(R.id.question4_ans);
        fifthAns = findViewById(R.id.question5_ans);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup5 = findViewById(R.id.radioGroup5);
        submit_btn = findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatingScores();
                finalScoresStr = score + " Pass";
                finalScoresStr = Integer.toString(score);
                Intent intent = new Intent(Math_quiz.this,Result_activity.class);
                intent.putExtra("SCORES",finalScoresStr);
                startActivity(intent);
                score = 0;
            }
        });
    }
    private void calculatingScores() {
        int question1 = radioGroup1.getCheckedRadioButtonId();
        radioBtn = findViewById(question1);
        if(radioBtn == firstAns){
            score ++ ;
        }
        int question2 = radioGroup2.getCheckedRadioButtonId();
        radioBtn = findViewById(question2);
        if (radioBtn == secondAns){
            score++;
        }
        int question3 = radioGroup3.getCheckedRadioButtonId();
        radioBtn = findViewById(question3);
        if(radioBtn == thirdAns){
            score ++ ;
        }
        int question4 = radioGroup4.getCheckedRadioButtonId();
        radioBtn = findViewById(question4);
        if(radioBtn == fourthAns){
            score ++ ;
        }
        int question5 = radioGroup5.getCheckedRadioButtonId();
        radioBtn = findViewById(question5);
        if(radioBtn == fifthAns){
            score ++ ;
        }
    }
}
