package com.example.couplescalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.couplescalculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityHistoryBinding
    private  lateinit var factory: LoveCalculatorFactory
    private  lateinit var viewModel: LoveCalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_history)

        factory=  LoveCalculatorFactory(LoveCalculatorRepository())
        viewModel = ViewModelProvider(this,factory)[LoveCalculatorViewModel::class.java]
    }
}