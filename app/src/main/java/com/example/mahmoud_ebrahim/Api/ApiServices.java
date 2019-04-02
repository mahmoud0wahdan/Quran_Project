package com.example.mahmoud_ebrahim.Api;

import com.example.mahmoud_ebrahim.Api.model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices  {

    @GET("radio_arabic.json")
    Call<RadiosResponse> getAllRadioChannals();
}
