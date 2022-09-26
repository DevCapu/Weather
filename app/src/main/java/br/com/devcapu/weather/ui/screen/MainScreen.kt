package br.com.devcapu.weather.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.devcapu.weather.ui.component.*
import br.com.devcapu.weather.ui.theme.WeatherTheme
import br.com.devcapu.weather.ui.viewModel.MainUiState
import br.com.devcapu.weather.ui.viewModel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    MainScreenContent(uiState)
}

@Composable
private fun MainScreenContent(uiState: MainUiState) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { AppBar(cityName = uiState.city) },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            item {
                WeatherTodayCard(
                    date = uiState.date,
                    time = uiState.time,
                    celsius = uiState.celsius
                )
            }

            item {
                AdditionalInformation(
                    sensation = uiState.sensation,
                    humidity = uiState.humidity,
                    airPressure = uiState.airPressure
                )
            }

            item { Subtitle(text = "Em cada horário") }

            item { HourlyWeatherList(hourlyItems = uiState.hourlyWeather) }
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    WeatherTheme {
        MainScreenContent(
            MainUiState(
                city = "Rio de Janeiro",
                celsius = "33",
                date = "24/08/2022",
                time = "12:31",
                sensation = 22,
                humidity = 12,
                airPressure = 999
            )
        )
    }
}