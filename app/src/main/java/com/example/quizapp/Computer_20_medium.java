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

public class Computer_20_medium extends AppCompatActivity
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

        qlist.add(new ComicsModel("On which computer hardware device is the BIOS chip located?",4,"Hard Disk Drive","Central Processing Unit","Graphics Processing Unit","Motherboard"));
        qlist.add(new ComicsModel("All of the following programs are classified as raster graphics editors EXCEPT:",3,"Paint.NET","GIMP","Inkscape","Adobe Photoshop"));
        qlist.add(new ComicsModel("The computer OEM manufacturer Clevo, known for its Sager notebook line, is based in which country?",4,"United States","Germany","People's Republic of China","Taiwan"));
        qlist.add(new ComicsModel("Which of these programming languages is a low-level language?",2,"Python","Assembly","C#","Pascal"));
        qlist.add(new ComicsModel("What was the first Android version specifically optimized for tablets?",1,"Honeycomb","Eclair","Froyo","Marshmellow"));
        qlist.add(new ComicsModel("Which of these people was NOT a founder of Apple Inc?",2,"Steve Jobs","Jonathan Ive","Ronald Wayne","Steve Wozniak"));
        qlist.add(new ComicsModel("What does the term MIME stand for, in regards to computing?",4,"Mail Internet Mail Exchange","Multipurpose Interleave Mail Exchange","Mail Interleave Method Exchange","Multipurpose Internet Mail Extensions"));
        qlist.add(new ComicsModel("Which programming language was developed by Sun Microsystems in 1995?",3,"Python","Solaris OS","Java","C++"));
        qlist.add(new ComicsModel("The name of technology company HP stands for what?",1,"Hewlett-Packard","Howard Packmann","Husker-Pollosk","Hellman-Pohl"));
        qlist.add(new ComicsModel("Approximately how many Apple I personal computers were created?",2,"100","200","500","1000"));
        qlist.add(new ComicsModel("Which internet company began life as an online bookstore called 'Cadabra'?",2,"eBay","Amazon","Overstock","Shopify"));
        qlist.add(new ComicsModel("Which of the following languages is used as a scripting language in the Unity 3D game engine?",4,"Java","C++","Objective-C","C#"));
        qlist.add(new ComicsModel("What was the name given to Android 4.3?",3,"Lollipop","Nutella","Jelly Bean","Froyo"));
        qlist.add(new ComicsModel("What does the acronym CDN stand for in terms of networking?",1,"Content Delivery Network","Content Distribution Network","Computational Data Network","Compressed Data Network"));
        qlist.add(new ComicsModel("What is the correct term for the metal object in between the CPU and the CPU fan within a computer system?",4,"CPU Vent","Temperature Decipator","Heat Vent","Heat Sink"));
        qlist.add(new ComicsModel("How fast is USB 3.1 Gen 2 theoretically?",2,"5 Gb/s","10 Gb/s","8 Gb/s","1 Gb/s"));
        qlist.add(new ComicsModel("What does 'LCD' stand for?",2,"Language Control Design","Liquid Crystal Display","Last Common Difference","Long Continuous Design"));
        qlist.add(new ComicsModel("Which operating system was released first?",3,"Windows","Linux","Mac OS","OS/2"));
        qlist.add(new ComicsModel("How many bytes are in a single Kibibyte?",1,"1024","2400","1000","1240"));
        qlist.add(new ComicsModel("What was the first commerically available computer processor?",4,"Intel 486SX","TMS 1000","AMD AM386","Intel 4004"));
        qlist.add(new ComicsModel(".rs is the top-level domain for what country?",1,"Serbia","Romania","Russia","Rwanda"));

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
            Intent intent  = new Intent(Computer_20_medium.this,MainActivity.class);
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
