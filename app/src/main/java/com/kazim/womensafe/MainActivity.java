package com.kazim.womensafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    private static int SPLASH_SCREEN_TIME_OUT=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logo = (ImageView)findViewById(R.id.logo);
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        logo.startAnimation(aniFade);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent UserLogin=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(UserLogin);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
}