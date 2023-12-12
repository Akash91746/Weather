package com.akash.weather.home_screen.utils

import com.akash.weather.home_screen.domain.models.WeatherInfo

data class HomeScreenState(
    val city: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: WeatherInfo? = null
)
