package com.aceap.goodweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class GoodWeatherApplication: Application() {
    companion object {
        const val TOKEN = "YjlfUg6DuVvvZld6"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}