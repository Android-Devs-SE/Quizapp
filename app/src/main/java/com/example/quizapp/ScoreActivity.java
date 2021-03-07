package com.example.quizgitfinale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {


    TextView ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ts = findViewById(R.id.score);
        String score = getIntent().getStringExtra("SCORE");
        ts.setText(score);



    }
}