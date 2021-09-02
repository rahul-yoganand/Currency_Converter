package com.example.currencyconverter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var btnConvert: Button
    lateinit var btnChange: Button
    lateinit var tvResult: TextView
    lateinit var etDollars: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConvert = findViewById(R.id.button)
        btnChange = findViewById(R.id.button2)
        tvResult = findViewById(R.id.textView)
        etDollars = findViewById(R.id.inputValue)
        val mViewModel: CurrencyViewModel =
            ViewModelProvider(this).get(
                CurrencyViewModel::class.java
            )
            tvResult.text = (mViewModel.getFactor().value!! * etDollars.text.toString().toDouble()).toString()

        btnChange.setOnClickListener {
            mViewModel.setValue()
        }
        btnConvert.setOnClickListener {
            mViewModel.getFactor().observe(this,Observer<Double> { conversionfactor ->
                tvResult.text=(conversionfactor*(etDollars.text.toString().toDouble())).toString()
            })

        }

    }
}