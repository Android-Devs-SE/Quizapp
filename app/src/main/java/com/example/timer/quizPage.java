package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quizPage extends AppCompatActivity {
    Intent intent = getIntent();
    public int k;
    public int i = 30;       //Created a counter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        TextView timer = findViewById(R.id.timer);
        TextView pts = findViewById(R.id.points);
        Button a = findViewById(R.id.btnRight);
        Button b = findViewById(R.id.btnWrong);

        CountDownTimer cd = new CountDownTimer(30000,1000)            //Method for countdown timer, with countdown time and interval in miliseconds
    {
        public void onTick(long millisUntilFinished)
        {
            timer.setText(String.valueOf(i));

            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    k =(int) (millisUntilFinished/1000 +1);   // Points counter
                    b.setEnabled(false);
                    pts.setText(Integer.toString(k)); // Printing the points scored
                    cancel();
                }
            });
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    k = 0;
                    a.setEnabled(false);
                    pts.setText(Integer.toString(k));
                    cancel();
                }
            });
            i--; //Time counter

        }

        @Override
        public void onFinish() {
             timer.setText("Time over");
        }
    }.start();
    }
}