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

public class Sports_20_medium extends AppCompatActivity {
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
                "What cricketing term denotes a batsman being dismissed with a score of zero?", 4, "Bye", "Beamer", "Carry", "Duck"));

        qlist.add(new ComicsModel(
                "Which of these teams isn't a member of the NHL's 'Original Six' era?", 4, "New York Rangers", "Toronto Maple Leafs", "Boston Bruins", "Philadelphia Flyers"));

        qlist.add(new ComicsModel(
                "A stimpmeter measures the speed of a ball over what surface?", 4, " Football Pitch", "Cricket Outfield", "Pinball Table", "Golf Putting Green"));

        qlist.add(new ComicsModel(
                "How many scoring zones are there on a conventional dart board?", 1, "82", "62", "42", "102"));

        qlist.add(new ComicsModel(
                "The F1 season of 1994 is remembered for what tragic event?", 2, "The Showdown (Australia)", "Death of Ayrton Senna (San Marino)", "Verstappen on Fire (Germany)", "Schumacher's Ban (Britain)"));

        qlist.add(new ComicsModel(
                "Which car manufacturer won the 2016 24 Hours of Le Mans?", 2, "Toyota", "Porsche", "Audi", "Ferrari"));

        qlist.add(new ComicsModel(
                "Which soccer team won the Copa América 2015 Championship ?", 1, "Chile", "Argentina", "Brazil", "Paraguay"));

        qlist.add(new ComicsModel(
                "What is the oldest team in Major League Baseball?", 3, "Chicago Cubs", "Cincinnati Reds", "Atlanta Braves", "St. Louis Cardinals"));

        qlist.add(new ComicsModel(
                "In Formula 1, the Virtual Safety Car was introduced following the fatal crash of which driver?", 4, "Ayrton Senna", "Ronald Ratzenberger", "Gilles Villeneuve", "Jules Bianchi"));

        qlist.add(new ComicsModel(
                "Which portuguese island is soccer player Cristiano Ronaldo from?", 1, "Madeira", "Terceira", "Santa Maria", "Porto Santo"));

        qlist.add(new ComicsModel(
                "Who won the 2015 College Football Playoff (CFP) National Championship? ", 1, "Ohio State Buckeyes", "Alabama Crimson Tide", "Clemson Tigers", "Wisconsin Badgers"));

        qlist.add(new ComicsModel(
                "What year was hockey legend Wayne Gretzky born?", 4, "1965", "1959", "1963", "1961"));

        qlist.add(new ComicsModel(
                "Which of the following pitchers was named National League Rookie of the Year for the 2013 season?", 2, "Jacob deGrom", "Jose Fernandez", "Shelby Miller", "Matt Harvey"));

        qlist.add(new ComicsModel(
                "Which sport is NOT traditionally played during the Mongolian Naadam festival?", 4, "Wrestling", "Archery", "Horse-Racing", "American Football"));

        qlist.add(new ComicsModel(
                "In what sport does Fanny Chmelar compete for Germany?", 1, "Skiing", "Swimming", "Showjumping", "Gymnastics"));

        qlist.add(new ComicsModel(
                "How many French Open's did Björn Borg win?", 4, "4", "9", "2", "6"));

        qlist.add(new ComicsModel(
                "Who is Manchester United's top premier league goal scorer?", 1, "Wayne Rooney", "Sir Bobby Charlton", "Ryan Giggs", "David Beckham"));

        qlist.add(new ComicsModel(
                "Which professional wrestler fell from the rafters to his death during a live Pay-Per-View event in 1999?", 3, "Chris Benoit", "Lex Luger", "Owen Hart", "Al Snow"));

        qlist.add(new ComicsModel(
                "What is Tiger Woods' all-time best career golf-score?", 2, "65", "61", "63", "67"));

        qlist.add(new ComicsModel(
                "Which of these countries' national teams qualified for the 2018 FIFA World Cup in Russia?", 4, "United States of America", "Italy", "Netherlands", "Tunisia"));


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
            Intent intent  = new Intent(Sports_20_medium.this,MainActivity.class);
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
