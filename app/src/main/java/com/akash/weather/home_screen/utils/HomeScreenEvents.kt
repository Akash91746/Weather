package com.akash.weather.home_screen.utils

sealed class HomeScreenEvents {

    data class OnChangeSearchValue(val value: String) : HomeScreenEvents()

    object OnClickSearch : HomeScreenEvents()

    object OnClickRefresh: HomeScreenEvents()

}
