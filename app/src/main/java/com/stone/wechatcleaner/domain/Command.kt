package com.stone.wechatcleaner.domain

/**
 * Created by jiayuanbin on 2017/9/4.
 */
public interface Command<out T> {
    fun execute(): T
}