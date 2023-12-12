package com.akash.weather.home_screen.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.akash.weather.R
import com.akash.weather.ui.theme.WeatherTheme
import com.akash.weather.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    placeholder: String,
    enabled: Boolean = true,
    onChange: (String) -> Unit,
    onSearch: () -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onChange,
        enabled = enabled,
        placeholder = {
            Text(text = placeholder)
        },
        label = {
            Text(text = label)
        },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = stringResource(R.string.search)
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            autoCorrect = true
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        ),
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchInput() {
    WeatherTheme {
        SearchInput(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            value = "",
            onChange = {},
            placeholder = "Search by City",
            label = "Search"
        ) {}
    }
}