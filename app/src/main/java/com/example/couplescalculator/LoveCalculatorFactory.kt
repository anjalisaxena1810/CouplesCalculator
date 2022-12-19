package com.example.couplescalculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoveCalculatorFactory (val repository: LoveCalculatorRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoveCalculatorViewModel::class.java)){
            return LoveCalculatorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}