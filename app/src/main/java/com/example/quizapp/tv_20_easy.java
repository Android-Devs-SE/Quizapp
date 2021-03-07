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

public class tv_20_easy extends AppCompatActivity {
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
                "Who played Agent Fox Mulder in the TV sci-fi drama 'The X-Files'?", 1, "David Duchovny", "Gillian Anderson", "Robert Patrick", "Mitch Pileggi"));

        qlist.add(new ComicsModel(
                "Which of these Bojack Horseman characters is a human?", 3, "Lennie Turtletaub", "Princess Carolyn", "Todd Chavez", "Tom Jumbo-Grumbo"));

        qlist.add(new ComicsModel(
                "In the show, Doctor Who, what does T.A.R.D.I.S stand for?", 4, "Time And Resting Dimensions In Space", "Time And Relative Dimensions In Style", "Toilet Aid Rope Dog Is Soup", "Time And Relative Dimensions In Space"));

        qlist.add(new ComicsModel(
                "How many seasons did 'Stargate SG-1' have?", 1, "10", "3", "7", "12"));

        qlist.add(new ComicsModel(
                "What country is Cory in the House set in?", 3, "Canada", "Venezuala", "The United States of America", "England"));

        qlist.add(new ComicsModel(
                "In Game of Thrones, what continent lies across the Narrow Sea from Westeros?", 3, "Easteros", "Westereast", "Essos", "Esuntos"));

        qlist.add(new ComicsModel(
                "In Game of Thrones, what is Littlefinger's real name?", 4, "Podrick Payne", "Lancel Lannister", "Torrhen Karstark", "Petyr Baelish"));

        qlist.add(new ComicsModel(
                "What was the name of the the first episode of Doctor Who to air in 1963?", 4, "The Daleks", "The Aztecs", "The Edge of Destruction", "An Unearthly Child"));

        qlist.add(new ComicsModel(
                "What is the real name of the famous spanish humorist, El Risitas?", 4, "Gabriel Garcia Marquez", "Jesus Quintero", "Ernesto Guevara", "Juan Joya Borga"));

        qlist.add(new ComicsModel(
                "In Star Trek: The Next Generation, what is the name of Data's cat?", 1, "Spot", "Mittens", "Tom", "Kitty"));

        qlist.add(new ComicsModel(
                "In 'Breaking Bad', Walter White is a high school teacher diagnosed with which form of cancer?", 3, "Prostate Cancer", "Brain Cancer", "Lung Cancer", "Testicular Cancer"));

        qlist.add(new ComicsModel(
                "British actor David Morrissey stars as which role in 'The Walking Dead'?", 3, "Negan", "Rick Grimes", "The Governor", "Daryl Dixon"));

        qlist.add(new ComicsModel(
                "Which of these Disney shows is classified as an anime?", 4, "Cory in the House", "The Emperor's New School", "Hannah Montana", "Stitch!"));

        qlist.add(new ComicsModel(
                "What is the name of the planet that the Doctor from television series 'Doctor Who' comes from?", 3, "Sontar", "Skaro", "Gallifrey", "Mondas"));

        qlist.add(new ComicsModel(
                "In 'Star Trek: Voyager', which episode did Voyager establish real-time communication with Starfleet Headquarters?", 3, "Message In A Bottle", "Someone To Watch Over Me", "Pathfinder", "Counterpoint"));

        qlist.add(new ComicsModel(
                "The HBO series 'Game of Thrones' is based on which series of books?", 2, "The Wheel of Time", "A Song of Ice and Fire", "Harry Potter", "The Notebook"));

        qlist.add(new ComicsModel(
                "What was the name of the teenage witch played by Melisa Joan Hart who lives with her witch aunts Hilda and Zelda?", 2, "Hermione", "Sabrina", "Dorothy", "Dahlia"));

        qlist.add(new ComicsModel(
                "What Nickelodeon game show featured a house on the set that the contestants would ransack to find hidden objects?", 3, "Double Dare", "Nickelodeon Guts", "Finders Keepers", "Nick Arcade"));

        qlist.add(new ComicsModel(
                "In the show 'Dragonball Z', what is the name of Cell's most powerful attack?", 3, "Super Kamehameha", "Cell Kamehameha", "Solar Kamehameha", "Android Kamehameha"));

        qlist.add(new ComicsModel(
                "Which of the following awards do Matt Stone and Trey Parker NOT have?", 1, "Oscar", "Emmy", "Tony", "Grammy"));


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
            Intent intent  = new Intent(tv_20_easy.this,MainActivity.class);
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
