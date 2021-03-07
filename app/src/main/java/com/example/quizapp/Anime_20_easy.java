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

public class Anime_20_easy  extends AppCompatActivity {
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
                "The name of Junko Enoshima's imposter at the beginning of Danganronpa: Trigger Happy Havoc is?", 3, "Ryota Mitarai", "Ultimate Imposter", "Mukuro Ikusaba", "Komaru Naegi"));

        qlist.add(new ComicsModel(
                "In 'Future Diary', what is the name of Yuno Gasai's Phone Diary?", 1, "Yukiteru Diary", "Murder Diary", "Escape Diary ", "Justice Diary "));

        qlist.add(new ComicsModel(
                "In the anime Noragami who is one of the main protagonists?", 2, "Karuha", "Yukine", "Mineha", "Mayu"));

        qlist.add(new ComicsModel(
                "In the anime Seven Deadly Sins what is the name of one of the sins?", 2, "Sakura", "Diane", "Ayano", "Sheska"));

        qlist.add(new ComicsModel(
                "In the anime Black Butler, who is betrothed to be married to Ciel Phantomhive?", 1, "Elizabeth Midford", "Rachel Phantomhive", "Alexis Leon Midford", "Angelina Dalles"));

        qlist.add(new ComicsModel(
                "In 'The Melancholy of Haruhi Suzumiya' series, the SOS Brigade club leader is unknowingly treated as a(n) __ by her peers.", 2, "Alien", "God", "Time Traveler", "Esper"));

        qlist.add(new ComicsModel(
                "In 'A Certain Scientific Railgun', how many 'sisters' did Accelerator have to kill to achieve the rumored level 6?", 1, "20,000", "128", "10,000", "5,000"));

        qlist.add(new ComicsModel(
                "Who is the author of the manga series 'Astro Boy'?", 4, "Mitsuteri Yokoyama", "Takao Saito", "Yoshihiro Tatsumi", "Osamu Tezuka"));

        qlist.add(new ComicsModel(
                "In Digimon, what is the Japanese name for the final evolutionary stage?", 1, "Ultimate", "Mega", "Adult", "Champion"));

        qlist.add(new ComicsModel(
                "In the 2012 animated film 'Wolf Children', what are the names of the wolf children?", 1, "Ame & Yuki", "Hana & Yuki", "Ame & Hana", "Chuck & Anna"));

        qlist.add(new ComicsModel(
                "The characters of 'Log Horizon' are trapped in what game?", 3, "Sword Art Online", "Tower Unite", "Elder Tale", "Yggdrasil"));

        qlist.add(new ComicsModel(
                "The two main characters of 'No Game No Life', Sora and Shiro, together go by what name?", 1, "Blank", "Immanity", "Disboard", "Warbeasts"));

        qlist.add(new ComicsModel(
                "Satella in 'Re:Zero' is the witch of what?", 1, "Envy", "Pride", "Sloth", "Wrath"));

        qlist.add(new ComicsModel(
                "Which of the following originated as a manga?", 4, "Cowboy Bebop", "High School DxD", "Gurren Lagann", "Akira"));

        qlist.add(new ComicsModel(
                "What year did 'Attack on Titan' first air?", 1, "2013", "2014", "2012", "2015"));

        qlist.add(new ComicsModel(
                "In 'To Love-Ru', Ren and Run are from what planet?", 1, "Memorze", "Deviluke", "Mistletoe", "Okiwana"));
        qlist.add(new ComicsModel(
                "Who is the colossal titan in 'Attack On Titan'?", 2, "Reiner", "Bertolt Hoover", "Eren", "Sasha"));

        qlist.add(new ComicsModel(
                "Who is the armored titan in 'Attack On Titan'?", 4, "Armin Arlelt", "Mikasa Ackermann", "Eren Jaeger", "Reiner Braun"));

        qlist.add(new ComicsModel(
                "In Ms. Kobayashi's Dragon Maid, who is Kobayashi's maid?", 2, "Lucoa", "Tohru", "Kanna", "Elma"));

        qlist.add(new ComicsModel(
                "In 2013, virtual pop-star Hatsune Miku had a sponsorship with which pizza chain?", 1, "Domino's", "Papa John's", "Pizza Hut", "Sabarro's"));


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
            Intent intent  = new Intent(Anime_20_easy.this,MainActivity.class);
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
