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

public class Film_20_easy extends AppCompatActivity {
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
                "Which movie includes a giant bunny-like spirit who has magic powers including growing trees?", 2, "Hop", "My Neighbor Totoro", "Rise of the Guardians", "Alice in Wonderland"));

        qlist.add(new ComicsModel(
                "In the movie 'Cast Away' the main protagonist's best friend while on the island is named", 4, "Carson", "Jackson", "Willy", "Wilson"));

        qlist.add(new ComicsModel(
                "Who in Pulp Fiction says 'No, they got the metric system there, they wouldn't know what the fuck a Quarter Pounder is.'", 2, "Jules Winnfield", "Vincent Vega", "Jimmie Dimmick", "Butch Coolidge"));

        qlist.add(new ComicsModel(
                "In the movie 'Spaceballs', what are the Spaceballs attempting to steal from Planet Druidia?", 1, "Air", "The Schwartz", "Princess Lonestar", "Meatballs"));

        qlist.add(new ComicsModel(
                "What was the first monster to appear alongside Godzilla?", 3, "King Kong", "Mothra", "Anguirus", "King Ghidora"));

        qlist.add(new ComicsModel(
                "In the movie Gremlins, after what time of day should you not feed Mogwai?", 3, "Evening", "Morning", "Midnight", "Afternoon"));

        qlist.add(new ComicsModel(
                "In the 2012 film, 'The Lorax', who is the antagonist?", 4, "Ted Wiggins", "The Once-Ler", "Grammy Norma", "Aloysius O'Hare"));

        qlist.add(new ComicsModel(
                "At the end of the 2001 film 'Rat Race', whose concert do the contestants crash?", 1, "Smash Mouth", "Bowling for Soup", "Sum 41", "Linkin Park"));

        qlist.add(new ComicsModel(
                "In the 1995 film 'Balto', who are Steele's accomplices?", 2, "Dusty, Kirby, and Ralph", "Kaltag, Nikki, and Star", "Nuk, Yak, and Sumac", "Jenna, Sylvie, and Dixie"));

        qlist.add(new ComicsModel(
                "What is the name of the island that 'Jurassic Park' is built on?", 4, "Isla Sorna", "Isla Muerta", "Isla Pena", "Isla Nublar"));

        qlist.add(new ComicsModel(
                "What was Bruce Campbell's iconic one-liner after getting a chainsaw hand in Evil Dead 2?", 1, "Groovy.", "Gnarly.", "Perfect.", "Nice."));

        qlist.add(new ComicsModel(
                "For the film 'Raiders of The Lost Ark', what was Harrison Ford sick with during the filming of the Cairo chase?", 3, "Anemia", "Constipation", "Dysentery", "Acid Reflux "));

        qlist.add(new ComicsModel(
                "In Big Hero 6, what fictional city is the Big Hero 6 from?", 3, "San Tokyo", "Tokysisco", "San Fransokyo", "Sankyo"));

        qlist.add(new ComicsModel(
                "Where does the original Friday The 13th movie take place?", 4, "Packanack", "Higgins Haven", "Camp Forest Green", "Camp Crystal Lake"));

        qlist.add(new ComicsModel(
                "Which of these Movies was NOT released in 1996?", 1, "Gladiator", "Independence Day", "The Rock", "Mission: Impossible"));

        qlist.add(new ComicsModel(
                "What is the name of the fictional retro-mod band starring Austin Powers as the lead vocalist?", 3, "Cough Fi", "Spear Mint", "Ming Tea", "Mister E"));

        qlist.add(new ComicsModel(
                "Who directed the Kill Bill movies?", 4, "Arnold Schwarzenegger", "David Lean", "Stanley Kubrick", "Quentin Tarantino"));

        qlist.add(new ComicsModel(
                "In 'ALF', what was ALF's real name?", 4, "Gordon Milipp", "Gordon Foster", "Gordon von Gam", "Gordon Shumway"));

        qlist.add(new ComicsModel(
                "What historical time period was the center of the Assassin’s Creed movie (2016)?", 2, "Victorian England", "Spanish Inquisition", "French Revolution", "Colonial America"));

        qlist.add(new ComicsModel(
                "In the movie 'V for Vendetta,' what is the date that masked vigilante 'V' urges people to remember?", 1, "November 5th", "November 6th", "November 4th", "September 5th"));

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
            Intent intent  = new Intent(Film_20_easy.this,MainActivity.class);
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
