package com.tae.a55loginapitoken.Controller;

import com.tae.a55loginapitoken.Pet;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {


    @POST("auth")
    Call<ResponseBody> login(@Body Login login);

    @GET("api")
    Call<List<Pet>> petList();
}
