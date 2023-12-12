package com.akash.weather.home_screen.domain.repository

import com.akash.weather.home_screen.domain.models.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherInfo(city: String): Result<WeatherInfo>

}