package com.aceap.goodweather.logic.network

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    /*val BASE_URL = "https://api.caiyunapp.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(WeatherService::class.java)
    service.getRealTimeWeather("115.8580", "28.6830").enqueue(object : Callback<RealtimeResponse> {
        override fun onResponse(
            call: Call<RealtimeResponse>,
            response: Response<RealtimeResponse>
        ) {
            val body = response.body()
            if (body != null) {
                println(body)
            } else {
                println("is null")
            }
        }

        override fun onFailure(call: Call<RealtimeResponse>, t: Throwable) {
            println("failure")
            t.printStackTrace()
        }
    })*/


    /* val data = Repository.refreshWeather("115.8580", "28.6830")
     println(data.value)*/
    // 自定义格式化:
    val myDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS")
    println("DateTimeFormatter 自定义格式化: ${myDateTimeFormatter.format(LocalDateTime.now())}")

// 用自定义格式解析:
    val dt2 = LocalDateTime.parse("2020/11/30 15:16:17.123", myDateTimeFormatter)
    println("DateTimeFormatter 用自定义格式解析:  $dt2")

}