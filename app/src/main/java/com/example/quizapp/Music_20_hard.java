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

public class Music_20_hard extends AppCompatActivity {
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
                "On which Beatles album would you find the song 'Eleanor Rigby'?", 3, "Help!", "Rubber Soul", "Revolver", "Abbey Road"));

        qlist.add(new ComicsModel(
                "Who was not in the band 'The Smiths'?", 3, "Morrissey", "Andy Rourke", "Martin Chambers", "Mike Joyce"));

        qlist.add(new ComicsModel(
                "Which of these aliases has NOT been used by electronic musician Aphex Twin?", 4, "Caustic Window", "Bradley Strider", "GAK", "Burial"));

        qlist.add(new ComicsModel(
                "Which band is the longest active band in the world with no breaks or line-up changes?", 4, "Radiohead", "Rush", "Rolling Stones", "U2"));

        qlist.add(new ComicsModel(
                "Which of these is NOT a song featured on the Lockjaw EP released in 2013 by Flume & Chet Faker?", 2, "What About Us", "Left Alone", "This Song Is Not About A Girl", "Drop The Game"));

        qlist.add(new ComicsModel(
                "Which Death Grips album is the only one to feature a band member?", 2, "Bottomless Pit", "No Love Deep Web", "The Money Store", "The Powers That B"));

        qlist.add(new ComicsModel(
                "Which of the following is NOT a real song from the band Thousand Foot Krutch?", 2, "Let The Sparks Fly", "Limitless Fury", "Down", "Give Up The Ghost"));

        qlist.add(new ComicsModel(
                "In Kendrick Lamar's 2012 album, 'Good Kid, M.A.A.D City', the album's story takes place in which city?", 3, "Detroit", "New York", "Compton", "Baltimore"));

        qlist.add(new ComicsModel(
                "This album, now considered to be one of the greatest of all time, was a commercial failure when it was released.", 3, "Abbey Road", "Led Zeppelin IV", "The Velvet Underground and Nico", "Pet Sounds"));

        qlist.add(new ComicsModel(
                "'All the Boys' by Panic! At the Disco was released as a bonus track on what album?", 1, "Too Weird To Live, Too Rare To Die!", "A Fever You Can't Sweat Out", "Death Of A Bachelor", "Vices & Virtues"));

        qlist.add(new ComicsModel(
                "In the Panic! At the Disco's song 'Nothern Downpour', which lyric follows 'I know the world's a broken bone'.", 4, "So sing your song until you're home", "So let them know they're on their own", "So start a fire in their cold stone", "So melt your headaches call it home"));

        qlist.add(new ComicsModel(
                "Which of Michael Jackson's albums sold the most copies?", 2, "Dangerous", "Thriller", "Bad", "Off the Wall"));

        qlist.add(new ComicsModel(
                "Who is a pioneer of 'Minimal Music' in 1960s?", 3, "Wolfgang Amadeus Mozart", "Brian Eno", "Steve Reich", "Sigur Rós"));

        qlist.add(new ComicsModel(
                "What is the stage name of New Zealand singer Phillipa 'Pip' Brown?", 1, "Ladyhawke", "Lorde", "Kesha", "Anika Moa"));

        qlist.add(new ComicsModel(
                "Pete Townshend collaborated with which famous guitarist for an event at Brixton Academy in 1985?", 2, "Jimmy Page", "David Gilmour", "Mark Knopfler", "Eric Clapton"));

        qlist.add(new ComicsModel(
                "Which lyric is about Red Hot Chili Peppers frontman Anthony Kiedis?", 3, "Fly away on, my zephyr / I feel it more than ever", "And I liked the dimple in your chin / Your pale blue eyes", "A rainy Lithuanian / Is dancing as an Indian", "You used to be so warm and affectionate...but now you're quick to get into your regret"));

        qlist.add(new ComicsModel(
                "Pamina and Papageno are characters in what Mozart opera?", 3, "The Marriage of Figaro", "The Impresario", "The Magic Flute", "The Goose of Cairo"));

        qlist.add(new ComicsModel(
                "Which of these artists did NOT feature in the fitfh studio album 'Humanz' by British virtual band Gorillaz?", 4, "Vince Staples", "Pusha T", "Danny Brown", "Snoop Dogg"));

        qlist.add(new ComicsModel(
                "What year did Dire Straits's Song 'Money for Nothing' release?", 1, "1985", "1973", "1980", "1991"));

        qlist.add(new ComicsModel(
                "Panic! At the Disco's sixth album 'Pray For The Wicked' was released on which date?", 3, "May 9, 2018", "March 13, 2018", "June 22, 2018", "February 21, 2018"));


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
            Intent intent  = new Intent(Music_20_hard.this,MainActivity.class);
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
