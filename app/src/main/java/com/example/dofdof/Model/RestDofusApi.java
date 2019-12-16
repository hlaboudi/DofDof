package com.example.dofdof.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestDofusApi {
    @GET("pets")
    Call<ArrayList<Pets>> getListDofus();

}
