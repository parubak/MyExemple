package com.example.myexemple;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils; //!!!!!!!!
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext() //import android.view.animation.AnimationUtils;
                ,R.anim.fadein);
//        imageView.startAnimation(animation);
        Animation animation2= AnimationUtils.loadAnimation(getApplicationContext() //import android.view.animation.AnimationUtils;
                ,R.anim.fadein_end);
        imageView.startAnimation(animation);





        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,Le_Petit_Prince.class);
                startActivity(intent);
                finish();
            }
        },5000);



    }
}
