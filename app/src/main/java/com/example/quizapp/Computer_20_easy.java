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

public class Computer_20_easy extends AppCompatActivity
{

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

        qlist.add(new ComicsModel("Which company was established on April 1st, 1976 by Steve Jobs, Steve Wozniak and Ronald Wayne?",3,"Microsoft","Atari","Apple","Commodore"));
        qlist.add(new ComicsModel("What does 'MP' in MP3 mean ?",2,"Music Player","Moving Picture","Multi Pass","Micro Point"));
        qlist.add(new ComicsModel("When Gmail first launched, how much storage did it provide for your email?",4,"512MB","5GB","Unlimited","1GB"));
        qlist.add(new ComicsModel("The programming language 'Swift' was created to replace what other programming language?",3,"C#","Ruby","Objective-C","C++"));
        qlist.add(new ComicsModel("HTML is what type of language?",1,"Markup Language","Macro Language","Programming Language","Scripting Language"));
        qlist.add(new ComicsModel("What amount of bits commonly equals one byte?",4,"1","2","64","8"));
        qlist.add(new ComicsModel("If you were to code software in this language you'd only be able to type 0s and 1s.",2,"JavaScript","Binary","C++","Python"));
        qlist.add(new ComicsModel("What is the code name for the mobile operating system Android 7.0?",1,"Nougat","Ice Cream Sandwich","Jelly Bean","Marshmallow"));
        qlist.add(new ComicsModel("How many kilobytes in one gigabyte (in decimal)?",3,"1024","1000","1000000","1048576"));
        qlist.add(new ComicsModel("What does LTS stand for in the software market?",4,"Long Taco Service","Ludicrous Transfer Speed","Ludicrous Turbo Speed","Long Term Support"));
        qlist.add(new ComicsModel("The C programming language was created by this American computer scientist. ",2,"Tim Berners Lee","Dennis Ritchie","al-Khwārizmī","Willis Ware"));
        qlist.add(new ComicsModel("In computing, what does LAN stand for?",1,"Local Area Network","Long Antenna Node","Light Access Node","Land Address Navigation"));
        qlist.add(new ComicsModel("What language does Node.js use?",2,"Java","JavaScript","Java Source","Joomla Source Code"));
        qlist.add(new ComicsModel("What does the computer software acronym JVM stand for?",4,"Java Vendor Machine","Java Visual Machine","Just Virtual Machine","Java Virtual Machine"));
        qlist.add(new ComicsModel("In the programming language Java, which of these keywords would you put on a variable to make sure it doesn't get modified?",4,"Static","Private","Public","Final"));
        qlist.add(new ComicsModel("In Hexadecimal, what color would be displayed from the color code? '00FF00'?",3,"Red","Blue","Green","Yellow"));
        qlist.add(new ComicsModel("Which computer language would you associate Django framework with?",1,"Python","C#","C++","Java"));
        qlist.add(new ComicsModel("How long is an IPv6 address?",3,"32 bits","64 bits","128 bits","128 bytes"));
        qlist.add(new ComicsModel("On Twitter, what is the character limit for a Tweet?",2,"120","140","160","100"));
        qlist.add(new ComicsModel("What does the Prt Sc button do? ",1,"Captures what's on the screen and copies it to your clipboard" ,"Nothing","Saves a .png file of what's on the screen in your screenshots folder in photos","Closes all windows"));

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
            Intent intent  = new Intent(Computer_20_easy.this,MainActivity.class);
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
