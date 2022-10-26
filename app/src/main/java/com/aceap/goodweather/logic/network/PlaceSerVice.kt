package com.aceap.goodweather.logic.network

import com.aceap.goodweather.GoodWeatherApplication
import com.aceap.goodweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceSerVice {
    @GET("v2/place?token=${GoodWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}