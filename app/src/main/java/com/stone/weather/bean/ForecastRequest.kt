package com.stone.weather.bean

import com.google.gson.Gson
import java.net.URL

/**
 * Created by jiayuanbin on 2017/9/4.
 */
class ForecastRequest(private val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val HOST_URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$HOST_URL&APPID=$APP_ID&q="
    }

    fun doRequest(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}