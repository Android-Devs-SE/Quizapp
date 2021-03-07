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

public class Music_20_medium extends AppCompatActivity {
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
                "What musician made the song 'Fuckin` Perfect' in 2010?", 2, "Mitis", "P!nk", "Adam lambert", "Koven"));

        qlist.add(new ComicsModel(
                "When did The Beatles release the LP 'Please Please Me'?", 2, "1970", "1963", "1960", "1969"));

        qlist.add(new ComicsModel(
                "Who is the lead singer of Bastille?", 4, "Will Farquarson", "Kyle Simmons", "Chris Wood", "Dan Smith"));

        qlist.add(new ComicsModel(
                "The song 'Caramelldansen' is commonly mistaken as a Japanese song, what language is the song actually sung in?", 1, "Swedish", "Hungarian", "Finnish", "Chinese"));

        qlist.add(new ComicsModel(
                "African-American performer Sammy Davis Jr. was known for losing which part of his body in a car accident?", 3, "Right Ear", "Right Middle Finger", "Left Eye", "Nose"));

        qlist.add(new ComicsModel(
                "Which member of 'The Beatles' narrated episodes of 'Thomas the Tank Engine'?", 4, "George Harrison", "John Lennon", "Paul McCartney", "Ringo Starr"));

        qlist.add(new ComicsModel(
                "Who was the lead singer and frontman of rock band R.E.M?", 3, "Chris Martin", "Thom Yorke", "Michael Stipe", "George Michael"));

        qlist.add(new ComicsModel(
                "Moby, an American DJ, singer, and musician, achieved worldwide success for the 1999 release of which of the following albums?", 3, "Everything Is Wrong", "Moby", "Play", "18"));

        qlist.add(new ComicsModel(
                "What was the name of Pink Floyd's first studio album?", 1, "The Piper at the Gates of Dawn", "Ummagumma", "More", "Atom Heart Mother"));

        qlist.add(new ComicsModel(
                "Which of these songs did Jimi Hendrix cover?", 4, "Sgt. Pepper's Lonely Hearts Club Band", "All Along the Watchtower", "House of the Rising Sun", "All of these songs"));

        qlist.add(new ComicsModel(
                "Which Iron Maiden album did the song 'Dream of Mirrors' feature in?", 2, "Dance of Death", "Brave New World", "A Matter of Life and Death", "Somewhere in Time"));

        qlist.add(new ComicsModel(
                "The 'In the Flesh' tour was used in support of what Pink Floyd album?", 1, "Animals", "The Wall", "Wish You Were Here", "The Final Cut"));

        qlist.add(new ComicsModel(
                "Who released the 1991 album 'Out of Time'?", 1, "R.E.M.", "U2", "Coldplay", "The Rolling Stones"));

        qlist.add(new ComicsModel(
                "According to the RIAA: Which artist has sold the most albums by the million?", 4, "Elvis Presley", "Michael Jackson", "Pink Floyd", "The Beatles"));

        qlist.add(new ComicsModel(
                "Which novelty band was best known for their UK chart hits 'Combine Harvester' and 'I Am a Cider Drinker' in 1976?", 1, "The Wurzels", "Goldie Lookin Chain", "Bonzo Dog Doo-Dah Band", "The Firm"));

        qlist.add(new ComicsModel(
                "Which Aerosmith album featured 'Walk This Way'?", 4, "Rocks", "Get Your Wings", "Draw the Line", "Toys in the Attic"));

        qlist.add(new ComicsModel(
                "What was Bon Iver's debut album released in 2007?", 2, "Bon Iver, Bon Iver", "For Emma, Forever Ago", "22, A Million", "Blood Bank EP"));

        qlist.add(new ComicsModel(
                "What song on ScHoolboy Q's album Black Face LP featured Kanye West?", 4, "Neva CHange", "Big Body", "Blank Face", "THat Part"));

        qlist.add(new ComicsModel(
                "'The Genius' is the original and secondary name of which Wu-Tang Clan member?", 4, "Ghostface Killah", "Ol' Dirty Bastard", "Raekwon the Chef", "GZA"));

        qlist.add(new ComicsModel(
                "In what year was Tchaikovsky's 1812 Overture composed?", 1, "1880", "1812", "1790", "1840"));


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
            Intent intent  = new Intent(Music_20_medium.this,MainActivity.class);
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
