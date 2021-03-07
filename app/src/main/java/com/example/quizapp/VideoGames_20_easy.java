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

public class VideoGames_20_easy  extends AppCompatActivity {

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
    private void getData()
    {
        qlist.add(new ComicsModel(
                "Which Game Boy from the Game Boy series of portable video game consoles was released first?", 3, "Game Boy Advance", "Game Boy Micro", "Game Boy Color", "Game Boy Advance SP"));

        qlist.add(new ComicsModel(
                "What was the original name of Crash Bandicoot?", 3, "Coco Bandicoot", "Marvelous Mole", "Willie Wombat", "Wally Wombat"));

        qlist.add(new ComicsModel(
                "What is the default alias that Princess Garnet goes by in Final Fantasy IX?", 1, "Dagger", "Dirk", "Garnet", "Quina"));

        qlist.add(new ComicsModel(
                "The starting pistol of the Terrorist team in a competitive match of Counter Strike: Global Offensive is what?", 3, "Tec-9", "Desert Eagle", "Glock-18", "Dual Berretas"));

        qlist.add(new ComicsModel(
                "In the video game Overwatch, which playable character is infamous for saying 'It's high noon.'?", 4, "Hanzo", "Pharah", "Soldier: 76", "McCree"));

        qlist.add(new ComicsModel(
                "Which of the following Elite Four members from the 6th Generation of Pokemon was a member of Team Flare?", 4, "Siebold", "Wikstrom", "Drasna", "Malva"));

        qlist.add(new ComicsModel(
                "What is the maximum HP in Terraria?", 1, "500", "400", "1000", "100"));

        qlist.add(new ComicsModel(
                "What is the name of the 4-armed Chaos Witch from the 2016 video game 'Battleborn'?", 4, "Orendoo", "Oranda", "Randy", "Orendi"));

        qlist.add(new ComicsModel(
                "Which 'Fallout: New Vegas' quest is NOT named after a real-life song?", 3, "Come Fly With Me", "Ain't That a Kick in the Head", "They Went That-a-Way", "Ring-a-Ding Ding"));

        qlist.add(new ComicsModel(
                "In the game 'Hearthstone', what is the best rank possible?", 4, "Rank 1 Elite", "Rank 1 Master", "Rank 1 Supreme", "Rank 1 Legend"));

        qlist.add(new ComicsModel(
                "Who is the creator of Touhou project?", 2, "Jun", "Zun", "Twilight Frontier", "Tasofro"));

        qlist.add(new ComicsModel(
                "In which year was League of Legends released?", 2, "2010", "2009", "2003", "2001"));

        qlist.add(new ComicsModel(
                "What is the last name of the primary female protagonist of Final Fantasy VIII?", 4, "Loire", "Almasy", "Trepe", "Heartilly"));

        qlist.add(new ComicsModel(
                "In the original Spyro game who is the first villain?", 1, "Gnasty Gnorc", "Ripto", "Sorceress", "Cynder"));

        qlist.add(new ComicsModel(
                "Which Nintendo 64 game did NOT have Luigi in it?", 4, "Mario Party 2", "Paper Mario", "Super Smash Bros.", "Super Mario 64"));

        qlist.add(new ComicsModel(
                "What is the name of the adventurer you meet at the mines in Stardew Valley?", 1, "Marlon", "Marnie", "Morris", "Marvin"));

        qlist.add(new ComicsModel(
                "Which of the following Zelda games did not feature Ganon as a final boss?", 1, "Majora's Mask", "Ocarina of Time", "Skyward Sword", "Breath of the Wild"));

        qlist.add(new ComicsModel(
                "Which of 2 Valve Games are set in the same universe?", 1, "Half-life and Portal", "Portal and Left 4 Dead", "Half-life and Left 4 Dead", "Half-life and Counter Strike"));

        qlist.add(new ComicsModel(
                "Who is the leader of the Brotherhood of Nod in the Command and Conquer series?", 1, "Kane", "Joseph Stalin", "CABAL", "Yuri"));

        qlist.add(new ComicsModel(
                "What was the name of the canceled projected by Blizzard Entertainment that would be later become Overwatch?", 4, "Omnic", "Omega", "Ghost", "Titan"));

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
            Intent intent  = new Intent(VideoGames_20_easy.this,MainActivity.class);
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
                selectid =0;
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
