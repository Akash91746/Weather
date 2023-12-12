package com.akash.weather.home_screen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.akash.weather.R
import com.akash.weather.ui.theme.spacing

@Composable
fun GenericError(
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLottieAnimation(
            res = R.raw.error
        )

        Spacer(modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium))

        Text(
            text = stringResource(R.string.generic_error),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Button(onClick = onClickRetry) {
            Text(text = stringResource(R.string.retry))
        }
    }
}