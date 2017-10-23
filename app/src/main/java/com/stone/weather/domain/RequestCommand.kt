package com.stone.weather.domain

import com.stone.weather.bean.ForecastRequest

/**
 * Created by jiayuanbin on 2017/9/4.
 */
class RequestCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.doRequest())
    }

}