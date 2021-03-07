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

public class gk_20easy extends AppCompatActivity {

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
                "What does a funambulist walk on?", 4, "Broken Glass", "Balls", "The Moon", "A Tight Rope"));

        qlist.add(new ComicsModel(
                "How would one say goodbye in Spanish?", 1, "Adiós", " Hola", "Au Revoir", "Salir"));

        qlist.add(new ComicsModel(
                "Which sign of the zodiac is represented by the Crab?", 3, "Libra", "Virgo", "Cancer", "Sagittarius"));

        qlist.add(new ComicsModel(
                "What alcoholic drink is made from molasses?", 1, "Rum", "Gin", "Vodka", "Whisky"));

        qlist.add(new ComicsModel(
                "What geometric shape is generally used for stop signs?", 1, "Octagon", "Hexagon", "Circle", "Triangle"));

        qlist.add(new ComicsModel(
                "What is the name of the Jewish New Year?", 4, "Elul", "New Year", "Succoss", "Rosh Hashanah"));

        qlist.add(new ComicsModel(
                "What is the nickname of the US state of California?", 1, "Golden State", "Sunshine State", "Bay State", "Treasure State"));

        qlist.add(new ComicsModel(
                "Which one of these is not a typical European sword design?", 3, "Falchion", "Ulfberht", "Scimitar", "Flamberge"));

        qlist.add(new ComicsModel(
                "Which of the following card games revolves around numbers and basic math?", 3, "Go Fish", "Twister", "Uno", "Munchkin"));

        qlist.add(new ComicsModel(
                "Which sign of the zodiac comes between Virgo and Scorpio?", 2, "Gemini", "Libra", "Taurus", "Capricorn"));

        qlist.add(new ComicsModel(
                "Which of the following presidents is not on Mount Rushmore?", 2, "Theodore Roosevelt", "John F. Kennedy", "Abraham Lincoln", "Thomas Jefferson"));

        qlist.add(new ComicsModel(
                "What is Tasmania?", 3, "A flavor of Ben and Jerry's ice-cream", "A Psychological Disorder", "An Australian State", "The Name of a Warner Brothers Cartoon Character"));

        qlist.add(new ComicsModel(
                "What company developed the vocaloid Hatsune Miku?", 1, "Crypton Future Media", "Sega", "Sony", "Yamaha Corporation"));

        qlist.add(new ComicsModel(
                "Which candy is NOT made by Mars?", 1, "Almond Joy", "M&M's", "Twix", "Snickers"));

        qlist.add(new ComicsModel(
                "Which of the following is the IATA code for Manchester Airport?", 1, "MAN", "EGLL", "LHR", "EGCC"));

        qlist.add(new ComicsModel(
                "What is the Zodiac symbol for Gemini?", 4, "Fish", "Scales", "Maiden", "Twins"));

        qlist.add(new ComicsModel(
                "According to the nursery rhyme, what fruit did Little Jack Horner pull out of his Christmas pie?", 4, "Apple", "Peach", "Pear", "Plum"));

        qlist.add(new ComicsModel(
                "What is the name of NASA’s most famous space telescope?", 4, "Big Eye", "Death Star", "Millenium Falcon", "Hubble Space Telescope"));

        qlist.add(new ComicsModel(
                "Which of the following blood component forms a plug at the site of injuries?", 4, "Red blood cells", "White blood cells", "Blood plasma", "Platelets"));

        qlist.add(new ComicsModel(
                "What is the French word for 'fish'?", 2, "fiche", "poisson", "escargot", "mer"));


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
            Intent intent  = new Intent(gk_20easy.this,MainActivity.class);
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
