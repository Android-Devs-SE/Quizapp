package com.example.quizgitfinale;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.List;

public class history_20_easy extends AppCompatActivity {

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
                "King Henry VIII was the second monarch of which European royal house?", 3, "York", "Stuart", "Tudor", "Lancaster"));

        qlist.add(new ComicsModel(
                "What was William Frederick Cody better known as?", 4, "Billy the Kid", "Wild Bill Hickok", "Pawnee Bill", "Buffalo Bill"));

        qlist.add(new ComicsModel(
                "Which German field marshal was known as the `Desert Fox`?", 3, "Ernst Busch", "Wolfram Freiherr von Richthofen", "Erwin Rommel", "Wilhelm List"));

        qlist.add(new ComicsModel(
                "How many manned moon landings have there been?", 4, "1", "3", "7", "6"));

        qlist.add(new ComicsModel(
                "In what year did the Wall Street Crash take place?", 3, "1932", "1930", "1929", "1925"));

        qlist.add(new ComicsModel(
                "Which famous world leader is famed for the saying, 'Let them eat cake', yet is rumored that he/she never said it at all?", 3, "Czar Nicholas II", "Elizabeth I", "Marie Antoinette", "Henry VIII"));

        qlist.add(new ComicsModel(
                "The collapse of the Soviet Union took place in which year?", 3, "1992", "1891", "1991", "1990"));

        qlist.add(new ComicsModel(
                "What was Manfred von Richthofen's nickname?", 2, "The High Flying Ace", "The Red Baron", "The Blue Serpent ", "The Germany Gunner"));

        qlist.add(new ComicsModel(
                "Who was the first president of the United States?", 4, "James Madison", "Thomas Jefferson", "James K. Polk", "George Washington"));

        qlist.add(new ComicsModel(
                "Who was the Prime Minister of Japan when Japan declared war on the US?", 4, "Michinomiya Hirohito", "Isoroku Yamamoto", "Fumimaro Konoe", "Hideki Tojo"));

        qlist.add(new ComicsModel(
                "Which of the following countries was not an axis power during World War II?", 2, "Italy", " Soviet Union", "Germany", "Japan"));

        qlist.add(new ComicsModel(
                "What year did World War I begin?", 1, "1914", "1905", "1919", "1925"));

        qlist.add(new ComicsModel(
                "How old was Adolf Hitler when he died?", 2, "43", "56", "65", "47"));

        qlist.add(new ComicsModel(
                "Which modern country is known as 'The Graveyard of Empires'?", 1, "Afghanistan", "China", "Iraq", "Russia"));

        qlist.add(new ComicsModel(
                "Who led the Communist Revolution of Russia?", 1, "Vladimir Lenin", "Joseph Stalin", "Vladimir Putin", "Mikhail Gorbachev"));

        qlist.add(new ComicsModel(
                "Which of the following was Brazil was a former colony under?", 4, "Spain", "The Netherlands", "France", "Portugal"));

        qlist.add(new ComicsModel(
                "What is the historical name of Sri Lanka?", 4, "Myanmar", "Colombo", "Badulla", "Ceylon"));

        qlist.add(new ComicsModel(
                "Who rode on horseback to warn the Minutemen that the British were coming during the U.S. Revolutionary War?", 2, "Thomas Paine", "Paul Revere", "Henry Longfellow", "Nathan Hale"));

        qlist.add(new ComicsModel(
                "Abolitionist John Brown raided the arsenal in which Virginia Town?", 3, "Richmond", "Harrisonburg", "Harper's Ferry", "Martinsburg"));

        qlist.add(new ComicsModel(
                "The Ottoman Empire was dissolved after their loss in which war?", 2, "Crimean War", "World War I", "Serbian Revolution", "Second Balkan War"));



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
            Intent intent  = new Intent(history_20_easy.this,MainActivity.class);
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