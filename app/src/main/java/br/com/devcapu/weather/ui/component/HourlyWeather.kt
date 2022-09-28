package br.com.devcapu.weather.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.weather.R
import br.com.devcapu.weather.ui.theme.WeatherTheme
import br.com.devcapu.weather.ui.viewModel.HourlyWeatherItem

@Composable
fun HourlyWeatherList(hourlyItems: List<HourlyWeatherItem>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) { items(hourlyItems) { HourlyWeatherCard(it) } }
}

@Composable
private fun HourlyWeatherCard(hourlyItem: HourlyWeatherItem) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${hourlyItem.hour}h",
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(id = hourlyItem.image),
                contentDescription = null
            )
            Text(
                text = "${hourlyItem.celsius}°C",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun HourlyWeatherListPreview() {
    WeatherTheme {
        HourlyWeatherList(
            listOf(
                HourlyWeatherItem(
                    hour = "15",
                    celsius = 23,
                    R.drawable.sun
                ),
                HourlyWeatherItem(
                    hour = "16",
                    celsius = 23,
                    R.drawable.sun
                ),
                HourlyWeatherItem(
                    hour = "17",
                    celsius = 23,
                    R.drawable.sun
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun HourlyWeatherCardPreview() {
    WeatherTheme {
        HourlyWeatherCard( HourlyWeatherItem(
            hour = "15",
            celsius = 23,
            R.drawable.sun
        ))
    }
}