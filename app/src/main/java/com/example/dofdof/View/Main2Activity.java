package com.example.dofdof.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dofdof.Controller.MainController;
import com.example.dofdof.Controller.My_Adapter;
import com.example.dofdof.Model.Pets;
import com.example.dofdof.R;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();


        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView





    }

    public void showList(List<Pets> listPets) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new My_Adapter(listPets,this);
        recyclerView.setAdapter(mAdapter);
    }
}
