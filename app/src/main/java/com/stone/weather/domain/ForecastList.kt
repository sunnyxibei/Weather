package com.stone.weather.domain

/**
 * Created by jiayuanbin on 2017/9/4.
 */

data class ForecastList(val city: String, val country: String,
                        private val dailyForecastModel: List<ForecastModel>) {
    //do sth cute 重载操作符
    operator fun get(position: Int): ForecastModel = dailyForecastModel[position]

    fun size(): Int = dailyForecastModel.size
}

data class ForecastModel(val date: String, val description: String,
                         val high: Int, val low: Int, val iconUrl: String)