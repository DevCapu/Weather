package br.com.devcapu.weather

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.devcapu.weather.ui.component.AdditionalInformation
import br.com.devcapu.weather.ui.component.HourlyWeatherList
import br.com.devcapu.weather.ui.component.Subtitle
import br.com.devcapu.weather.ui.component.WeatherTodayCard
import br.com.devcapu.weather.ui.theme.WeatherTheme
import br.com.devcapu.weather.ui.theme.fontFamily
import br.com.devcapu.weather.ui.viewModel.MainUiState
import br.com.devcapu.weather.ui.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme { MainScreen() }
        }
    }
}

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

            item { HourlyWeatherList() }
        }
    }
}

@Composable
private fun AppBar(cityName: String) {
    TopAppBar(
        title = {
            Text(
                text = cityName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
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