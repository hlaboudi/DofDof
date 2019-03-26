package com.example.dofdof.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.dofdof.R;

public class SplashActivity extends AppCompatActivity {

    private  static int SplashTimeOut = 4000;
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( SplashActivity.this, com.example.dofdof.View.MainActivity.class);
                startActivity(i);
            }
        },SplashTimeOut);
    }

}
