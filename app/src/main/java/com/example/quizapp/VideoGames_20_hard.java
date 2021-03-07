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

public class VideoGames_20_hard extends AppCompatActivity {
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
                "Which Kingdom Hearts game featured the cast of 'The World Ends With You'?", 1, "Dream Drop Distance", "Birth By Sleep", "365/2 Days", "Re:Chain of Memories"));

        qlist.add(new ComicsModel(
                "The voice actor for which Portal 2 character was not a TV or film actor prior to the game?", 4, "Cave Johnson", "Wheatley", "Atlas / P-Body", "GLaDOS"));

        qlist.add(new ComicsModel(
                "How many playable characters are there in Super Smash Bros. for Nintendo 3DS and Wii U?", 2, "48", "58", "51", "55"));

        qlist.add(new ComicsModel(
                "The creeper in Minecraft was the result of a bug while implementing which creature?", 3, "Zombie", "Chicken", "Pig", "Cow"));

        qlist.add(new ComicsModel(
                "During development of 'Super Mario World', Yoshi's hard saddle was originally which of these?", 4, "A slide of Gelatin", "A poffin", "A spike", "A shell"));

        qlist.add(new ComicsModel(
                "In the Lego Island trilogy, who taught Pepper Roni how to read?", 3, "Papa Brickolini", "Officer Nick Brick", "Officer Laura Brick", "Mama Brickolini"));

        qlist.add(new ComicsModel(
                "Which of these games was NOT developed by Markus Persson?", 3, "Minecraft", "Wurm Online", "Dwarf Fortress", "0x10c"));

        qlist.add(new ComicsModel(
                "In the original DOOM (1993) which of the following is NOT a cheat code?", 1, "IDCLIP", "IDFA", "IDDQD", "IDSPISPOPD"));

        qlist.add(new ComicsModel(
                "Which variant of the MP5 is depicted in Counter-Strike 1.6?", 2, "MP5SD", "MP5N", "MP5K", "MP5RAS"));

        qlist.add(new ComicsModel(
                "In the 'Little Lost Girl' Easter Egg in Call of Duty: Black Ops II, what's the last step required for the achievement?", 1, "Raise Hell", "Freedom", "Skewer the Winged Beast", "Ascend from Darkness"));

        qlist.add(new ComicsModel(
                "In the 'Halo' series, what is the name of the race of aliens humans refer to as 'Grunts'?", 2, "Huragok", "Unggoy", "Sangheili", "Yanme'e"));

        qlist.add(new ComicsModel(
                "Which game in the 'Monster Hunter' series introduced the 'Insect Glaive' weapon?", 2, "Monster Hunter Freedom", "Monster Hunter 4", "Monster Hunter Stories", "Monster Hunter 2"));

        qlist.add(new ComicsModel(
                "In 'Starbound', according to the asset files, the description of the 'Erchius Ghost' is the same as which other assets?", 4, "Petricub", "Trictus", "Pyromantle", "Spookit"));

        qlist.add(new ComicsModel(
                "In 'Starbound', what is the max HP of the monster 'Punchy'?", 1, "50,000 HP", "9,000,000 HP", "100 HP", "150,000 HP"));

        qlist.add(new ComicsModel(
                "Which artist composed the original soundtrack for 'Watch Dogs 2'?", 4, "Rustie", "Machinedrum", "Flying Lotus", "Hudson Mohawke"));

        qlist.add(new ComicsModel(
                "In 'Magicka', which two elements are combined to cast the spell, 'Nullify'?", 2, "Lightning + Shield", "Arcane + Shield", "Lightning + Life", "Arcane + Life"));

        qlist.add(new ComicsModel(
                "When was the Valve Corporation founded?", 3, "December 26, 1994", "March 22, 1997", "August 24, 1996", "March 13, 1997"));

        qlist.add(new ComicsModel(
                "What is the name of the main island in PLAYERUNKNOWN'S BATTLEGROUNDS?", 2, "Marmara", "Erangel", "Severny", "Lastovo"));

        qlist.add(new ComicsModel(
                "In which game did the character 'Mario' make his first appearance?", 2, "Super Mario Bros.", "Donkey Kong", "Super Mario Land", "Mario Bros."));

        qlist.add(new ComicsModel(
                "Which of the following games was NOT included in Valve's Orange Box?", 2, "Portal", "Counter-Strike", "Half-Life 2: Episode Two", "Team Fortress 2"));

        qlist.add(new ComicsModel(
                "What is the plane of existence in MicroProse's 1997 'Magic the Gathering'?", 3, "Theros", "Ravnica", "Shandalar", "Amonkhet"));

        qlist.add(new ComicsModel(
                "What is the default name of the Vampire character in 'Shining Soul 2'.", 3, "Sachs", "Dracuul", "Bloodstar", "Alucard"));

        qlist.add(new ComicsModel(
                "In the Kingdom Hearts series, which is not an optional boss you can fight?", 4, "Sephiroth", "Julius", "Kurt Zisa", "Master Yen Sid"));

        qlist.add(new ComicsModel(
                "Which one of these is NOT an official map in Counter-Strike: Global Offensive?", 1, "de_season", "de_sugarcane", "de_canals", "de_militia"));

        qlist.add(new ComicsModel(
                "In Disney's 'Toontown Online', which of these species wasn't available as a Toon?", 3, "Monkey", "Bear", "Cow", "Pig"));

        qlist.add(new ComicsModel(
                "In the indie farming game 'Stardew Valley', which NPC hates the 'prismatic shard' item when received as a gift?", 4, "Abigail ", "Elliott", "Lewis", "Haley"));

        qlist.add(new ComicsModel(
                "'Strangereal' is a fictitious Earth-like world for which game series?", 2, "Jet Set Radio", "Ace Combat", "Deus Ex", "Crimson Skies"));

        qlist.add(new ComicsModel(
                "Which occupation did John Tanner, the main protagonist for Driver and Driver 2, had before turning into an undercover cop?", 4, "Taxi Driver", "Delivery Driver", "Getaway Driver", "Racing Driver"));

        qlist.add(new ComicsModel(
                "Which of these characters from Final Fantasy VIII primarily spoke in one word sentences?", 4, "Raijin", "Seifer", "Zell", "Fujin"));

        qlist.add(new ComicsModel(
                "In the Nintendo Game Splatoon 2, what is Marina's screen name?", 4, "MC.princess", "Kidnotsquid123", "I<30ffTh3H00k", "DJ_Hyperfresh"));

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
            Intent intent  = new Intent(VideoGames_20_hard.this,MainActivity.class);
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
