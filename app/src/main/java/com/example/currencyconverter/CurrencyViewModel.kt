package com.example.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CurrencyViewModel: ViewModel() {
    private var  mCurrencyRepository: CurrencyRepository= CurrencyRepository()
    fun getFactor():LiveData<Double> {
        return mCurrencyRepository.getFactor()
    }

        fun setValue(){
            mCurrencyRepository.setValue()

    }







}