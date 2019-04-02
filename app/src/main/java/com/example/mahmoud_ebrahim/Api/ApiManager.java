package com.example.mahmoud_ebrahim.Api;

import android.util.Log;

import com.example.mahmoud_ebrahim.Api.ApiServices;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static Retrofit retrofitInstance;

   private static Retrofit getInstance(){
       HttpLoggingInterceptor httpLoggingInterceptor
               =new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
           @Override
           public void log(String message) {
               Log.i("api", message);
           }
       });
       OkHttpClient client=new OkHttpClient.Builder()
               .addInterceptor(httpLoggingInterceptor)
               .build();

       retrofitInstance=  new Retrofit.Builder()
               .client(client)
               .baseUrl("http://api.mp3quran.net/radios/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       return retrofitInstance;
   }

   public static ApiServices getApis(){
       return getInstance().create(ApiServices.class);
   }
}
