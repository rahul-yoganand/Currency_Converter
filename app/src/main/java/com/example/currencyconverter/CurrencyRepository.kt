package com.example.currencyconverter

import androidx.lifecycle.MutableLiveData


class CurrencyRepository {
    private val mConversionFactor=MutableLiveData<Double>(70.00)
    fun getFactor(): MutableLiveData<Double> {
        return mConversionFactor
    }
    fun setValue() {
        if(mConversionFactor.value==70.00)
        mConversionFactor.value=100.00
        else
            mConversionFactor.value=70.00
    }
    fun dataFromApi(){
        //we change the value of the factor and automatically the view gets updated
    }
}