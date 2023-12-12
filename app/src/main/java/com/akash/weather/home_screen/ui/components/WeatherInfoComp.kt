package com.akash.weather.home_screen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akash.weather.R
import com.akash.weather.home_screen.domain.models.WeatherInfo
import com.akash.weather.ui.theme.WeatherTheme
import com.akash.weather.ui.theme.spacing
import kotlin.math.roundToInt

@Composable
fun WeatherInfoComp(
    modifier: Modifier = Modifier,
    info: WeatherInfo,
    onClickRefresh: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (info.resId != null)
            AppLottieAnimation(res = info.resId)

        Text(
            text = "${info.mainTemp.roundToInt()}\u00B0",
            style= MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = info.weatherTitle,
                style = MaterialTheme.typography.titleMedium
            )

            IconButton(onClick = onClickRefresh) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = stringResource(R.string.refresh)
                )
            }
        }

        Text(
            text = info.date,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.padding(top = MaterialTheme.spacing.large))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            InfoCard(
                modifier = Modifier.padding(end = MaterialTheme.spacing.small).fillMaxWidth().weight(1f),
                painter = painterResource(id = R.drawable.baseline_wind_power_24),
                contentDesc = stringResource(R.string.wind),
                title = stringResource(R.string.wind),
                desc = stringResource(id = R.string.wind_arg,"${info.windSpeed}")
            )

            InfoCard(
                modifier = Modifier.fillMaxWidth().weight(1f),
                painter = painterResource(id = R.drawable.baseline_water_drop_24),
                contentDesc = stringResource(R.string.humidity),
                title = stringResource(R.string.humidity),
                desc = stringResource(id = R.string.humidity_arg,"${info.humidity}")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherInfoComp() {
    WeatherTheme {
        WeatherInfoComp(
            info = WeatherInfo(
                name = "Mumbai",
                weatherDesc = "Mist",
                weatherTitle = "Mist",
                icon = "50d",
                resId = R.raw.mist,
                visibility = 1000,
                pressure = 334,
                humidity = 89,
                mainTemp = 30.0,
                cloud = 1,
                windSpeed = 28.0,
                date = "Sep 2022",
                id = 800
            )
        ){}
    }
}