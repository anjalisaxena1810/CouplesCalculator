package com.example.couplescalculator.Url

import com.example.couplescalculator.Model.Percentage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EndUrl {

    @GET("/getPercentage")
    @Headers("X-RapidAPI-Key: bbe094dd5emshd8b260b843ed1ddp159a63jsn43eb2d7beefb")

    fun getPercentage(
        @Query("fname") fname:String, @Query("sname") sname:String): Call<Percentage>
}