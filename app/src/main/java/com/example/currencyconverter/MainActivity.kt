package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var btnConvert:Button
    lateinit var tvResult:TextView
    lateinit var etDollars:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConvert=findViewById(R.id.button)
        tvResult=findViewById(R.id.textView)
        etDollars=findViewById(R.id.inputValue)
         val mViewModel:CurrencyViewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        tvResult.text=mViewModel.getValue().toString()

        btnConvert.setOnClickListener {
            mViewModel.convert(etDollars.text.toString().toDouble())
            tvResult.text=mViewModel.getValue().toString()

        }

    }
}