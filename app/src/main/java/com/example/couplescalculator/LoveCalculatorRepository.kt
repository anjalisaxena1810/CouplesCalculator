package com.example.couplescalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.couplescalculator.ApiUtil.RetrofitInstance
import com.example.couplescalculator.Model.Percentage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorRepository {
    val percent = MutableLiveData<Percentage>()
    var isLoading = MutableLiveData<Boolean>()

    fun getPercentage(fname:String, sname:String): MutableLiveData<Percentage> {
        val call = RetrofitInstance.endUrl.getPercentage(fname, sname)
        call.enqueue(object : Callback<Percentage> {
            override fun onResponse(call: Call<Percentage>, response: Response<Percentage>) {
                if(response.isSuccessful){
                    isLoading.postValue(false)
                    val body  = response.body()
                    percent.value = body!!

                }else{
                    isLoading.postValue(false)
                    Log.d("Error", "onResponse: " + response.message())
                }
            }

            override fun onFailure(call: Call<Percentage>, t: Throwable) {
                Log.d("FAIL", "onFailure: " + t.message)
            }
        })
        return percent
    }
}