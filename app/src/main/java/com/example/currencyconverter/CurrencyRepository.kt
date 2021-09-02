package com.example.currencyconverter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL


class CurrencyRepository {
    private val mConversionFactor=MutableLiveData<Double>(70.00)
    fun getFactor(): MutableLiveData<Double> {
        dataFromApi()
        //change the mConversionfactor else it will return the old value

        return mConversionFactor
    }
    fun setValue() {
        mConversionFactor.value=100.00
    }
    fun dataFromApi(){

        //we change the value of the factor and automatically the view gets updated
        var API =
            "https://api.exchangeratesapi.io/v1/latest?access_key=f26e9cf950b012caed9dc9c5f5d438c9&base=EUR&symbols=INR"
        GlobalScope.launch(Dispatchers.IO) {


            try {

                val apiResult = URL(API).readText()
                val jsonObject = JSONObject(apiResult)

                mConversionFactor.value =
                    jsonObject.getJSONObject("rates").getString("INR")
                        .toDouble()
                Log.d(CurrencyRepository::class.java.simpleName,"${mConversionFactor.value}")
            } catch (e: Exception) {
                Log.d(CurrencyRepository::class.java.simpleName,"Hello "+e)
            }
        }
    }
}