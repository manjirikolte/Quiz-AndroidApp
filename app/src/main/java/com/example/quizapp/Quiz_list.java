package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Quiz_list extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

    }
    public void jumpToQuiz(View view) {
        switch (view.getId()) {
            case R.id.history_btn:
                intent = new Intent(Quiz_list.this, History_quiz.class);
                break;
            case R.id.gk_btn:
                intent = new Intent(Quiz_list.this, GK_quiz.class);
                break;
            case R.id.fun_btn:
                intent = new Intent(Quiz_list.this, Fun_quiz.class);
                break;
            case R.id.math_btn:
                intent = new Intent(Quiz_list.this, Math_quiz.class);
                break;
            case R.id.science_btn:
                intent = new Intent(Quiz_list.this, Science_quiz.class);
                break;
            default:
                Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
                break;
        }
        startActivity(intent);
    }
}