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

public class VideoGames_20_medium extends AppCompatActivity {
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

        qlist.add(new ComicsModel(
                "Capcom's survival horror title Dead Rising, canonically starts on what day of September 2006?", 1, "September 19th", "September 21st", "September 30th", "September 14th"));

        qlist.add(new ComicsModel(
                "In Need For Speed Most Wanted (2005), what do you drive at the beginning of the career mode?", 3, "Porsche 911 Turbo", "Nissan 240SX", "BMW M3 GTR", "Ford Mustang"));

        qlist.add(new ComicsModel(
                "In 'Overwatch', what is the name of Mercy's 'ultimate ability'?", 3, "Earthshatter", "Rocket Barrage", "Valkyrie", "Molten Core"));

        qlist.add(new ComicsModel(
                "Mirror's Edge Catalyst takes place in the City of...?", 4, "Mirrors", "Purity", "Diamonds", "Glass"));

        qlist.add(new ComicsModel(
                "In Monster Hunter Generations, which of the following monsters are a part of the 'Fated Four'?", 1, "Astalos", "Gore Magala", "Malfestio", "Arzuros"));

        qlist.add(new ComicsModel(
                "In the original DOOM games, which of the following demons is a recolor of the Baron of Hell, but is weaker than the Baron?", 2, "Mancubus", "Hell Knight", "Pinky", "Arch-Vile"));

        qlist.add(new ComicsModel(
                "Which one of these games wasn't released in 2016?", 4, "Tom Clancy's The Division", "Killing Floor 2", "Hitman", "Metal Gear Solid V"));

        qlist.add(new ComicsModel(
                "In the Portal series of games, who was the founder of Aperture Science?", 1, "Cave Johnson", "GLaDOs", "Wallace Breen", "Gordon Freeman"));

        qlist.add(new ComicsModel(
                "In what year were screenshots added to Steam?", 2, "2010", "2011", "2008", "2009"));

        qlist.add(new ComicsModel(
                "In which year did the first Monster Hunter game get released?", 2, "2006", "2004", "2005", "2002"));

        qlist.add(new ComicsModel(
                "On the 6th of June 2006, what was the name of the infamous glitch that occurred in the MMO RuneScape?", 3, "Noclip glitch", "Party-hat Duplication Glitch", "The Falador Massacre", "TzHaar Massacre"));

        qlist.add(new ComicsModel(
                "What was the original name of  'Minecraft'?", 3, "Minecraft: Order of the Stone", "Dig And Build", "Cave Game", "Infiniminer"));

        qlist.add(new ComicsModel(
                "The cake depicted in Valve's 'Portal' franchise most closely resembles which real-world type of cake?", 2, "Devil's Food", "Black Forest", "Molten Chocolate", "German Chocolate"));

        qlist.add(new ComicsModel(
                "In 'The Binding of Isaac', what is the name of the final boss that you fight in The Void?", 3, "Mega Satan", "Hush", "Delirium", "The Lamb"));

        qlist.add(new ComicsModel(
                "Which country was Eliza 'Ash' Cohen from 'Tom Clancy's Rainbow Six Siege' born in?", 1, "Israel", "United States of America", "Mexico", "Canada"));

        qlist.add(new ComicsModel(
                "Which of the following Copy Abilities was only featured in 'Kirby & The Amazing Mirror'?", 2, "Magic", "Mini", "Smash", "Missile"));

        qlist.add(new ComicsModel(
                "In the game Pokemon Conquest, which warlord is able to bond with Zekrom and a shiny Rayquazza?", 2, "The Player", "Nobunaga", "Oichi", "Hideyoshi"));

        qlist.add(new ComicsModel(
                "In the game 'Brawlhalla', what species is the character B�dvar is?", 4, "A Human", "Half Wolf / Half Bear", "Half Tiger /  Half Human", "Half Human / Half Bear"));

        qlist.add(new ComicsModel(
                "In which location does Dark Sun Gwyndolin reside in 'Dark Souls'?", 1, "Anor Londo", "Firelink Shrine", "Blighttown", "Kiln of the first flame"));

        qlist.add(new ComicsModel(
                "What is the name of the first level in 'Call of Duty: World at War'?", 1, "Semper Fi", "Ring of Steel", "Vendetta", "Eviction"));

        qlist.add(new ComicsModel(
                "How many unique items does 'Borderlands 2' claim to have?", 4, "87 Million", "87 Trillion", "87 Gazillion ", "87 Bazillion "));

        qlist.add(new ComicsModel(
                "In the 'Call Of Duty: Zombies' map 'Origins', how many numbered power generators are there?", 2, "8", "6", "5", "3"));

        qlist.add(new ComicsModel(
                "How many games are there in the 'Colony Wars' series for the PlayStation?", 1, "3", "2", "4", "5"));

        qlist.add(new ComicsModel(
                "In Grand Theft Auto: V, what wanted level does the player receive if they enter Zancudo Army Base north of Los Santos?", 1, "4", "3", "5", "1"));

        qlist.add(new ComicsModel(
                "In Kingdom Hearts which of the following people can NOT wield a keyblade?", 2, "Xehanort", "Larxene", "Lea", "Mickey"));

        qlist.add(new ComicsModel(
                "Who is credited with having created the world's first video game Easter Egg?", 4, "Julius Smith", "Will Crowther", "Don Woods", "Warren Robinett"));

        qlist.add(new ComicsModel(
                "What numbers did Sayaka Maizono write on the wall in Dangan Ronpa Trigger Happy Havoc?", 1, "11037", "4, 8, 15, 16, 23, 42", "55730", "3, 9, 11, 12, 15, 17,"));

        qlist.add(new ComicsModel(
                "Who was Tetris created by?", 4, "Toru Iwatani", "Allan Alcorn", "William Higinbotham", "Alexey Pajitnov"));

        qlist.add(new ComicsModel(
                "Who is Sora's Nobody in Kingdom Hearts?", 2, "Riku", "Roxas", "Kairi", "Mickey"));

        qlist.add(new ComicsModel(
                "During the events of Half-Life: Opposing Force, what is the age of Adrian Shephard, the protagonist?", 1, "22", "23", "21", "24"));

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
            Intent intent  = new Intent(VideoGames_20_medium.this,MainActivity.class);
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
