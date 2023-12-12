package com.akash.weather.home_screen.domain.models

import androidx.annotation.RawRes

data class IconPair(
    val iconKeys:List<String>,
    @RawRes val rawId: Int
)
