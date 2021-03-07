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

public class Sports_20_easy  extends AppCompatActivity {
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
                "Which of the following sports is not part of the triathlon?", 3, "Cycling", "Swimming", "Horse-Riding", "Running"));

        qlist.add(new ComicsModel(
                "In what sport is a 'shuttlecock' used?", 3, "Table Tennis", "Rugby", "Badminton", "Cricket"));

        qlist.add(new ComicsModel(
                "In baseball, how many fouls are an out?", 2, "5", "0", "3", "2"));

        qlist.add(new ComicsModel(
                "Which country will host the 2020 Summer Olympics?", 1, "Japan", "China", "Australia", "Germany"));

        qlist.add(new ComicsModel(
                "Which country has hosted the 2018 FIFA World Cup?", 3, "Germany", "United States", "Russia", "Saudi Arabia"));

        qlist.add(new ComicsModel(
                "Who won the 2015 Formula 1 World Championship?", 2, "Nico Rosberg", "Lewis Hamilton", "Sebastian Vettel", "Jenson Button"));

        qlist.add(new ComicsModel(
                "What was the final score of the Germany vs. Brazil 2014 FIFA World Cup match?", 2, "0 - 1", "7 - 1", "3 - 4", "16 - 0"));

        qlist.add(new ComicsModel(
                "How many points did LeBron James score in his first NBA game?", 4, "19", "69", "41", "25"));

        qlist.add(new ComicsModel(
                "What team won the 2016 MLS Cup?", 3, "Colorado Rapids", "Toronto FC", "Seattle Sounders", "Montreal Impact"));

        qlist.add(new ComicsModel(
                "What year did the New Orleans Saints win the Super Bowl?", 3, "2008", "2009", "2010", "2011"));

        qlist.add(new ComicsModel(
                "This Canadian television sportscaster is known for his 'Hockey Night in Canada' role, a commentary show during hockey games.", 2, "Don McKellar", "Don Cherry", "Don Taylor ", "Donald Sutherland"));

        qlist.add(new ComicsModel(
                "Which team has won the most Stanley Cups in the NHL?", 1, "Montreal Canadians", "Chicago Blackhawks", "Toronto Maple Leafs", "Detroit Red Wings"));

        qlist.add(new ComicsModel(
                "When was the first official international game played?", 2, "1880", "1872", "1863", "1865"));

        qlist.add(new ComicsModel(
                "Which boxer was banned for taking a bite out of Evander Holyfield's ear in 1997?", 2, "Roy Jones Jr.", "Mike Tyson", "Evander Holyfield", "Lennox Lewis"));

        qlist.add(new ComicsModel(
                "Which African American is in part responsible for integrating  Major League baseball?", 1, "Jackie Robinson", "Curt Flood", "Roy Campanella", "Satchell Paige"));

        qlist.add(new ComicsModel(
                "Who won the premier league title in the 2015-2016 season following a fairy tale run?", 2, "Tottenham Hotspur", "Leicester City", "Watford", "Stoke City"));

        qlist.add(new ComicsModel(
                "Which country will host the 2022 FIFA World Cup?", 1, "Qatar", "USA", "Japan", "Switzerland"));

        qlist.add(new ComicsModel(
                "Who won the UEFA Champions League in 2017?", 4, "Atletico Madrid", "AS Monaco FC", "Juventus F.C.", "Real Madrid C.F."));

        qlist.add(new ComicsModel(
                "In the 2014 FIFA World Cup, what was the final score in the match Brazil - Germany?", 2, "1-5", "1-7", "1-6", "2-6"));

        qlist.add(new ComicsModel(
                "Which two teams played in Super Bowl XLII?", 1, "The New York Giants & The New England Patriots", "The Green Bay Packers & The Pittsburgh Steelers", "The Philadelphia Eagles & The New England Patriots", "The Seattle Seahawks & The Denver Broncos"));



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
            Intent intent  = new Intent(Sports_20_easy.this,MainActivity.class);
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
