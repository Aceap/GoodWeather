package com.aceap.goodweather.logic

import androidx.lifecycle.liveData
import com.aceap.goodweather.logic.model.Place
import com.aceap.goodweather.logic.network.GoodWeatherNetWork

object Repository {
    fun searchPlaces(query: String) = liveData {
        val result = try {
            val placeResponse = GoodWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}