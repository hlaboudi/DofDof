package com.example.dofdof.Controller;

import com.example.dofdof.Model.Pets;
import com.example.dofdof.Model.RestDofusApi;
import com.example.dofdof.View.Main2Activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private Main2Activity activity;

    public MainController(Main2Activity main2Activity) {
        this.activity = main2Activity;
    }

    public void onStart()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dofapi2.herokuapp.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        RestDofusApi restDofusApi = retrofit.create(RestDofusApi.class);

        Call<List<Pets>> call = restDofusApi.getListDofus();
        call.enqueue(new Callback<List<Pets>>() {
            @Override
            public void onResponse(Call<List<Pets>> call, Response<List<Pets>> response) {
                List<Pets> listPets = response.body();
                activity.showList(listPets);
            }

            @Override
            public void onFailure(Call<List<Pets>> call, Throwable t) {
            }
        });


    }
}
