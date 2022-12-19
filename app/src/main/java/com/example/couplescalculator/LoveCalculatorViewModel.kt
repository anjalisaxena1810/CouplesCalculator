package com.example.couplescalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.couplescalculator.Model.Percentage

class LoveCalculatorViewModel (val repository: LoveCalculatorRepository): ViewModel() {

    var percent = MutableLiveData<Percentage>()
    var isLoading: MutableLiveData<Boolean> =repository.isLoading.apply{
        postValue(true)
    }

    fun getPercentage(fname:String,sname:String): LiveData<Percentage> {
        percent =repository.getPercentage(fname, sname)
        return percent
    }
}