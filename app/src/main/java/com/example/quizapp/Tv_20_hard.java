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

public class Tv_20_hard extends AppCompatActivity {
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
                "The theme for the popular science fiction series 'Doctor Who' was composed by who?", 2, "Murray Gold", "Ron Grainer", "Delia Derbyshire", "Peter Howell"));

        qlist.add(new ComicsModel(
                "What's Dr. Doofenshmirtz first name?", 1, "Heinz", "Hans", "Hank", "Heidi"));

        qlist.add(new ComicsModel(
                "In 'It's Always Sunny in Philadelphia' what was the name of Frank's wrestling persona?", 1, "The Trash Man", "Bird of War", "Day Man", "The Maniac"));

        qlist.add(new ComicsModel(
                "Which country does the YouTuber 'SinowBeats' originate from?", 3, "England", "Sweden", "Scotland", "Germany"));

        qlist.add(new ComicsModel(
                "Who played the sun baby in the original run of Teletubbies?", 1, "Jessica Smith", "Pui Fan Lee", "Sue Monroe", "Lisa Brockwell"));

        qlist.add(new ComicsModel(
                "In Star Trek, what is the name of Spock's father?", 1, "Sarek", "Tuvok", "T'Pal", "Surak"));

        qlist.add(new ComicsModel(
                "In 'Donkey Kong Country', why does Donkey Kong want to know the secret of the crystal coconut?", 1, "He's the big kahuna.", "To find out where all the bananas are.", "Because Diddy Kong forced him.", "He wants to punish brutes."));

        qlist.add(new ComicsModel(
                "In the TV Show 'Donkey Kong Country', which episode did the song 'Eddie, Let Me Go Back To My Home' play in?", 3, "Message In A Bottle Show", "To The Moon Baboon", "It's a Wonderful Life", "Ape-Nesia"));

        qlist.add(new ComicsModel(
                "In 'Star Trek', who was the founder of the Klingon Empire and its philosophy?", 1, "Kahless the Unforgettable", "Lady Lukara of the Great Hall", "Molor the Unforgiving", "Dahar Master Kor"));

        qlist.add(new ComicsModel(
                "In 'Star Trek', what sauce is commonly used by Klingons on bregit lung?", 1, "Grapok sauce", "Gazorpazorp pudding", "Sweet chili sauce", "Grapork sauce"));

        qlist.add(new ComicsModel(
                "Which of these voices wasn't a choice for the House AI in 'The Simpsons Treehouse of Horror' short, House of Whacks?", 1, "George Clooney", "Matthew Perry", "Dennis Miller", "Pierce Brosnan"));

        qlist.add(new ComicsModel(
                "Which of the following actors portrayed the Ninth Doctor in the British television show 'Doctor Who'?", 1, "Christopher Eccleston", "David Tennant", "Matt Smith", "Tom Baker"));

        qlist.add(new ComicsModel(
                "What was the callsign of Commander William Adama in Battlestar Galactica (2004)?", 2, "Starbuck", "Husker", "Apollo", "Crashdown"));

        qlist.add(new ComicsModel(
                "What was the name of the inflatable duck sacrified to the crowd at the end of Episode 34 of the 18th season of Big Brother?", 2, "Esteban", "Pablo", "Carlos", "Duckster"));

        qlist.add(new ComicsModel(
                "In season one of the US Kitchen Nightmares, Gordan Ramsay tried to save 10 different restaurants. How many ended up closing afterwards?", 2, "6", "9", "3", "0"));

        qlist.add(new ComicsModel(
                "Prior to working at Wizards of the Coast, 'Mark Rosewater' was a writer for which show?", 4, "Boy Meets World", "The X-Files", "NYPD Blue", "Roseanne"));

        qlist.add(new ComicsModel(
                "Who was the winner of 'Big Brother' Season 10?", 1, "Dan Gheesling", "Bryce Kranyik", "Ryan Sutfin", "Chris Mundorf"));

        qlist.add(new ComicsModel(
                "Which former Coronation Street actress was once a hostess on the British Game Show 'Double Your Money'?", 2, "Sue Nicholls", "Amanda Barrie", "Violet Carson", "Jean Alexander"));

        qlist.add(new ComicsModel(
                "What was the UK 'Who Wants to be a Millionaire?' cheating scandal known as?", 3, "Ingram Cheater", "Coughing Major", "Major Fraud", "Millionaire Crime"));

        qlist.add(new ComicsModel(
                "In the show 'Doctor Who', what is the name of the time-capsule model stolen by 'the Doctor'?", 1, "TT Type 40, Mark 3 (TARDIS)", "TT Type 1, Mark 3 (TARDIS)", "TT Type 40, Mark 5 (TARDIS)", "TT Type 1, Mark 5 (TARDIS)"));



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
            Intent intent  = new Intent(Tv_20_hard.this,MainActivity.class);
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
