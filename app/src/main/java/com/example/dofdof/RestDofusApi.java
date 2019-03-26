package com.example.dofdof.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestDofusApi {
    @GET("pets")
    Call<List<com.example.dofdof.Model.Pets>> getListDofus();

}
