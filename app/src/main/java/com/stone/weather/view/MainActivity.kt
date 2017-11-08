package com.stone.weather.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.stone.weather.R
import com.stone.weather.domain.RequestCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = find<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //测试使用命令模式改造过后的请求
        doAsync {
            val forecastList = RequestCommand("100000").execute()
            uiThread {
                supportActionBar?.title = forecastList.country + "   " + forecastList.city
                recyclerView.adapter = MainAdapter(this@MainActivity,
                        forecastList, { toast(it.date + it.description) })
            }
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}