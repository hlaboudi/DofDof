package com.example.dofdof.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dofdof.R;

public class SplashActivity extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.splashOut(2000);
    }
    private void splashOut(final int timeMs){
        new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                while(System.currentTimeMillis()-start<timeMs);
                goOut();
            }
        }).start();
    }
    private void goOut(){
        startActivity(new Intent(this,MainActivity.class));
    }
}
