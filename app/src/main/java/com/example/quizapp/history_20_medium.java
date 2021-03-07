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

public class history_20_medium extends AppCompatActivity {
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
                "What disease crippled President Franklin D. Roosevelt and led him to help the nation find a cure? ", 4, "Cancer", "Meningitis", "HIV", "Polio"));

        qlist.add(new ComicsModel(
                "In relation to the British Occupation in Ireland, what does the IRA stand for.", 3, "Irish Rebel Alliance", "Irish Reformation Army", "Irish Republican Army", "Irish-Royal Alliance"));

        qlist.add(new ComicsModel(
                "The crown of the Empire State Building was originally built for what purpose?", 1, "Airship Dock", "Lightning Rod", "Antennae", "Flag Pole"));

        qlist.add(new ComicsModel(
                "On which day did the attempted coup d'etat of 1991 in the Soviet Union begin?", 2, "August 21", "August 19", "December 26", "December 24"));

        qlist.add(new ComicsModel(
                "In the War of the Pacific (1879 - 1883), Bolivia lost its access to the Pacific Ocean after being defeated by which South American country?", 4, "Peru", "Brazil", "Argentina", "Chile"));

        qlist.add(new ComicsModel(
                "In what year was the video game company Electronic Arts founded?", 1, "1982", "1999", "1981", "2005"));

        qlist.add(new ComicsModel(
                "Who tutored Alexander the Great?", 1, "Aristotle", "Socrates", "Plato", "King Philip"));

        qlist.add(new ComicsModel(
                "What nationality was sultan Saladin?", 1, "Kurdish", "Arab", "Egyptian", "Syrian"));

        qlist.add(new ComicsModel(
                "Which WWII tank ace is credited with having destroyed the most tanks?", 1, "Kurt Knispel", "Michael Wittmann", "Walter Kniep", "Otto Carius"));

        qlist.add(new ComicsModel(
                "What was the transfer of disease, crops, and people across the Atlantic shortly after the discovery of the Americas called?", 4, "Triangle Trade", "Transatlantic Slave Trade", "The Silk Road", "The Columbian Exchange"));

        qlist.add(new ComicsModel(
                "When Christopher Columbus sailed to America, what was the first region he arrived in?", 3, "Florida", "Isthmus of Panama", "The Bahamas Archipelago", "Nicaragua"));

        qlist.add(new ComicsModel(
                "When did the United States formally declare war on Japan, entering World War II?", 1, "December 8, 1941", "June 6, 1944", "June 22, 1941", "September 1, 1939"));

        qlist.add(new ComicsModel(
                "Who was the first president born in the independent United States?", 3, "John Adams", "George Washington", "Martin Van Buren", "James Monroe "));

        qlist.add(new ComicsModel(
                "In what year did the First World War end?", 4, "1914", "1916", "1912", "1918"));

        qlist.add(new ComicsModel(
                "In which year was Constantinople conquered by the Turks?", 3, "1435", "1454", "1453", "1440"));

        qlist.add(new ComicsModel(
                "In 1845, a series of wars named after which indigenous people began in New Zealand?", 1, "Māori", "Papuans", "Aborigines", "Polynesians"));

        qlist.add(new ComicsModel(
                "What happened on June 6, 1944?", 3, "Atomic bombings of Hiroshima and Nagasaki", "Attack on Pearl Harbor", "D-Day", "The Liberation of Paris"));

        qlist.add(new ComicsModel(
                "When did the Crisis of the Third Century begin?", 4, "235 BC", "242 AD", "210 AD", "235 AD"));

        qlist.add(new ComicsModel(
                "When did O, Canada officially become the national anthem?", 2, "1950", "1980", "1920", "1880"));

        qlist.add(new ComicsModel(
                "After his loss at the Battle of Waterloo, Napoleon Bonaparte was exiled to which island?", 3, "Elba", "Corsica", "St. Helena", "Canary"));


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
            Intent intent  = new Intent(history_20_medium.this,MainActivity.class);
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
