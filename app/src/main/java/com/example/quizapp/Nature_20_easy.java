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

public class Nature_20_easy extends AppCompatActivity {

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
                    "Which of the following bones is not in the leg?", 3, "Patella", "Tibia", "Radius", "Fibula "));

            qlist.add(new ComicsModel(
                    "What is the largest animal currently on Earth?", 4, "Orca", "Colossal Squid", "Giraffe", "Blue Whale"));

            qlist.add(new ComicsModel(
                    "This element, when overcome with extreme heat and pressure, creates diamonds.", 2, "Nitrogen", "Carbon", "Oxygen", "Hydrogen"));

            qlist.add(new ComicsModel(
                    "What is the elemental symbol for mercury?", 1, "Hg", "Me", "Mc", "Hy"));

            qlist.add(new ComicsModel(
                    "How many planets are in our Solar System?", 4, "Nine", "Seven", "Ten", "Eight"));

            qlist.add(new ComicsModel(
                    "Which gas forms about 78% of the Earth’s atmosphere?", 3, "Oxygen", "Argon", "Nitrogen", "Carbon Dioxide"));

            qlist.add(new ComicsModel(
                    "What is the standard SI unit for temperature?", 1, "Kelvin", "Fahrenheit", "Celsius", "Rankine"));

            qlist.add(new ComicsModel(
                    "Which of the following blood vessels carries deoxygenated blood?", 2, "Pulmonary Vein", "Pulmonary Artery", "Aorta", "Coronary Artery"));

            qlist.add(new ComicsModel(
                    "What is the primary addictive substance found in tobacco?", 3, "Cathinone", "Ephedrine", "Nicotine", "Glaucine"));

            qlist.add(new ComicsModel(
                    "What was the name of the first artificial Earth satellite, launched by the Soviet Union in 1957?", 3, "Soyuz 7K-OK", "Zenit-2", "Sputnik 1", "Voskhod 3KV"));

            qlist.add(new ComicsModel(
                    "How many bones are in the human body?", 4, "203", "209", "200", "206"));

            qlist.add(new ComicsModel(
                    "Who is the chemical element Curium named after?", 2, "The Curiosity Rover", "Marie & Pierre Curie", "Curious George", "Stephen Curry"));

            qlist.add(new ComicsModel(
                    "The asteroid belt is located between which two planets?", 2, "Jupiter and Saturn", "Mars and Jupiter", "Mercury and Venus", "Earth and Mars"));

            qlist.add(new ComicsModel(
                    "The biggest distinction between a eukaryotic cell and a prokaryotic cell is:", 2, "The overall size", "The presence or absence of a nucleus", "The presence or absence of certain organelles", "The mode of reproduction"));

            qlist.add(new ComicsModel(
                    "How many chromosomes are in your body cells?", 4, "21", "22", "24", "23"));

            qlist.add(new ComicsModel(
                    "71% of the Earth's surface is made up of", 2, "Deserts", "Water", "Continents", "Forests"));

            qlist.add(new ComicsModel(
                    "What does LASER stand for?", 4, "Lite analysing by stereo ecorazer", "Light amplifier by standby energy of radio", "Life antimatter by standing entry of range", "Light amplification by stimulated emission of radiation"));

            qlist.add(new ComicsModel(
                    "What is the unit of electrical resistance?", 1, "Ohm", "Mho", "Tesla", "Joule"));

            qlist.add(new ComicsModel(
                    "What lies at the center of our galaxy?", 1, "A black hole", "A wormhole", "A supernova", "A quasar"));

            qlist.add(new ComicsModel(
                    "Which of these Elements is a metalloid?", 3, "Tin", "Bromine", "Antimony", "Rubidium"));


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
                Intent intent  = new Intent(Nature_20_easy.this,MainActivity.class);
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


