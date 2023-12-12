package com.akash.weather.di

import android.content.Context
import com.akash.weather.core.database.AppLocalDatabase
import com.akash.weather.home_screen.data.data_source.remote.WeatherApi
import com.akash.weather.home_screen.data.repository.WeatherRepositoryImpl
import com.akash.weather.home_screen.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val API_BASE_URL = "https://api.openweathermap.org"
    private const val API_KEY = "add-your-openweather-appid"

    @Provides
    @Singleton
    fun providesPlannerDatabase(
        @ApplicationContext context: Context
    ) : AppLocalDatabase {
        return AppLocalDatabase.getInstance(context)
    }

    @Provides
    fun providesWeatherApi() : WeatherApi {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    fun providesWeatherRepository(
        weatherApi: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi, API_KEY)
    }
}