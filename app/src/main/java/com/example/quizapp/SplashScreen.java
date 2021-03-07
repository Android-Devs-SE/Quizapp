package com.example.quizgitfinale;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =  new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT );
    }
}