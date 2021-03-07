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

public class history_20_hard extends AppCompatActivity {
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
                "In the year 1900, what were the most popular first names given to boy and girl babies born in the United States?", 2, "Joseph and Catherine", "John and Mary", "William and Elizabeth", "George and Anne"));

        qlist.add(new ComicsModel(
                "When did Spanish Peninsular War start?", 2, "1806", "1808", "1810", "1809"));

        qlist.add(new ComicsModel(
                "List the following Iranic empires in chronological order:", 2, "Median, Achaemenid, Sassanid, Parthian", "Median, Achaemenid, Parthian, Sassanid", "Achaemenid, Median, Parthian, Sassanid", "Achaemenid, Median, Sassanid, Parthian"));

        qlist.add(new ComicsModel(
                "What age was King Henry V when he died?", 4, "62", "87", "73", "35"));

        qlist.add(new ComicsModel(
                "What did the first vending machines in the early 1880's dispense?", 4, "Alcohol", "Cigarettes", "Sodas ", "Post cards"));

        qlist.add(new ComicsModel(
                "How many sonatas did Ludwig van Beethoven write?", 3, "50", "31", "32", "21"));

        qlist.add(new ComicsModel(
                "During the Roman Triumvirate of 42 BCE, what region of the Roman Republic was given to Lepidus?", 3, "Italia", "Gallia", "Hispania ", "Asia"));

        qlist.add(new ComicsModel(
                "The Second Boer War in 1899 was fought where?", 2, "Argentina", "South Africa", "Nepal", "Bulgaria"));

        qlist.add(new ComicsModel(
                "The Battle of Hastings was fought in which year?", 2, "911", "1066", "1204", "1420"));

        qlist.add(new ComicsModel(
                "How long did the Warsaw Uprising during World War II last?", 4, "20 Days", "55 Days", "224 Days", "63 Days"));

        qlist.add(new ComicsModel(
                "What was the original name of New York City?", 2, "New London", "New Amsterdam", "New Paris", "New Rome"));

        qlist.add(new ComicsModel(
                "Which of the following was not one of Joseph Stalin's ten blows during World War II?", 3, "Crimean Offensive", "Leningrad-Novgorod Offensive", "Vistula-Oder Offensive", "Operation Bagration"));

        qlist.add(new ComicsModel(
                "Which day did World War I begin?", 1, "July 28", "January 28", "June 28", "April 28"));

        qlist.add(new ComicsModel(
                "Toussaint Louverture led a successful slave revolt in which country?", 2, "France", "Haiti", "Cuba", "United States"));

        qlist.add(new ComicsModel(
                "Which King of England was faced with the Peasants' Revolt in 1381?", 4, "Edward III", "Edward II", "Henry IV", "Richard II"));

        qlist.add(new ComicsModel(
                "Who was the first man to travel into outer space twice?", 4, "Vladimir Komarov", "Charles Conrad", "Yuri Gagarin", "Gus Grissom"));

        qlist.add(new ComicsModel(
                "Who assassinated President James A. Garfield?", 3, "Sirhan Sirhan", "Leon Czolgosz", "Charles Guiteau", "John Wilkes Booth"));

        qlist.add(new ComicsModel(
                "Which U.S. president was said to have been too honest to lie to his father about chopping down a cherry tree?", 4, "Abraham Lincoln", "Thomas Jefferson", "James Monroe", "George Washington"));

        qlist.add(new ComicsModel(
                "After the 1516 Battle of Marj Dabiq, the Ottoman Empire took control of Jerusalem from which sultanate?", 4, "Ayyubid", "Ummayyad", "Seljuq", "Mamluk"));

        qlist.add(new ComicsModel(
                "The ontological argument for the proof of God's existence is first attributed to whom?", 3, "René Descartes", "Immanuel Kant", "Anselm of Canterbury", "Aristotle"));



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
            Intent intent  = new Intent(history_20_hard.this,MainActivity.class);
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
