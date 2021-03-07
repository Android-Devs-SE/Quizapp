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

public class gk_10_hard extends AppCompatActivity {

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
                "Which film star has his statue in Leicester Square?", 1, "Charlie Chaplin", "Paul Newman", "Rowan Atkinson ", "Alfred Hitchcock"));

        qlist.add(new ComicsModel(
                "Which of these banks are NOT authorized to issue currency notes in Hong Kong?", 1, "OCBC", "HSBC", "Standard Chartered", "Bank of China"));

        qlist.add(new ComicsModel(
                "What is the romanized Korean word for 'heart'?", 1, "Simjang", "Aejeong", "Jeongsin", "Segseu"));

        qlist.add(new ComicsModel(
                "Which musician has collaborated with American producer Porter Robinson and released the 2016 song 'Shelter'?", 3, "Mat Zo", "deadmau5", "Madeon", "Zedd"));

        qlist.add(new ComicsModel(
                "De Eemhof, Port Zelande and Het Heijderbos are holiday villas owned by what company?", 4, "Yelloh Village", "Keycamp", "Villa Plus", "Center Parcs"));

        qlist.add(new ComicsModel(
                "Virtual reality company Oculus VR lost which of it's co-founders in a freak car accident in 2013?", 4, "Nate Mitchell", "Jack McCauley", "Palmer Luckey", "Andrew Scott Reisse"));

        qlist.add(new ComicsModel(
                "How many notes are there on a standard grand piano?", 4, "98", "108", "78", "88"));

        qlist.add(new ComicsModel(
                "What is the most commonly used noun in the English language?", 4, "Home", "Water", "Man", "Time"));

        qlist.add(new ComicsModel(
                "The word 'aprosexia' means which of the following?", 1, "The inability to concentrate on anything", "The inability to make decisions", "A feverish desire to rip one's clothes off", "The inability to stand up"));

        qlist.add(new ComicsModel(
                "In 'Resident Evil 3', how many inventory slots does Jill have at the start of the game?", 3, "6", "8", "10", "12"));

        qlist.add(new ComicsModel(
                "Which film star has his statue in Leicester Square?", 1, "Charlie Chaplin", "Paul Newman", "Rowan Atkinson ", "Alfred Hitchcock"));

        qlist.add(new ComicsModel(
                "Which of these banks are NOT authorized to issue currency notes in Hong Kong?", 1, "OCBC", "HSBC", "Standard Chartered", "Bank of China"));

        qlist.add(new ComicsModel(
                "What is the romanized Korean word for 'heart'?", 1, "Simjang", "Aejeong", "Jeongsin", "Segseu"));

        qlist.add(new ComicsModel(
                "Which musician has collaborated with American producer Porter Robinson and released the 2016 song 'Shelter'?", 3, "Mat Zo", "deadmau5", "Madeon", "Zedd"));

        qlist.add(new ComicsModel(
                "De Eemhof, Port Zelande and Het Heijderbos are holiday villas owned by what company?", 4, "Yelloh Village", "Keycamp", "Villa Plus", "Center Parcs"));

        qlist.add(new ComicsModel(
                "Virtual reality company Oculus VR lost which of it's co-founders in a freak car accident in 2013?", 4, "Nate Mitchell", "Jack McCauley", "Palmer Luckey", "Andrew Scott Reisse"));

        qlist.add(new ComicsModel(
                "How many notes are there on a standard grand piano?", 4, "98", "108", "78", "88"));

        qlist.add(new ComicsModel(
                "What is the most commonly used noun in the English language?", 4, "Home", "Water", "Man", "Time"));

        qlist.add(new ComicsModel(
                "The word 'aprosexia' means which of the following?", 1, "The inability to concentrate on anything", "The inability to make decisions", "A feverish desire to rip one's clothes off", "The inability to stand up"));

        qlist.add(new ComicsModel(
                "In 'Resident Evil 3', how many inventory slots does Jill have at the start of the game?", 3, "6", "8", "10", "12"));



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
            Intent intent  = new Intent(gk_10_hard.this,MainActivity.class);
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