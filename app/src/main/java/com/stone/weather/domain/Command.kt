package com.stone.weather.domain

/**
 * Created by jiayuanbin on 2017/9/4.
 */
public interface Command<out T> {
    fun execute(): T
}