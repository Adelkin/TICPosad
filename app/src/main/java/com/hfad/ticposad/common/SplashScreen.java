package com.hfad.ticposad.common;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hfad.ticposad.Dashboard;
import com.hfad.ticposad.R;


public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 5000;

    //Variables
    Animation topAnim;
    ImageView image;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Убрать верхнюю строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);


        //Hooks
        image = findViewById(R.id.imageView);
        image.setAnimation(topAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class); //если шо
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class); //если шо
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_SCREEN_TIME_OUT);








    }
}