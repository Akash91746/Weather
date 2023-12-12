package com.akash.weather.home_screen.data.repository

import com.akash.weather.R
import com.akash.weather.home_screen.data.data_source.remote.WeatherApi
import com.akash.weather.home_screen.data.dto.WeatherData
import com.akash.weather.home_screen.domain.models.WeatherInfo
import com.akash.weather.home_screen.domain.repository.WeatherRepository
import com.akash.weather.home_screen.domain.models.IconPair
import retrofit2.Response
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val apiKey: String,
) : WeatherRepository {

    private val defaultIconPair = listOf(
        IconPair(iconKeys = listOf("01d","01n"), rawId = R.raw.clear),
        IconPair(iconKeys = listOf("02d","02n","03d","03n","04d","04n"), rawId = R.raw.cloudy),
        IconPair(iconKeys = listOf("09d","09n","10d","10n"), rawId = R.raw.rainy),
        IconPair(iconKeys = listOf("11d","11n"), rawId = R.raw.thunderstorm),
        IconPair(iconKeys = listOf("13d","13n"), rawId = R.raw.snow),
        IconPair(iconKeys = listOf("50d","50n"), rawId = R.raw.mist)
    )

    override suspend fun getWeatherInfo(city: String): Result<WeatherInfo> {
        val result:Response<WeatherData>

        try {
            result = api.getWeatherInfo(city, apiKey)
        }catch (e: Exception)  {
            return Result.failure(Throwable("Something went wrong"))
        }

        val data = result.body()

        if(!result.isSuccessful || data == null){
            return Result.failure(Throwable("Something went wrong"))
        }

        val iconKey = data.weather[0].icon

        val iconPair = defaultIconPair.find { it.iconKeys.contains(iconKey) }

        val date = Date(data.dt)
        val formatter = SimpleDateFormat("hh:mm a z", Locale.getDefault())

        return Result.success(
            WeatherInfo(
                name = data.name,
                id = data.id,
                cloud = data.clouds.all,
                windSpeed = data.wind.speed,
                mainTemp = data.main.temp,
                humidity = data.main.humidity,
                pressure = data.main.pressure,
                visibility = data.visibility,
                weatherTitle = data.weather[0].main,
                weatherDesc = data.weather[0].description,
                icon = data.weather[0].icon,
                date = formatter.format(date),
                resId =  iconPair?.rawId
            )
        )
    }
}
