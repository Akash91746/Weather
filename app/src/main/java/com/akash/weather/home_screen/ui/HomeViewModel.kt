package com.akash.weather.home_screen.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.weather.home_screen.domain.repository.WeatherRepository
import com.akash.weather.home_screen.utils.HomeScreenEvents
import com.akash.weather.home_screen.utils.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
): ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state : StateFlow<HomeScreenState> = _state

    private var weatherJob: Job? = null

    fun onEvent(
        event: HomeScreenEvents
    ) {
        when(event) {
            is HomeScreenEvents.OnClickSearch -> {
                fetchWeather(_state.value.city)
            }
            is HomeScreenEvents.OnChangeSearchValue -> {
                _state.value = _state.value.copy(
                    city = event.value
                )
            }
            is HomeScreenEvents.OnClickRefresh -> {
                val data = state.value.data

                if(data != null) {
                    fetchWeather(data.name)
                }else {
                    fetchWeather(_state.value.city)
                }
            }
        }
    }

    private fun fetchWeather(city: String) {
        weatherJob?.cancel()

        weatherJob = viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            val result = weatherRepository.getWeatherInfo(city)

            val data = result.getOrNull()

            var errorMessage : String? = null

            result.exceptionOrNull()?.let {
                errorMessage = it.message
            }

            _state.value = _state.value.copy(
                error = errorMessage,
                isLoading = false,
                data = data
            )
        }
    }
}