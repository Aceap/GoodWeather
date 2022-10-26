package com.aceap.goodweather.logic.network

import com.aceap.goodweather.GoodWeatherApplication
import com.aceap.goodweather.logic.model.DailyResponse
import com.aceap.goodweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.6/${GoodWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealTimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String,
    ): Call<RealtimeResponse>

    @GET("v2.6/${GoodWeatherApplication.TOKEN}/{lng},{lat}/daily?dailysteps=1")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>
}