package com.example.dofdof.Controller;

import com.example.dofdof.Model.Pets;
import com.example.dofdof.Model.RestDofusApi;
import com.example.dofdof.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart()
    {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dofapi2.herokuapp.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        RestDofusApi restDofusApi = retrofit.create(RestDofusApi.class);

        Call<ArrayList<Pets>> call = restDofusApi.getListDofus();
        call.enqueue(new Callback<ArrayList<Pets>>() {
            @Override
            public void onResponse(Call<ArrayList<Pets>> call, Response<ArrayList<Pets>> response) {
                if(response.isSuccessful()){
                    activity.initFragments(response.body());
                } else{
                    // response.code();
                }
            }
            public void onFailure(Call<ArrayList<Pets>> call, Throwable t) {
            }
        });


    }
}
