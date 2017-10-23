package com.stone.wechatcleaner.domain

/**
 * Created by jiayuanbin on 2017/9/4.
 */

data class ForecastList(val city: String, val country: String,
                        private val dailyForecast: List<Forecast>) {
    //do sth cute 重载操作符
    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String, val description: String,
                    val high: Int, val low: Int, val iconUrl: String)