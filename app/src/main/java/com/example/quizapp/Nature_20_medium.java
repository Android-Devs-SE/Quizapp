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

public class Nature_20_medium extends AppCompatActivity {
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
                "Which of these stars is the largest?", 2, "VY Canis Majoris", "UY Scuti", "Betelgeuse", "RW Cephei"));

        qlist.add(new ComicsModel(
                "Which element has the atomic number of 7?", 1, "Nitrogen", "Oxygen", "Hydrogen", "Neon"));

        qlist.add(new ComicsModel(
                "Au on the Periodic Table refers to which element?", 3, "Silver", "Oxygen", "Gold", "Nickel"));

        qlist.add(new ComicsModel(
                "How many officially recognized dwarf planets in the solar system are named after Polynesian deities?", 3, "0", "1", "2", "5"));

        qlist.add(new ComicsModel(
                "The 'Tibia' is found in which part of the body?", 3, "Arm", "Hand", "Leg", "Head"));

        qlist.add(new ComicsModel(
                "What is the atomic number of the element Strontium?", 1, "38", "73", "47", "11"));

        qlist.add(new ComicsModel(
                "Which part of the body does glaucoma affect?", 3, "Throat", "Stomach", "Eyes", "Blood"));

        qlist.add(new ComicsModel(
                "What term is best associated with Sigmund Freud?", 1, "Psychoanalysis", "Cognitive-Behavioral Therapy", "Theory of Gravity", "Dialectical Behavior Therapy"));

        qlist.add(new ComicsModel(
                "Which of these is a type of stretch/deep tendon reflex?", 3, "Gag reflex", "Pupillary light reflex", "Ankle jerk reflex", "Scratch reflex"));

        qlist.add(new ComicsModel(
                "Deuterium is an isotope of which element?", 4, "Nitrogen", "Helium", "Neon", "Hydrogen"));

        qlist.add(new ComicsModel(
                "A positron is an antiparticle of a what?", 2, "Neutron", "Electron", "Proton", "Photon"));

        qlist.add(new ComicsModel(
                "What is the unit of electrical capacitance?", 4, "Gauss", "Henry", "Watt", "Farad"));

        qlist.add(new ComicsModel(
                "In Psychology, which need appears highest in the 'Maslow's hierarchy of needs' pyramid?", 1, "Esteem", "Love", "Safety", "Physiological"));

        qlist.add(new ComicsModel(
                "The Sun consists of mostly which two elements?", 4, "Hydrogen & Nitrogen", "Carbon & Nitrogen", "Carbon & Helium", "Hydrogen & Helium"));

        qlist.add(new ComicsModel(
                "What part of the brain takes its name from the Greek for seahorse?", 2, "Cerebellum", "Hippocampus", "Thalamus", "Amygdala"));

        qlist.add(new ComicsModel(
                "Which of the following men does not have a chemical element named after him?", 3, "Albert Einstein", "Niels Bohr", "Sir Isaac Newton", "Enrico Fermi"));

        qlist.add(new ComicsModel(
                "What is the half-life of Uranium-235?", 1, "703,800,000 years", "4,300,400,000 years", "1,260,900,000 years", "Uranium-235 is a stable isotope"));

        qlist.add(new ComicsModel(
                "In human biology, a circadium rhythm relates to a period of roughly how many hours?", 1, "24", "8", "16", "32"));

        qlist.add(new ComicsModel(
                "What is the name of the cognitive bias wherein a person with low ability in a particular skill mistake themselves as being superior?", 4, "Meyers-Briggs effect", "Müller-Lyer effect", "Freud-Hall effect", "Dunning-Kruger effect"));

        qlist.add(new ComicsModel(
                "When was the first mammal successfully cloned?", 3, "2009", "1999", "1996", "1985"));


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
            Intent intent  = new Intent(Nature_20_medium.this,MainActivity.class);
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
