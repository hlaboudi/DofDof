package com.example.dofdof;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestDofusApi {
    @GET("pets")
    Call<List<Pets>> getListDofus();

}
