package br.com.devcapu.weather.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.weather.R
import br.com.devcapu.weather.ui.theme.WeatherTheme


@Composable
fun AdditionalInformation(sensation: Int, humidity: Int, airPressure: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp),
        ) {
            AdditionalInformationItem(
                icon = painterResource(id = R.drawable.humidity),
                value = "$sensation°C",
                name = "Sensação",
            )
            AdditionalInformationItem(
                icon = painterResource(id = R.drawable.rainy),
                value = "$humidity%",
                name = "Humidade"
            )

            AdditionalInformationItem(
                icon = painterResource(id = R.drawable.dashboard),
                value = "$airPressure hPa",
                name = "Pressão do ar"
            )
        }
    }
}

@Composable
fun AdditionalInformationItem(
    icon: Painter,
    value: String,
    name: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            icon,
            contentDescription = null,
            modifier = Modifier.padding(vertical = 16.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
        Text(value)
        Text(name)
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AdditionalInformationPreview() {
    WeatherTheme {
        AdditionalInformation(
            sensation = 45,
            humidity = 50,
            airPressure = 888
        )
    }
}