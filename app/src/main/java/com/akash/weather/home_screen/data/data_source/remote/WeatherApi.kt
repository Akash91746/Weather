package com.akash.weather.home_screen.data.data_source.remote

import com.akash.weather.home_screen.data.dto.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") unit: String = "metric"
    ) : Response<WeatherData>

}