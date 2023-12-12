package com.akash.weather.home_screen.domain.models

import androidx.annotation.RawRes

data class WeatherInfo(
    val name: String,
    val id: Int,
    val cloud : Int,
    val windSpeed: Double,
    val visibility: Int,
    val mainTemp: Double,
    val pressure: Int,
    val humidity: Int,
    val weatherTitle: String,
    val weatherDesc: String,
    val icon : String,
    val date: String,
    @RawRes val resId: Int? = null
)
