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

public class gk_20_medium extends AppCompatActivity {

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
                "What does a milliner make and sell?", 2, "Shoes", "Hats", "Belts", "Shirts"));

        qlist.add(new ComicsModel(
                "What is the defining characteristic of someone who is described as hirsute?", 3, "Rude", "Funny", "Hairy", "Tall"));

        qlist.add(new ComicsModel(
                "A doctor with a PhD is a doctor of what?", 4, "Psychology", "Phrenology", "Physical Therapy", "Philosophy"));

        qlist.add(new ComicsModel(
                "What is the unit of currency in Laos?", 4, "Ruble", "Konra", "Dollar", "Kip"));

        qlist.add(new ComicsModel(
                "What is the name given to Indian food cooked over charcoal in a clay oven?", 3, "Biryani", "Pani puri", "Tandoori", "Tiki masala"));

        qlist.add(new ComicsModel(
                "What is the romanized Japanese word for 'university'?", 2, "Toshokan", "Daigaku", "Jimusho", "Shokudou"));

        qlist.add(new ComicsModel(
                "What is the romanized Russian word for 'winter'?", 3, "Leto", "Vesna", "Zima", "Osen'"));

        qlist.add(new ComicsModel(
                "On average, Americans consume 100 pounds of what per second?", 3, "Potatoes", "Donuts", "Chocolate", "Cocaine"));

        qlist.add(new ComicsModel(
                "When was Nintendo founded?", 3, "October 19th, 1891", "March 4th, 1887", "September 23rd, 1889", "December 27th, 1894"));

        qlist.add(new ComicsModel(
                "In what year was McDonald's founded?", 2, "1964", "1955", "1951", "1947"));

        qlist.add(new ComicsModel(
                "When was Hubba Bubba first introduced?", 4, "1984", "1972", "1980", "1979"));

        qlist.add(new ComicsModel(
                "What is the Portuguese word for 'Brazil'?", 1, "Brasil", "Brazil", "Brasilia", "Brasíl"));

        qlist.add(new ComicsModel(
                "When did the website 'Facebook' launch?", 2, "2005", "2004", "2003", "2006"));

        qlist.add(new ComicsModel(
                "Who invented Pastafarianism?", 3, "Eric Tignor", "Bill Nye", "Bobby Henderson", "Zach Soldi"));

        qlist.add(new ComicsModel(
                "Which slogan did the fast food company, McDonald's, use before their 'I'm Lovin' It' slogan?", 3, "Why Pay More!?", "Have It Your Way", "We Love to See You Smile", "Making People Happy Through Food"));

        qlist.add(new ComicsModel(
                "The website 'Shut Up & Sit Down' reviews which form of media?", 4, "Television Shows", "Video Games", "Films", "Board Games"));

        qlist.add(new ComicsModel(
                "Where did the pineapple plant originate?", 3, "Hawaii", "Europe", "South America", "Asia"));

        qlist.add(new ComicsModel(
                "Which country drives on the left side of the road?", 4, "Germany", "Russia", "China", "Japan"));

        qlist.add(new ComicsModel(
                "What is the star sign of someone born on Valentines day?", 1, "Aquarius", "Pisces", "Capricorn", "Scorpio"));

        qlist.add(new ComicsModel(
                "Frank Lloyd Wright was the architect behind what famous building?", 3, "Villa Savoye", "Sydney Opera House", "The Guggenheim", "The Space Needle"));



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
            Intent intent  = new Intent(gk_20_medium.this,MainActivity.class);
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
