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

public class Sports_20_hard extends AppCompatActivity {
    TextView qtext,qcount,qtimer;
    private List<ComicsModel> qlist;
    Button a,b,c,d;
    private int qno;
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
    }

    private void getData() {

        qlist.add(new ComicsModel(
                "How many times did Martina Navratilova win the Wimbledon Singles Championship?", 1, "Nine", "Ten", "Seven", "Eight"));

        qlist.add(new ComicsModel(
                "What tool lends it's name to a last-stone advantage in an end in Curling?", 1, "Hammer", "Wrench", "Drill", "Screwdriver"));

        qlist.add(new ComicsModel(
                "With which doubles partner did John McEnroe have most success?", 4, "Mark Woodforde", "Michael Stich", "Mary Carillo", "Peter Fleming"));

        qlist.add(new ComicsModel(
                "Where was the Games of the XXII Olympiad held?", 4, "Barcelona", "Tokyo", "Los Angeles", "Moscow"));

        qlist.add(new ComicsModel(
                "Which car company is the only Japanese company which won the 24 Hours of Le Mans?", 4, "Toyota", "Subaru", "Nissan", "Mazda"));

        qlist.add(new ComicsModel(
                "Which Italian footballer told Neuer where he's putting his shot and dragging it wide, during the match Italy-Germany, UEFA EURO 2016?", 1, "Pelle", "Insigne", "Barzagli", "Giaccherini"));

        qlist.add(new ComicsModel(
                "Which male player won the gold medal of table tennis singles in 2016 Olympics Games?", 1, "Ma Long (China)", "Zhang Jike (China)", "Jun Mizutani (Japan)", "Vladimir Samsonov (Belarus)"));

        qlist.add(new ComicsModel(
                "Which female player won the gold medal of table tennis singles in 2016 Olympics Games?", 2, "LI Xiaoxia (China)", "DING Ning (China)", "Ai FUKUHARA (Japan)", "Song KIM (North Korea)"));

        qlist.add(new ComicsModel(
                "What is the full name of the footballer 'Cristiano Ronaldo'?", 3, "Cristiano Ronaldo los Santos Diego", "Cristiano Armando Diego Ronaldo", "Cristiano Ronaldo dos Santos Aveiro", "Cristiano Luis Armando Ronaldo"));

        qlist.add(new ComicsModel(
                "Which year was the third Super Bowl held?", 2, "1968", "1969", "1971", "1970"));

        qlist.add(new ComicsModel(
                "What team did England beat in the semi-final stage to win in the 1966 World Cup final?", 2, "West Germany", "Portugal", "Soviet Union", "Brazil"));

        qlist.add(new ComicsModel(
                "Which city features all of their professional sports teams' jersey's with the same color scheme?", 3, "New York", "Seattle", "Pittsburgh", "Tampa Bay"));

        qlist.add(new ComicsModel(
                "Which player 'kung-fu kicked' a Crystal Palace fan in January 1995?", 4, "David Seamen", "Ashley Cole", "Mark Hughes", "Eric Cantona"));

        qlist.add(new ComicsModel(
                "Who is Manchester United's leading appearance maker?", 4, "David Beckham", "Wayne Rooney", "Eric Cantona", "Ryan Giggs"));

        qlist.add(new ComicsModel(
                "The Mazda 787B won the 24 Hours of Le Mans in what year?", 4, "1990", "2000", "1987", "1991"));

        qlist.add(new ComicsModel(
                "What is “The Sport of Kings”?", 4, "Chess", "Jousting", "Fencing", "Horse Racing"));

        qlist.add(new ComicsModel(
                "Which of these Russian cities did NOT contain a stadium that was used in the 2018 FIFA World Cup?", 2, "Rostov-on-Don", "Vladivostok", "Yekaterinburg", "Kaliningrad"));

        qlist.add(new ComicsModel(
                "In Canadian football, scoring a rouge is worth how many points?", 4, "2", "3", "4", "1"));

        qlist.add(new ComicsModel(
                "The AHL affiliate team of the Boston Bruins is named what?", 1, "Providence Bruins", "New Haven Bruins", "Cambridge Bruins", "Hartford Bruins"));

        qlist.add(new ComicsModel(
                "Which English football team is nicknamed 'The Tigers'?", 2, "Cardiff City", "Hull City", "Bristol City", "Manchester City"));


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
        countDownTimer = new CountDownTimer(11000, 1000)            //Method for countdown timer, with countdown time and interval in miliseconds
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
            Intent intent  = new Intent(Sports_20_hard.this,MainActivity.class);
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
            case R.id.b :
                selectid =2;

            case R.id.c :
                selectid =3;

            case R.id.d :
                selectid =4;

            default:
                selectid = 0;
        }
        countDownTimer.cancel();
        checkanswer(selectid,view);
    }

    private void checkanswer(int selectid ,View view) {

        if (selectid == qlist.get(qno).getAnswer())
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

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
        }

        changequestion();
    }
}
