package com.example.couplescalculator.ApiUtil

import com.example.couplescalculator.Url.BaseUrl
import com.example.couplescalculator.Url.EndUrl
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofitInstance: Retrofit.Builder by lazy{
        Retrofit.Builder().baseUrl(BaseUrl.BASEURL).addConverterFactory(GsonConverterFactory.create(
            GsonBuilder().create()))
    }

    val endUrl: EndUrl by lazy{
        retrofitInstance.build().create(EndUrl::class.java)
    }
}