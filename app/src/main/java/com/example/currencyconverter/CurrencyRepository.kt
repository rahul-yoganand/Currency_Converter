package com.example.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class CurrencyRepository {
    private val mConversionFactor=MutableLiveData<Double>(70.00)
    fun getFactor(): MutableLiveData<Double> {
        return mConversionFactor
    }
    fun setValue() {
        mConversionFactor.value=100.00
    }
}