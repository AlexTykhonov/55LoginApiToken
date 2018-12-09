package com.tae.a55loginapitoken.Controller;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    static final String BASE_URL = "https://petshop-server.herokuapp.com/";

    private static OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder() ;

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService (Class <S> serviceClass) {
        okHttpBuilder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = retrofitBuilder.client(okHttpBuilder.build()).build();
        return retrofit.create(serviceClass);
    }


}
