package com.example.couplescalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.couplescalculator.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var factory: LoveCalculatorFactory
    private  lateinit var viewModel: LoveCalculatorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding  = DataBindingUtil.setContentView(this,R.layout.activity_main)
        factory=  LoveCalculatorFactory(LoveCalculatorRepository())
        viewModel = ViewModelProvider(this,factory)[LoveCalculatorViewModel::class.java]


        binding.btnCalculate.setOnClickListener {
            intent = Intent(this@MainActivity,ResultActivity::class.java)
            val loveData:LoveData = LoveData(binding.etYourName.text.toString(),binding.etPartnerName.text.toString())
            intent.putExtra("jsonData", Gson().toJson(loveData))
            startActivity(intent)

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.history->{
                var intent = Intent(this@MainActivity,HistoryActivity::class.java)
                startActivity(intent)

            }

            R.id.quotes->{
                var intent = Intent(this@MainActivity,quotesActivity::class.java)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }

}