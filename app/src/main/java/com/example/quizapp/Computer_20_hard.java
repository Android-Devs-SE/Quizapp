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

public class Computer_20_hard extends AppCompatActivity {
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
                "The Harvard architecture for micro-controllers added which additional bus?", 3, "Address", "Data", "Instruction", "Control"));

        qlist.add(new ComicsModel(
                "The internet domain .fm is the country-code top-level domain for which Pacific Ocean island nation?", 3, "Fiji", "Tuvalu", "Micronesia", "Marshall Islands"));

        qlist.add(new ComicsModel(
                "Which of these was the name of a bug found in April 2014 in the publicly available OpenSSL cryptography library?", 3, "Shellshock", "Corrupted Blood", "Heartbleed", "Shellscript"));

        qlist.add(new ComicsModel(
                "Who is the original author of the realtime physics engine called PhysX?", 1, "NovodeX", "Ageia", "Nvidia", "AMD"));

        qlist.add(new ComicsModel(
                "Which data structure does FILO apply to?", 1, "Stack", "Queue", "Heap", "Tree"));

        qlist.add(new ComicsModel(
                "America Online (AOL) started out as which of these online service providers?", 2, "CompuServe", "Quantum Link", "Prodigy", "GEnie"));

        qlist.add(new ComicsModel(
                "Which of these is not a key value of Agile software development?", 3, "Individuals and interactions", "Customer collaboration", "Comprehensive documentation", "Responding to change"));

        qlist.add(new ComicsModel(
                "What does the International System of Quantities refer 1024 bytes as?", 3, "Kylobyte", "Kilobyte", "Kibibyte", "Kelobyte"));

        qlist.add(new ComicsModel(
                "Which RAID array type is associated with data mirroring?", 2, "RAID 0", "RAID 1", "RAID 10", "RAID 5"));

        qlist.add(new ComicsModel(
                "What was the first company to use the term 'Golden Master'?", 4, "IBM", "Microsoft", "Google", "Apple"));

        qlist.add(new ComicsModel(
                "Dutch computer scientist Mark Overmars is known for creating which game development engine?", 2, "Stencyl", "Game Maker", "Construct", "Torque 2D"));

        qlist.add(new ComicsModel(
                "What is the name given to layer 4 of the Open Systems Interconnection (ISO) model?", 1, "Transport", "Session", "Data link", "Network"));

        qlist.add(new ComicsModel(
                "Who invented the 'Spanning Tree Protocol'?", 4, "Paul Vixie", "Vint Cerf", "Michael Roberts", "Radia Perlman"));

        qlist.add(new ComicsModel(
                "The acronym 'RIP' stands for which of these?", 2, "Runtime Instance Processes", "Routing Information Protocol", "Regular Interval Processes", "Routine Inspection Protocol"));

        qlist.add(new ComicsModel(
                "What was the name of the first Bulgarian personal computer?", 1, "IMKO-1", "Pravetz 82", "Pravetz 8D", "IZOT 1030"));

        qlist.add(new ComicsModel(
                "What type of sound chip does the Super Nintendo Entertainment System (SNES) have?", 3, "FM Synthesizer", "Programmable Sound Generator (PSG)", "ADPCM Sampler", "PCM Sampler"));

        qlist.add(new ComicsModel(
                "Which of the following computer components can be built using only NAND gates?", 3, "CPU", "RAM", "ALU", "Register"));

        qlist.add(new ComicsModel(
                "Lenovo acquired IBM's personal computer division, including the ThinkPad line of laptops and tablets, in what year?", 1, "2005", "1999", "2002", "2008"));

        qlist.add(new ComicsModel(
                "Which kind of algorithm is Ron Rivest not famous for creating?", 1, "Secret sharing scheme", "Hashing algorithm", "Asymmetric encryption", "Stream cipher"));

        qlist.add(new ComicsModel(
                "Who is the founder of Palantir?", 2, "Mark Zuckerberg", "Peter Thiel", "Marc Benioff", "Jack Dorsey"));



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
            Intent intent  = new Intent(Computer_20_hard.this,MainActivity.class);
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
