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

public class Anime_20_hard extends AppCompatActivity {
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
                "Akatsuki's subclass in 'Log Horizon' is what?", 3, "Assassin", "Scribe", " Tracker", "Apprentice"));

        qlist.add(new ComicsModel(
                "In 'One Piece', who is the girl who overcame her enslaved past and became an agent of an army to fight the corrupt government?", 1, "Koala", "Boa Hancock", "Nico Robin", "Emporio Ivankov "));

        qlist.add(new ComicsModel(
                "In 'One Piece', who confirms the existence of the legendary treasure, One Piece?", 1, "Edward Whitebeard Newgate", "Former Marine Fleet Admiral Sengoku", "Pirate King Gol D Roger", "Silvers Rayleigh"));

        qlist.add(new ComicsModel(
                "In the 'Dragon Ball' franchise, what is the name of Goku's brother?", 3, "Gohan", "Vegeta", "Raditz", "Bardock"));

        qlist.add(new ComicsModel(
                "In 'Hunter x Hunter', which of the following is NOT a type of Nen aura?", 2, "Emission", "Restoration", "Transmutation", "Specialization"));

        qlist.add(new ComicsModel(
                "In 'Hunter x Hunter', what are members in Killua's family known for being?", 3, "Bandits", "Hunters", "Assassins", "Ninjas"));

        qlist.add(new ComicsModel(
                "The 'To Love-Ru' Manga was started in what year?", 3, "2007", "2004", "2006", "2005"));

        qlist.add(new ComicsModel(
                "In 'Jewelpet Sunshine', what is the song that plays when Kanon and her friends bust out of prison?", 4, "Eye Of The Tiger", "Born to be Wild", "Ruby Ring", "I Don't Want to Miss a Thing"));

        qlist.add(new ComicsModel(
                "What is the name of the school in the anime and manga 'Gosick'?", 1, "St. Marguerite", "St. Augustine", "St. Mary", "St. Bernadette"));

        qlist.add(new ComicsModel(
                "Which animation studio animated 'To Love-Ru'?", 4, "Trigger", "Sunrise", "Kyoto Animation", "Xebec"));

        qlist.add(new ComicsModel(
                "Which animation studio animated 'Psycho Pass'?", 4, "Kyoto Animation", "Shaft", "Trigger", "Production I.G"));

        qlist.add(new ComicsModel(
                "Which animation studio produced the anime adaptation of 'xxxHolic'?", 4, "Sunrise", "Xebec", "Kyoto Animation", "Production I.G"));

        qlist.add(new ComicsModel(
                "Which animation studio produced 'Log Horizon?", 4, "Sunrise", "Xebec", "Production I.G", "Satelite"));

        qlist.add(new ComicsModel(
                "Which studio animated Afro Samurai?", 3, "Kyoto Animation", "xebec", "Gonzo", "Production I.G"));

        qlist.add(new ComicsModel(
                "In the Overlord Anime who was Cocytus made by?", 2, "Peroroncino", "Warrior Takemikazuchi", "Ulbert Alain Odle", "Bukubukuchagama"));

        qlist.add(new ComicsModel(
                "Who was the Author of the manga Uzumaki?", 2, "	Noboru Takahashi", "Junji Ito", "Akira Toriyama", "Masashi Kishimoto"));

        qlist.add(new ComicsModel(
                "Who was the Author of the manga Monster Hunter Orage?", 4, "Shin Yamamoto", "Keiichi Hikami", "Hirohiko Araki", "	Hiro Mashima"));

        qlist.add(new ComicsModel(
                "Who is the horror manga artist who made Uzumaki?", 3, "Kazuo Umezu", "Shintaro Kago", "Junji Ito", "Sui Ishida"));

        qlist.add(new ComicsModel(
                "Who was the Director of the 1988 Anime film 'Grave of the Fireflies'?", 1, "Isao Takahata", "Hayao Miyazaki", "Satoshi Kon", "Sunao Katabuchi"));

        qlist.add(new ComicsModel(
                "In the first episode of Yu-Gi-Oh: Duel Monsters, what book is Seto Kaiba seen reading at Domino High School?", 4, "Beyond Good and Evil", "The Republic", "Meditations", "Thus Spoke Zarathustra"));



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
            Intent intent  = new Intent(Anime_20_hard.this,MainActivity.class);
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
