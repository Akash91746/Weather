package com.akash.weather.home_screen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.akash.weather.R
import com.akash.weather.home_screen.utils.HomeScreenEvents
import com.akash.weather.home_screen.utils.HomeScreenState
import com.akash.weather.ui.theme.spacing

@Composable
fun ScaffoldContent(
    modifier: Modifier = Modifier,
    state: HomeScreenState,
    onEvent : (HomeScreenEvents) -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchInput(
            modifier = Modifier.fillMaxWidth(),
            value = state.city,
            label = stringResource(id = R.string.search),
            placeholder = stringResource(R.string.search_by_city),
            onChange = { value ->
                onEvent(HomeScreenEvents.OnChangeSearchValue(value))
            },
            enabled = !state.isLoading
        ) {
            onEvent(HomeScreenEvents.OnClickSearch)
        }

        if (state.isLoading)
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

        if(state.data != null && state.error == null) {
            WeatherInfoComp(info = state.data) {
                onEvent(HomeScreenEvents.OnClickRefresh)
            }
        }else if(state.error != null) {
           GenericError {
               onEvent(HomeScreenEvents.OnClickRefresh)
           }
        }
    }
}