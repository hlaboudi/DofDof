package com.example.dofdof.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dofdof.R;

public class MainActivity extends AppCompatActivity {

    private ImageView lancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lancer = findViewById(R.id.lancer);


        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), com.example.dofdof.View.Main2Activity.class);
                startActivity(otherActivity);
                finish();
            }
        });




    }
}
