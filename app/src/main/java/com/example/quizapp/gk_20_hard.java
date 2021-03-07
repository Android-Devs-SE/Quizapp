package com.example.quizgitfinale;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.List;

public class gk_20_hard extends AppCompatActivity {

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
                "What type of dog is 'Handsome Dan', the mascot of Yale University?", 1, "Bulldog", "Yorkshire Terrier", "Boxer", "Pug"));

        qlist.add(new ComicsModel(
                "Which of the following is not another name for the eggplant?", 2, "Brinjal", "Potimarron", "Guinea Squash", "Melongene"));

        qlist.add(new ComicsModel(
                "What is the romanized Chinese word for 'airplane'?", 2, "Qiche", "Feiji", "Zongxian", "Huojian"));

        qlist.add(new ComicsModel(
                "What is the romanized Korean word for 'heart'?", 3, "Aejeong", "Jeongsin", "Simjang", "Segseu"));

        qlist.add(new ComicsModel(
                "Which musician has collaborated with American producer Porter Robinson and released the 2016 song 'Shelter'?", 2, "Mat Zo", "Madeon", "deadmau5", "Zedd"));

        qlist.add(new ComicsModel(
                "Which of the following languages does NOT use gender as a part of its grammar?", 1, "Turkish", "German", "Danish", "Polish"));

        qlist.add(new ComicsModel(
                "Which one of these Swedish companies was founded in 1943?", 1, "IKEA", "H & M", "Lindex", "Clas Ohlson"));

        qlist.add(new ComicsModel(
                "How many calories are in a 355 ml can of Pepsi Cola?", 4, "200", "100", "155", "150"));

        qlist.add(new ComicsModel(
                "De Eemhof, Port Zelande and Het Heijderbos are holiday villas owned by what company?", 3, "Yelloh Village", "Keycamp", "Center Parcs", "Villa Plus"));

        qlist.add(new ComicsModel(
                "What year was the RoboSapien toy robot released?", 2, "2000", "2004", "2001", "2006"));

        qlist.add(new ComicsModel(
                "Virtual reality company Oculus VR lost which of it's co-founders in a freak car accident in 2013?", 1, "Andrew Scott Reisse", "Nate Mitchell", "Jack McCauley", "Palmer Luckey"));

        qlist.add(new ComicsModel(
                "Who founded the Khan Academy?", 2, "Ben Khan", "Sal Khan", "Kitt Khan", "Adel Khan"));

        qlist.add(new ComicsModel(
                "If someone said 'you are olid', what would they mean?", 1, "You smell extremely unpleasant.", "You are out of shape/weak.", "Your appearance is repulsive.", "You are incomprehensible/an idiot."));

        qlist.add(new ComicsModel(
                "Named after the mallow flower, mauve is a shade of what?", 1, "Purple", "Red", "Brown", "Pink"));

        qlist.add(new ComicsModel(
                "Chartreuse is a color between yellow and what?", 4, "Red", "Black", "Purple", "Green"));

        qlist.add(new ComicsModel(
                "Nephelococcygia is the practice of doing what?", 4, "Sleeping with your eyes open", "Breaking glass with your voice", "Swimming in freezing water", "Finding shapes in clouds"));

        qlist.add(new ComicsModel(
                "Which church's interior in Vatican City was designed in 1503 by renaissance architects including Bramante, Michelangelo and Bernini?", 3, "Catania Cathedral", "St. Mark’s Basilica", "St. Peter's Basilica", "The Duomo of Florence"));

        qlist.add(new ComicsModel(
                "What is the most commonly used noun in the English language?", 2, "Home", "Time", "Water", "Man"));

        qlist.add(new ComicsModel(
                "Which of the following  British Monarchs never appeared on a circulated pound sterling coin?", 2, "Victoria", "Edward VIII", "George VI", "Charles II"));

        qlist.add(new ComicsModel(
                "In 'Resident Evil 3', how many inventory slots does Jill have at the start of the game?", 2, "6", "10", "8", "12"));


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
            Intent intent  = new Intent(gk_20_hard.this,MainActivity.class);
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