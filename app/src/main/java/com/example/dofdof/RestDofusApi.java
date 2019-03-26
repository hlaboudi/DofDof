package com.example.dofdof;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestDofusApi {
    @GET("famillier")
    Call<RestDofusResponse> getListDofus();

}
