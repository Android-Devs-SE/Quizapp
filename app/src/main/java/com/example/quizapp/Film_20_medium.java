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

public class Film_20_medium extends AppCompatActivity {
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
                "What is the name of the villian in the 2015 Russian-American Sci-Fi Movie 'Hardcore Henry'?", 1, "Akan", "Estelle", "Jimmy", "Henry"));

        qlist.add(new ComicsModel(
                "In the 2010 Nightmare on Elm Street reboot, who played Freddy Kruger?", 3, "Tyler Mane", "Derek Mears", "Jackie Earle Haley", "Gunnar Hansen"));

        qlist.add(new ComicsModel(
                "Who voices the main character Blu in the 2011 animated film 'Rio'?", 1, "Jesse Eisenberg", "Michael Cera", "Jonah Hill", "Zach Galifianakis"));

        qlist.add(new ComicsModel(
                "In The Lord of the Rings: The Fellowship of the Ring, which one of the following characters from the book was left out of the film?", 3, "Strider", "Barliman Butterbur", "Tom Bombadil", "Celeborn"));

        qlist.add(new ComicsModel(
                "This trope refers to minor characters that are killed off to show how a monster works.", 1, "Red Shirt", "Minions", "Expendables", "Cannon Fodder"));

        qlist.add(new ComicsModel(
                "In which movie does Robin Williams' character have to disguise themselves into a woman?", 3, "Old Dogs", "Jumanji", "Mrs. Doubtfire", "Awakenings"));

        qlist.add(new ComicsModel(
                "What is the make and model of the tour vehicles in 'Jurassic Park' (1993)?", 2, "1992 Toyota Land Cruiser", "1992 Ford Explorer XLT", "1992 Jeep Wrangler YJ Sahar", "Mercedes M-Class"));

        qlist.add(new ComicsModel(
                "Who plays 'Bruce Wayne'' in the 2008 movie 'The Dark Knight'?", 4, "Michael Caine", "Ron Dean", "Heath Ledger", "Christian Bale"));

        qlist.add(new ComicsModel(
                "Which former Star Trek actor directed Three Men and a Baby (1987)?", 4, "William Shatner", "George Takei", "James Doohan", "Leonard Nimoy"));

        qlist.add(new ComicsModel(
                "In Mulan (1998), who is the leader of the Huns?", 4, "Chien-Po", "Li Shang", "Fa Zhou", "Shan Yu"));

        qlist.add(new ComicsModel(
                "What is the name of the queen's pet in A Bug's Life?", 4, "Flik", "Hopper", "Dot", "Aphie"));

        qlist.add(new ComicsModel(
                "In Finding Nemo, what was the name of Nemo's mom?", 2, "Sandy", "Coral", "Pearl", "Shelly"));

        qlist.add(new ComicsModel(
                "In the Friday The 13th series, what is Jason's mother's first name?", 4, "Mary", "Christine", "Angeline", "Pamela"));

        qlist.add(new ComicsModel(
                "Which director directed the movie 'Pan's Labyrinth'?", 3, "Alfonso Cuarón", "Alejandro González Iñárritu", "Guillermo Del Toro", " Alejandro Jodorowsky"));

        qlist.add(new ComicsModel(
                "What film did James Cameron's Avatar dethrone as the highest-grossing film ever?", 3, "Star Wars", "Gone with the Wind", "Titanic", "Jaws"));

        qlist.add(new ComicsModel(
                "Which stand-up comedian voiced the talking parrot 'Iago' in Disney's 1992 adaptation of Aladdin?", 2, "Robin Williams", "Gilbert Gottfried", "Pauly Shore", "Jonathan Freeman"));

        qlist.add(new ComicsModel(
                "Which 90's comedy cult classic features cameos appearances from Meat Loaf, Alice Cooper and Chris Farley?", 3, "Bill & Ted's Excellent Adventure", "Dumb and Dumber", "Wayne's World", "Austin Powers: International Man of Mystery"));

        qlist.add(new ComicsModel(
                "Which actor and martial artist starred as Colonel Guile in the 1994 action film adaptation of Street Fighter?", 1, "Jean-Claude Van Damme", "Chuck Norris", "Steven Seagal", "Scott Adkins"));

        qlist.add(new ComicsModel(
                "After India, which country produces the second most movies per year?", 2, "United States", "Nigeria", "China", "France"));

        qlist.add(new ComicsModel(
                "About how much money did it cost for Tommy Wiseau to make his masterpiece 'The Room' (2003)?", 1, "$6 Million", "$20,000", "$1 Million", "$10 Million"));

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
            Intent intent  = new Intent(Film_20_medium.this,MainActivity.class);
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
