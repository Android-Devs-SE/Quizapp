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

public class Music_20_easy extends AppCompatActivity {
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
                "Who is the lead singer of the British pop rock band Coldplay?", 4, "Jonny Buckland", "Guy Berryman", "Will Champion", "Chris Martin"));

        qlist.add(new ComicsModel(
                "Which brass instrument has the lowest pitch in an orchestra?", 3, "Trumpet", "Saxophone", "Tuba", "Trombone"));

        qlist.add(new ComicsModel(
                "Brian May was the guitarist for which band?", 4, "Pink Floyd", "Rolling Stones", "The Doors", "Queen"));

        qlist.add(new ComicsModel(
                "What was the subject of the 2014 song 'CoCo' by American rapper O. T. Genasis?", 1, "Cocaine", "Conan O'Brien", "Cobalt(II) carbonate", "Coconut cream pie"));

        qlist.add(new ComicsModel(
                "Which band released songs suchs as 'Rio', 'Girls on Film', and 'The Reflex'?", 3, "The Cure", "New Order", "Duran Duran", "Depeche Mode"));

        qlist.add(new ComicsModel(
                "The 2016 song 'Starboy' by Canadian singer The Weeknd features which prominent electronic artist?", 4, "deadmau5", "Disclosure", "DJ Shadow", "Daft Punk"));

        qlist.add(new ComicsModel(
                "Which 80s band is fronted by singer/guitarist Robert Smith?", 3, "The Smiths", "Echo & the Bunnymen", "The Cure", "New Order"));

        qlist.add(new ComicsModel(
                "What album did The Lumineers release in 2016?", 1, "Cleopatra", "Winter", "The Lumineers", "Tracks From The Attic"));

        qlist.add(new ComicsModel(
                "Which band recorded the album 'Parallel Lines'?", 3, "Paramore", "Coldplay", "Blondie", "The Police"));

        qlist.add(new ComicsModel(
                "The band Muse released their first album, Showbiz, in what year?", 1, "1999", "1998", "2000", "2001"));

        qlist.add(new ComicsModel(
                "Which group performs the song 'Crash into Me'?", 2, "Phish", "Dave Matthews Band", "The Grateful Dead", "Destiny's Child"));

        qlist.add(new ComicsModel(
                "What 1970's American ballad referred to the 1959 plane crash as the 'the day the music died'?", 4, "Kentucky Rain", "I Will Always Love You", "Rock 'n' Roll Suicide", "American Pie"));

        qlist.add(new ComicsModel(
                "Whose albums included 'Back in Black' and 'Ballbreaker'?", 1, "AC/DC", "Iron Maiden", "Black Sabbath", "Metallica"));

        qlist.add(new ComicsModel(
                "Who was 'Kung Fu Fighting' in 1974?", 4, "The Bee Gees", "Heatwave", "Kool & the Gang", "Carl Douglas"));

        qlist.add(new ComicsModel(
                "Which music publication is often abbreviated to NME?", 2, "New Metro Entertainment", "New Musical Express", "Next Musical Enterprise", "North Manchester Express"));

        qlist.add(new ComicsModel(
                "What Led Zeppelin album contains 'Stairway to Heaven'?", 4, "Houses of the Holy", "Physical Graffiti", "Led Zeppelin III", "Led Zeppelin IV"));

        qlist.add(new ComicsModel(
                "'Hallelujah' is a song written by which Canadian recording artist?", 2, "Kory Lefkowits", "Leonard Cohen", "Ryan Letourneau ", "Justin Bieber "));

        qlist.add(new ComicsModel(
                "The Rush song 'YYZ' derives its name from the IATA aiport identification code for which city?", 2, "Vancouver", "Toronto", "Ottowa", "Calgary"));

        qlist.add(new ComicsModel(
                "Who is the lead singer of Foo Fighters?", 1, "Dave Grohl", "Dave Mustaine", "James Hetfield", "Little Red Riding Hood"));

        qlist.add(new ComicsModel(
                "Which year was the album 'Year of the Snitch' by Death Grips released?", 1, "2018", "2013", "2017", "2011"));


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
            Intent intent  = new Intent(Music_20_easy.this,MainActivity.class);
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
