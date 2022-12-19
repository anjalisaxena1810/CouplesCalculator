package com.example.couplescalculator

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.couplescalculator.databinding.ActivityResultBinding
import com.google.gson.Gson

class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding
    private  lateinit var factory: LoveCalculatorFactory
    private  lateinit var viewModel: LoveCalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_result)
        factory=  LoveCalculatorFactory(LoveCalculatorRepository())
        viewModel = ViewModelProvider(this,factory)[LoveCalculatorViewModel::class.java]


        val dataInString = intent.getStringExtra("jsonData")
        val lovedata = Gson().fromJson<LoveData>(dataInString, LoveData::class.java)




        var progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait...")
        viewModel.isLoading.observe(this, Observer {
            if (it) progressDialog.show()
            else progressDialog.hide()
        })

        viewModel.getPercentage(lovedata.yourName, lovedata.partnerName).observe(this, Observer {

                binding.progressText.text = it.percentage.toString() +"%"
                binding.firstName.text = it.yourName
                binding.secondName.text =it.partnerName
                binding.resultText.text = it.result



            binding.againBtn.setOnClickListener {
              val intent = Intent(this@ResultActivity,MainActivity::class.java)
                startActivity(intent)
            }



//                binding.tvAllDetails.text =
//                    "Your Name: " + it.yourName + "\n" +
//                            "Partner Name: " + it.partnerName + "\n" +
//                            "Love Percentage: " + it.percentage + "\n" +
//                            "Result: " + it.result
            })
    }
}