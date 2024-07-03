package com.example.milkman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView txtSplash = findViewById(R.id.txtSplash);
        ImageView imgSplash = findViewById(R.id.imgSplash);


        Animation opacity = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.opacity);
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.zoom);


        imgSplash.setAnimation(opacity);
        txtSplash.setAnimation(opacity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}