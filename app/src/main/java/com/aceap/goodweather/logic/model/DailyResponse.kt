package com.aceap.goodweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class DailyResponse(
    @SerializedName("api_status")
    val apiStatus: String,
    @SerializedName("api_version")
    val apiVersion: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("location")
    val location: List<Double>,
    @SerializedName("result")
    val result: Result,
    @SerializedName("server_time")
    val serverTime: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("tzshift")
    val tzshift: Int,
    @SerializedName("unit")
    val unit: String
) {
    data class Result(
        @SerializedName("daily")
        val daily: Daily,
        @SerializedName("primary")
        val primary: Int
    ) {
        data class Daily(
            @SerializedName("air_quality")
            val airQuality: AirQuality,
            @SerializedName("astro")
            val astro: List<Astro>,
            @SerializedName("cloudrate")
            val cloudrate: List<Cloudrate>,
            @SerializedName("dswrf")
            val dswrf: List<Dswrf>,
            @SerializedName("humidity")
            val humidity: List<Humidity>,
            @SerializedName("life_index")
            val lifeIndex: LifeIndex,
            @SerializedName("precipitation")
            val precipitation: List<Precipitation>,
            @SerializedName("precipitation_08h_20h")
            val precipitation08h20h: List<Precipitation08h20h>,
            @SerializedName("precipitation_20h_32h")
            val precipitation20h32h: List<Precipitation20h32h>,
            @SerializedName("pressure")
            val pressure: List<Pressure>,
            @SerializedName("skycon")
            val skycon: List<Skycon>,
            @SerializedName("skycon_08h_20h")
            val skycon08h20h: List<Skycon08h20h>,
            @SerializedName("skycon_20h_32h")
            val skycon20h32h: List<Skycon20h32h>,
            @SerializedName("status")
            val status: String,
            @SerializedName("temperature")
            val temperature: List<Temperature>,
            @SerializedName("temperature_08h_20h")
            val temperature08h20h: List<Temperature08h20h>,
            @SerializedName("temperature_20h_32h")
            val temperature20h32h: List<Temperature20h32h>,
            @SerializedName("visibility")
            val visibility: List<Visibility>,
            @SerializedName("wind")
            val wind: List<Wind>,
            @SerializedName("wind_08h_20h")
            val wind08h20h: List<Wind08h20h>,
            @SerializedName("wind_20h_32h")
            val wind20h32h: List<Wind20h32h>
        ) {
            data class AirQuality(
                @SerializedName("aqi")
                val aqi: List<Aqi>,
                @SerializedName("pm25")
                val pm25: List<Pm25>
            ) {
                data class Aqi(
                    @SerializedName("avg")
                    val avg: Avg,
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("max")
                    val max: Max,
                    @SerializedName("min")
                    val min: Min
                ) {
                    data class Avg(
                        @SerializedName("chn")
                        val chn: Int,
                        @SerializedName("usa")
                        val usa: Int
                    )

                    data class Max(
                        @SerializedName("chn")
                        val chn: Int,
                        @SerializedName("usa")
                        val usa: Int
                    )

                    data class Min(
                        @SerializedName("chn")
                        val chn: Int,
                        @SerializedName("usa")
                        val usa: Int
                    )
                }

                data class Pm25(
                    @SerializedName("avg")
                    val avg: Int,
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("max")
                    val max: Int,
                    @SerializedName("min")
                    val min: Int
                )
            }

            data class Astro(
                @SerializedName("date")
                val date: Date,
                @SerializedName("sunrise")
                val sunrise: Sunrise,
                @SerializedName("sunset")
                val sunset: Sunset
            ) {
                data class Sunrise(
                    @SerializedName("time")
                    val time: String
                )

                data class Sunset(
                    @SerializedName("time")
                    val time: String
                )
            }

            data class Cloudrate(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Dswrf(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Humidity(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class LifeIndex(
                @SerializedName("carWashing")
                val carWashing: List<CarWashing>,
                @SerializedName("coldRisk")
                val coldRisk: List<ColdRisk>,
                @SerializedName("comfort")
                val comfort: List<Comfort>,
                @SerializedName("dressing")
                val dressing: List<Dressing>,
                @SerializedName("ultraviolet")
                val ultraviolet: List<Ultraviolet>
            ) {
                data class CarWashing(
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("desc")
                    val desc: String,
                    @SerializedName("index")
                    val index: String
                )

                data class ColdRisk(
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("desc")
                    val desc: String,
                    @SerializedName("index")
                    val index: String
                )

                data class Comfort(
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("desc")
                    val desc: String,
                    @SerializedName("index")
                    val index: String
                )

                data class Dressing(
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("desc")
                    val desc: String,
                    @SerializedName("index")
                    val index: String
                )

                data class Ultraviolet(
                    @SerializedName("date")
                    val date: Date,
                    @SerializedName("desc")
                    val desc: String,
                    @SerializedName("index")
                    val index: String
                )
            }

            data class Precipitation(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double,
                @SerializedName("probability")
                val probability: Int
            )

            data class Precipitation08h20h(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double,
                @SerializedName("probability")
                val probability: Int
            )

            data class Precipitation20h32h(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double,
                @SerializedName("probability")
                val probability: Int
            )

            data class Pressure(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Skycon(
                @SerializedName("date")
                val date: Date,
                @SerializedName("value")
                val value: String
            )

            data class Skycon08h20h(
                @SerializedName("date")
                val date: Date,
                @SerializedName("value")
                val value: String
            )

            data class Skycon20h32h(
                @SerializedName("date")
                val date: Date,
                @SerializedName("value")
                val value: String
            )

            data class Temperature(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Temperature08h20h(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Temperature20h32h(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Visibility(
                @SerializedName("avg")
                val avg: Double,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Double,
                @SerializedName("min")
                val min: Double
            )

            data class Wind(
                @SerializedName("avg")
                val avg: Avg,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Max,
                @SerializedName("min")
                val min: Min
            ) {
                data class Avg(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Max(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Min(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )
            }

            data class Wind08h20h(
                @SerializedName("avg")
                val avg: Avg,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Max,
                @SerializedName("min")
                val min: Min
            ) {
                data class Avg(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Max(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Min(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )
            }

            data class Wind20h32h(
                @SerializedName("avg")
                val avg: Avg,
                @SerializedName("date")
                val date: Date,
                @SerializedName("max")
                val max: Max,
                @SerializedName("min")
                val min: Min
            ) {
                data class Avg(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Max(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )

                data class Min(
                    @SerializedName("direction")
                    val direction: Double,
                    @SerializedName("speed")
                    val speed: Double
                )
            }
        }
    }
}