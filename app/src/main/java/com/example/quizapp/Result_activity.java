package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result_activity extends AppCompatActivity {
    TextView score_tv, message_tv, outOf_tv;
    Button exit_btn, list_btn;

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        score_tv = findViewById(R.id.score);
        exit_btn = findViewById(R.id.exit_btn);
        list_btn = findViewById(R.id.list_btn);
        message_tv = findViewById(R.id.message_tv);
        outOf_tv = findViewById(R.id.outOf_tv);

        Intent intent = getIntent();
        String scores = intent.getStringExtra("SCORES");
        String scienceMarks = intent.getStringExtra("SCIENCE");

        if (scores != null) {
            score = Integer.parseInt(scores);
            if (score > 3) {
                message_tv.setText(R.string.oh_yeah);
            }
        }
        if (scienceMarks != null) {
            outOf_tv.setText(R.string._10);
        }
        if(score >= 3){
            Toast.makeText(getApplicationContext(), " You passed the Quiz with score " + score, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), " You failed with score " + score, Toast.LENGTH_SHORT).show();
        }

        score_tv.setText(scores);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result_activity.this, Quiz_list.class);
                startActivity(intent);
            }
        });
    }
}