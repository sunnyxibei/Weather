package com.stone.weather.base

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by sunnyxibei on 17-11-8.
 */
class App : Application() {


    // define application instance
    companion object {
<<<<<<< HEAD
        var instance: App by Delegates.notNull()
=======
        private var instance: App by Delegates.notNull()
>>>>>>> 06bf20e0537fc3d5c86b1f07695411059949210d
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}