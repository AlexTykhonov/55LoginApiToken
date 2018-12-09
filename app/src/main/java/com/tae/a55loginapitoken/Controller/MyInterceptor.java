package com.tae.a55loginapitoken.Controller;

import com.tae.a55loginapitoken.PreferenceManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class MyInterceptor implements Interceptor {

   PreferenceManager preferenceManager;

    @Override
    public Response intercept(Chain chain) throws IOException {

        preferenceManager = new PreferenceManager();
        Request original = chain.request();
        Request.Builder requestBuilder;

        if(original.url().equals("https://petshop-server.herokuapp.com/auth")){
            requestBuilder = original.newBuilder();
        } else {
   if (PreferenceManager.getAuth()!=null){requestBuilder = original.newBuilder()
                    .header("Token", PreferenceManager.getAuth());
            System.out.println(PreferenceManager.getAuth());}
            else {requestBuilder = original.newBuilder();}
        }
        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}
