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

public class Tv_20_medium extends AppCompatActivity {
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
                "In the TV series 'Person of Interest', who plays the character 'Harold Finch'?", 1, "Michael Emerson", "Jim Caviezel", "Taraji P. Henson", "Kevin Chapman"));

        qlist.add(new ComicsModel(
                "What is the title of The Allman Brothers Band instrumental used as the theme to the BBC motoring show, 'Top Gear'?", 4, "Angela", "Erica", "Sandra", "Jessica"));

        qlist.add(new ComicsModel(
                "Who sang the theme song for the TV show 'Rawhide'?", 4, "Guy Mitchell", " Tennessee Ernie Ford", "Slim Whitman", "Frankie Laine"));

        qlist.add(new ComicsModel(
                "Which of the following Autobot names in Michael Bay's movies was NOT a name for a Transformer in the original 1980's cartoon?", 1, "Mudflap", "Skids", "Sideswipe", "Ratchet"));

        qlist.add(new ComicsModel(
                "What was the name of Ross' pet monkey on 'Friends'?", 2, "Jojo", "Marcel", "George", "Champ"));

        qlist.add(new ComicsModel(
                "In Breaking Bad, the initials W.W. refer to which of the following?", 3, "William Wolf", "Willy Wonka", "Walter White", "Wally Walrus"));

        qlist.add(new ComicsModel(
                "In 'The Big Bang Theory', what is Howard Wolowitz's nickname in World of Warcraft?", 1, "Wolowizard", "Sheldor", "Rajesh", "Priya"));

        qlist.add(new ComicsModel(
                "How long was Ken Jennings' win streak on Jeopardy?", 4, "88", "49", "62", "74"));

        qlist.add(new ComicsModel(
                "Who was the winner of the 2016 WWE Royal Rumble?", 1, "Triple H", "Roman Reigns", "AJ Styles", "Dean Ambrose"));

        qlist.add(new ComicsModel(
                "What is Meg's full name in 'Family Guy'?", 1, "Megatron Griffin", "Who-Cares Griffin", "Neil Griffin", "Megan Griffin"));

        qlist.add(new ComicsModel(
                "Which of following is rude and dishonorable by Klingon standards?", 2, "Insulting and laughing at him at the dinner table", "Taking his D'k tahg", "Reaching over and taking his meal", "Punching him and taking his ship station position"));

        qlist.add(new ComicsModel(
                "In 'Star Trek', what is the Ferengi's First Rule of Acquisition?", 4, "Never place friendship above profit", "Greed is Eternal", "Never allow family to stand in the way of opportunity", "Once you have their money, you never give it back. "));

        qlist.add(new ComicsModel(
                "What episode of 'Mr. Bean' saw him trying to prevent people from seeing him naked?", 3, "Mr. Bean Goes to Town", "The Trouble with Mr. Bean", "Mr. Bean in Room 426", "Back to School Mr. Bean"));

        qlist.add(new ComicsModel(
                "In Battlestar Galactica (2004), what is the name of the President of the Twelve Colonies?", 2, "William Adama", "Laura Roslin", "Tricia Helfer", "Harry Stills"));

        qlist.add(new ComicsModel(
                "Which WWF wrestler had the nickname 'The Ayatollah of Rock 'N' Rolla'?", 2, "Marty Jannetty", "Chris Jericho", "Scott Hall", "Shawn Michaels"));

        qlist.add(new ComicsModel(
                "'The A Team' first aired in the USA and in the UK in what year?", 1, "1983", "1981", "1985", "1987"));

        qlist.add(new ComicsModel(
                "The 1985 Toyota Corolla 'AE86' was the hero car for what anime? ", 3, "Wangan Midnight", "Ghost MF", "Initial D", "Ex Driver"));

        qlist.add(new ComicsModel(
                "The first half-hour CGI cartoon, ReBoot, aired on which year?", 4, "1993", "1998", "1999", "1994"));

        qlist.add(new ComicsModel(
                "Out of the 3 Tots in Tots TV, who speaks French in the UK Version and Spanish in the US Version?", 1, "Tilly", "Tom", "Tiny", "None of the Above"));

        qlist.add(new ComicsModel(
                "The fictional movie 'Rochelle, Rochelle' features in which sitcom?", 4, "Frasier", "Cheers", "Friends", "Seinfeld"));


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
            Intent intent  = new Intent(Tv_20_medium.this,MainActivity.class);
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
