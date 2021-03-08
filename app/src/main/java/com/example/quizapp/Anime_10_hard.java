package com.example.quizgitfinale;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Anime_10_hard extends AppCompatActivity
{
    TextView qtext,qcount,qtimer;
    private List<ComicsModel> qlist;
    Button a,b,c,d;
    private int qno;
    int score;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
        qtext = findViewById(R.id.qtext);
        qcount = findViewById(R.id.qno);
        qtimer =  findViewById(R.id.time);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);


        qlist = new ArrayList<>();
        getData();
        score = 0;
    }

    private void getData() {

        qlist.add(new ComicsModel(
                "In the anime Initial D, how does Takumi Fujiwara describe a drift?", 3, "'. . . the wheels lose traction, making the car slide sideways'", "'. . . the car oversteers through a curve, causing it to turn faster'", "'. . . the front tires slide so the car won't face the inside'", "'. . . you turn a lot'"));

        qlist.add(new ComicsModel(
                "In the anime, Full Metal Panic!, who is Kaname's best friend?", 2, "Melissa Mao", "Kyoko Tokiwa", "Ren Mikihara", "Teletha 'Tessa' Testarossa"));

        qlist.add(new ComicsModel(
                "In 'Highschool of the Dead', where did Komuro and Saeko establish to meet after the bus explosion?", 4, "The Center Mall", "Komuro's House", "On The Main Bridge", "Eastern Police Station"));

        qlist.add(new ComicsModel(
                "Which of the following countries does 'JoJo's Bizarre Adventure: Stardust Crusaders' not take place in?", 4, "India", "Pakistan", "Egypt", "Philippines"));

        qlist.add(new ComicsModel(
                "What year was 'JoJo's Bizarre Adventure: Phantom Blood' first released?", 4, "2013", "1983", "1995", "1987"));

        qlist.add(new ComicsModel(
                "What is the last line muttered in the anime film 'The End of Evangelion'?", 3, "Idiot, I won't let you kill me!", "Nothing.", "How disgusting.", "Goddammit, Shinji."));

        qlist.add(new ComicsModel(
                "Winch of these names are not a character of JoJo's Bizarre Adventure?", 4, "Jean-Pierre Polnareff", "George Joestar", "Risotto Nero", "JoJo Kikasu"));

        qlist.add(new ComicsModel(
                "Which of these anime have over 7,500 episodes?", 2, "Naruto", "Sazae-san", "One Piece", "Chibi Maruko-chan"));

        qlist.add(new ComicsModel(
                "Which song was the callsign for Stefan Verdemann's KWFM radio station in Urasawa Naoki's 'Monster'?", 4, "What a Wonderful World", "When You Wish Upon A Star", "Singing In The Rain", "Over the Rainbow"));

        qlist.add(new ComicsModel(
                "Medaka Kurokami from 'Medaka Box' has what abnormality?", 2, "Perfection", "The End", "Sandbox", "Fairness"));


        setQuestion();
    }

    private void setQuestion() {

        qtimer.setText(String.valueOf(10));

        qtext.setText(qlist.get(0).getQuestion());
        a.setText(qlist.get(0).getA());
        b.setText(qlist.get(0).getB());
        c.setText(qlist.get(0).getC());
        d.setText(qlist.get(0).getD());

        qcount.setText("Question " +String.valueOf(1) + "/" + String.valueOf(qlist.size()) + ":");

        startTimer();
        qno=0;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(26000, 1000)            //Method for countdown timer, with countdown time and interval in miliseconds
        {
            public void onTick(long millisUntilFinished) {

                qtimer.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {

                changequestion();
            }


        };
        countDownTimer.start();
    }

    private void changequestion() {

        if (qno<qlist.size()-1)
        {
            qno++;
            playanimate(qtext,0,0);
            playanimate(a,0,1);
            playanimate(b,0,2);
            playanimate(c,0,3);
            playanimate(d,0,4);

            qcount.setText(String.valueOf(qno+1) + "/" + String.valueOf(qlist.size()));

            qtimer.setText(String.valueOf(10));

            startTimer();

        }
        else
        {
            Intent intent  = new Intent(Anime_10_hard.this,ScoreActivity.class);
            intent.putExtra("SCORE",String.valueOf(score));
            startActivity(intent);
        }
    }

    private void playanimate(View view, final int value, int switchnum) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(500).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        if (value==0)
                        {
                            switch(switchnum)
                            {
                                case 0:
                                    ((TextView)view).setText(qlist.get(qno).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(qlist.get(qno).getA());
                                    break;
                                case 2:
                                    ((Button)view).setText(qlist.get(qno).getB());
                                    break;
                                case 3:
                                    ((Button)view).setText(qlist.get(qno).getC());
                                    break;
                                case 4:
                                    ((Button)view).setText(qlist.get(qno).getD());
                                    break;



                            }
                            if(switchnum != 0)
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));


                            playanimate(view,1,switchnum);

                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }


    public void Buclick(View view) {

        int selectid = 0;

        switch (view.getId())
        {
            case R.id.a :
                selectid =1;
                break;
            case R.id.b :
                selectid =2;
                break;

            case R.id.c :
                selectid =3;
                break;

            case R.id.d :
                selectid =4;
                break;

            default:

        }
        countDownTimer.cancel();
        checkanswer(selectid,view);
    }

    private void checkanswer(int selectid ,View view) {

        if (selectid == qlist.get(qno).getAnswer())
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score = score + 100;
        }
        else
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            switch (qlist.get(qno).getAnswer())
            {
                case 1:
                    a.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    b.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    c.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    d.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
            score = score +0;
        }

        changequestion();
    }
}
