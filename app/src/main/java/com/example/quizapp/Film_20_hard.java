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

public class Film_20_hard  extends AppCompatActivity {
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
                "What was the name of the actor who played Leatherface in the 1974 horror film, The Texas Chainsaw Massacre?", 4, "Edwin Neal", "John Dugan", "Joe Bill Hogan", "Gunnar Hansen"));

        qlist.add(new ComicsModel(
                "In order to cut costs, what were most of the extras of Mad Max (1979) paid with?", 4, "Fast food", "Food stamps", "They weren't paid", "Beer"));

        qlist.add(new ComicsModel(
                "In 'Star Trek Nemesis', why was Praetor Shinzon created?", 4, "To destroy the Enterprise", "To become Picard's friend ", "To steal the Enterprise", "To replace Picard as a Romulan Agent"));

        qlist.add(new ComicsModel(
                "According to 'Star Wars' lore, which planet does Obi-Wan Kenobi come from?", 4, "Alderaan", "Tatooine", "Naboo", "Stewjon"));

        qlist.add(new ComicsModel(
                "In what year does Jurassic World open in the 'Jurassic Park' universe?", 3, "2007", "2015", "2005", "2020"));

        qlist.add(new ComicsModel(
                "Before 'Jurassic Park III' was finalized and the Spinosaurus was chosen, which dinosaur was going to be the star?", 3, "Tyrannosaurus Rex", "Velociraptor", "Baryonyx", "Suchomimus"));

        qlist.add(new ComicsModel(
                "In the 'Jurassic Park' universe, what was the first dinosaur cloned by InGen in 1986?", 4, "Triceratops", "Troodon", "Brachiosaurus", "Velociraptor"));

        qlist.add(new ComicsModel(
                "In the 'Jurassic Park' universe, when did 'Jurassic Park: San Diego' begin construction?", 4, "1988", "1986", "1993", "1985"));

        qlist.add(new ComicsModel(
                "What three movies, in order from release date, make up the 'Dollars Trilogy'?", 1, "A Fistful of Dollars", "For a Few Dollars More", "The Good, the Bad, and the Ugly", "The Good, the Bad, and the Ugly"));

        qlist.add(new ComicsModel(
                "Which actress portrayed Dr. Grace Augustine in the James Cameron movie 'Avatar'?", 2, "Jessica Chastain", "Sigourney Weaver", "Melissa Beckett", "Alyssa Monroe "));

        qlist.add(new ComicsModel(
                "What is the species of the 'Predator' in the 1987 movie 'Predator'?", 1, "Yautja", "Xenomorph", "Praetorian", "Phocrex"));

        qlist.add(new ComicsModel(
                "Which of the following films was directed by Ivan Reitman, written by Gary Ross, featured Kevin Kline, and was released in 1993?", 1, "Dave", "John", "Will", "Carl"));

        qlist.add(new ComicsModel(
                "In Big Hero 6, what were Baymax's motions modeled after?", 4, "Baby monkeys", "Baby ostriches", "Baby bears", "Baby penguins"));

        qlist.add(new ComicsModel(
                "In the Friday The 13th series, what year did Jason drown in?", 4, "1955", "1953", "1959", "1957"));

        qlist.add(new ComicsModel(
                "Which sci-fi cult films plot concerns aliens attempting to prevent humans from creating a doomsday weapon?", 3, "The Man from Planet X", "It Came from Outer Space", "Plan 9 from Outer Space", "The Day The Earth Stood Still"));

        qlist.add(new ComicsModel(
                "Which 1994 film did Roger Ebert famously despise, saying 'I hated hated hated hated hated this movie'.", 4, "3 Ninjas Kick Back", "The Santa Clause", "Richie Rich", "North"));

        qlist.add(new ComicsModel(
                "Which boxer was famous for striking the gong in the introduction to J. Arthur Rank films?", 3, "Freddie Mills", "Terry Spinks", "Bombardier Billy Wells", "Don Cockell"));

        qlist.add(new ComicsModel(
                "The film Mad Max: Fury Road features the Dies Irae  from which composer's requiem?", 3, "Mozart", "Berlioz", "Verdi", "Brahms"));

        qlist.add(new ComicsModel(
                "In the 1974 Christmas flick 'The Year Without a Santa Claus,' what are the names of the two elves who help Mrs. Claus save Christmas?", 3, "Buddy & Bobby", "Holly & Jolly", "Jingle & Jangle", "Snowflake & Icicle"));

        qlist.add(new ComicsModel(
                "What was the wifi password given to Stephen Strange in Doctor Strange?", 4, "Peace", "Ancient", "Chakra", "Shambala"));


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
            Intent intent  = new Intent(Film_20_hard.this,MainActivity.class);
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
