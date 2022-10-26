package com.aceap.goodweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.aceap.goodweather.logic.model.Weather
import com.aceap.goodweather.logic.network.GoodWeatherNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
        val placeResponse = GoodWeatherNetWork.searchPlaces(query)
        if (placeResponse.status == "ok") {
            val places = placeResponse.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
    }


    fun refreshWeather(lng: String, lat: String) = fire(Dispatchers.IO) {
        coroutineScope {
            Log.d("repository", "refreshWeather: begin")
            val deferredRealtime = async {
                Log.d("repository", "realtime begin")
                GoodWeatherNetWork.getRealtimeWeather(lng, lat)
            }
            val deferredDaily = async {
                Log.d("repository", "daily begin")
                GoodWeatherNetWork.getDailyWeather(lng, lat)
            }
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()
            Log.d("repository", "refreshWeather: $realtimeResponse, $dailyResponse")
            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
                val weather = Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
                Log.d("repository", "refreshWeather: $weather")
                Result.success(weather)
            } else {
                Log.d("repository", "refreshWeather: failure")
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${realtimeResponse.status}" + "daily response status is ${dailyResponse.status}"
                    )
                )
            }
        }

    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}