package br.com.devcapu.weather.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun HourlyWeatherList() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(10) {
            item {
                HourlyWeatherCard()
            }
        }
    }
}

@Composable
private fun HourlyWeatherCard() {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Agora",
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(id = R.drawable.sun),
                contentDescription = null
            )
            Text(
                text = "28°C",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HourlyWeatherListPreview() {
    HourlyWeatherList()
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HourlyWeatherCardPreview() {
    HourlyWeatherCard()
}