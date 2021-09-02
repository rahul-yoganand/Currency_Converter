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
        btnChange = findViewById(R.id.button2)
        tvResult = findViewById(R.id.textView)
        etDollars = findViewById(R.id.inputValue)
        val mViewModel: CurrencyViewModel =
            ViewModelProvider(this).get(
                CurrencyViewModel::class.java
            )
        etDollars.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mViewModel.getFactor()
                    .observe(this@MainActivity, Observer<Double> { conversionfactor ->
                        tvResult.text =
                            (conversionfactor * (etDollars.text.toString().toDouble())).toString()
                    })
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }

        )

        btnChange.setOnClickListener {
            mViewModel.setValue()
        }

    }
}