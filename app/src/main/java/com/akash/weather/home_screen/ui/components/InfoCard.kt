package com.akash.weather.home_screen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akash.weather.R
import com.akash.weather.ui.theme.WeatherTheme
import com.akash.weather.ui.theme.spacing

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDesc: String,
    title: String,
    desc: String
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(MaterialTheme.spacing.small),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Icon(
                    painter = painter,
                    contentDescription = contentDesc,
                    tint = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.padding(end = MaterialTheme.spacing.small))

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Text(
                text = desc,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }
    }
}

@Preview
@Composable
fun PreviewInfoCard() {
    WeatherTheme {
        InfoCard(
            painter = painterResource(id = R.drawable.baseline_wind_power_24),
            contentDesc = "Wind",
            title = "Wind",
            desc = stringResource(id = R.string.wind_arg,"50")
        )
    }
}