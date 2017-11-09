package com.stone.weather.base

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by sunnyxibei on 17-11-8.
 */
class App : Application() {


    // define application instance
    companion object {
        private var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}