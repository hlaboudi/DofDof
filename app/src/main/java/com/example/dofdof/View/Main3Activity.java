package com.example .dofdof.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dofdof.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intent();
    }

    private void intent() {
        if (getIntent().hasExtra("pet_name") && getIntent().hasExtra("pet_desc") && getIntent().hasExtra("pet_image"))  {
            String name = getIntent().getStringExtra("pet_name");
            String desc = getIntent().getStringExtra("pet_desc");
            String image = getIntent().getStringExtra("pet_image");

            petInformations(name, desc, image);

        }
    }

    private void petInformations(String pet_name, String pet_desc, String pet_image) {

        TextView nom = findViewById(R.id.pet_name);
        nom.setText(pet_name);

        TextView desc = findViewById(R.id.pet_desc);
        desc.setText(pet_desc);

        ImageView image = findViewById(R.id.pet_image);
        Glide.with(this).asBitmap().load(pet_image).into(image);
    }
}
