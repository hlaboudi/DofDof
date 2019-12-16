package com.example .dofdof.View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dofdof.R;

public class PetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        intent();
    }

    private void intent() {
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");
        String image = getIntent().getStringExtra("image");

        petInformations(name, desc, image);
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
