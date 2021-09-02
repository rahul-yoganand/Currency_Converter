package com.example.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CurrencyViewModel: ViewModel() {
    private var conversionFactor=70.00
    private var convertedValue=0.00

    fun convert(dollars:Double){
        if(dollars!=null)
        convertedValue=dollars*conversionFactor
    }
    fun getValue(): Double {
        return convertedValue
    }






}