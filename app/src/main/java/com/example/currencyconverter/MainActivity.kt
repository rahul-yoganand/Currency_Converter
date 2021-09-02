package com.example.currencyconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
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
        etDollars.addTextChangedListener {object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                mViewModel.getFactor()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        }

        }

        tvResult.text =
            (mViewModel.getFactor().value!! * etDollars.text.toString().toDouble()).toString()

        btnChange.setOnClickListener {
            mViewModel.setValue()
        }
        btnConvert.setOnClickListener {
            mViewModel.getFactor().observe(this, Observer<Double> { conversionfactor ->
                tvResult.text =
                    (conversionfactor * (etDollars.text.toString().toDouble())).toString()
            })

        }

    }
}