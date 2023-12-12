package com.akash.weather.home_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akash.weather.R
import com.akash.weather.home_screen.ui.components.AppBar
import com.akash.weather.home_screen.ui.components.ScaffoldContent
import com.akash.weather.home_screen.ui.components.SearchInput
import com.akash.weather.home_screen.utils.HomeScreenEvents
import com.akash.weather.home_screen.utils.HomeScreenState
import com.akash.weather.ui.theme.WeatherTheme
import com.akash.weather.ui.theme.spacing

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
) {
    val state by viewModel.state.collectAsState()

    HomeScreenComp(
        state = state,
        onEvent = { viewModel.onEvent(it) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenComp(
    state: HomeScreenState,
    onEvent: (HomeScreenEvents) -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar()
        },
    ) {
        ScaffoldContent(
            modifier = Modifier.padding(it).padding(MaterialTheme.spacing.medium),
            state = state,
            onEvent = onEvent
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreenComp() {
    WeatherTheme {
        HomeScreenComp(
            state = HomeScreenState(),
            onEvent = {}
        )
    }
}