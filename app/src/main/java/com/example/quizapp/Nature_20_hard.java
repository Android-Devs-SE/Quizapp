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

public class Nature_20_hard extends AppCompatActivity {
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
                "What common name is given to the medial condition, tibial stress syndrome (MTSS)?", 3, "Tennis Elbow", "Carpal Tunnel", "Shin Splints", "Housemaid's Knee"));

        qlist.add(new ComicsModel(
                "All of the following human genetic haplogroup names are shared between Y-chromosome and mitochondrial DNA haplogroups EXCEPT:", 2, "Haplogroup L", "Haplogroup U", "Haplogroup T", "Haplogroup J"));

        qlist.add(new ComicsModel(
                "What is isobutylphenylpropanoic acid more commonly known as?", 2, "Morphine", "Ibuprofen", "Ketamine", "Aspirin"));

        qlist.add(new ComicsModel(
                "Which of these chemical compounds is NOT found in gastric acid?", 1, "Sulfuric acid", "Hydrochloric acid", "Potassium chloride", "Sodium chloride"));

        qlist.add(new ComicsModel(
                "What is the scientific name of the red fox?", 2, "Vulpes Redus", "Vulpes Vulpes", "Red Fox", "Vulpes Vulpie"));

        qlist.add(new ComicsModel(
                "Which is not a type of neuron?", 1, "Perceptual Neuron", "Sensory Neuron", "Motor Neuron", "Interneuron"));

        qlist.add(new ComicsModel(
                "A comet's gaseous envelope (which creates the tail) is called what?", 4, "The wake", "The backwash", "The ablative", "The coma"));

        qlist.add(new ComicsModel(
                "Which of the following plastic is commonly used for window frames, gutters and drain pipes?", 1, "Polyvinylchloride (PVC) ", "Polyethylene (PE)", "Polypropylene (PP)", "Polystyrene (PS)"));

        qlist.add(new ComicsModel(
                "What is the same in Celsius and Fahrenheit?", 3, "32", "-39", "-40", "-42"));

        qlist.add(new ComicsModel(
                "How much radiation does a banana emit?", 2, "0.3 Microsievert", "0.1 Microsievert", "0.5 Microsievert", "0.7 Microsievert"));

        qlist.add(new ComicsModel(
                "Which of the following is NOT a word used to describe an earthquake?", 1, "Drop-slide", "Foreshock", "Strike-slip", "Temblor"));

        qlist.add(new ComicsModel(
                "How long is a light-year?", 4, "1 AU", "105.40 Earth-years", "501.2 Million Miles", "9.461 Trillion Kilometres"));

        qlist.add(new ComicsModel(
                "The Western Lowland Gorilla is scientifically know as?", 1, "Gorilla Gorilla Gorilla", "Gorilla Gorilla Diehli", "Gorilla Beringei Graueri", "Gorilla Beringei Beringei"));

        qlist.add(new ComicsModel(
                "How many protons are in an oxygen atom?", 1, "Eight", "Four", "Two", "Six"));

        qlist.add(new ComicsModel(
                "What is the name for the auditory illusion of a note that seems to be rising infinitely?", 1, "Shepard Tone", "Glissandro Illusion", "Fransen Effect", "McGurck Effect"));

        qlist.add(new ComicsModel(
                "Which of the following are cells of the adaptive immune system?", 4, "Dendritic cells", "Natural killer cells", "White blood cells", "Cytotoxic T cells"));

        qlist.add(new ComicsModel(
                "What causes the sound of a heartbeat?", 4, "Contraction of the heart chambers", "Blood exiting the heart", "Relaxation of the heart chambers", "Closure of the heart valves"));

        qlist.add(new ComicsModel(
                "How many types of quarks are there in the standard model of physics?", 1, "6", "2", "3", "4"));

        qlist.add(new ComicsModel(
                "In quantum physics, which of these theorised sub-atomic particles has yet to be observed?", 3, "Z boson", "Tau neutrino", "Graviton", "Gluon"));

        qlist.add(new ComicsModel(
                "In the Scoville scale, what is the hottest chemical?", 2, "Capsaicin", "Resiniferatoxin", "Dihydrocapsaicin", "Tinyatoxin"));


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
            Intent intent  = new Intent(Nature_20_hard.this,MainActivity.class);
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
