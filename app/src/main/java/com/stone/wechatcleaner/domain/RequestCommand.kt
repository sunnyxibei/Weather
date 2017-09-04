package com.stone.wechatcleaner.domain

import com.stone.wechatcleaner.bean.ForecastRequest

/**
 * Created by jiayuanbin on 2017/9/4.
 */
class RequestCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.doRequest())
    }

}