package br.com.devcapu.weather.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.weather.R
import br.com.devcapu.weather.ui.theme.WeatherTheme
import br.com.devcapu.weather.ui.theme.fontFamily


@Composable
fun WeatherTodayCard() {
    Card(
        backgroundColor = Color(0xFF5887DD),
        contentColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.sun__1_),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.5f)
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "20/09/2022 | 19:30",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraLight,
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "28°C",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraLight,
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun WeatherTodayCardPreview() {
    WeatherTheme {
        WeatherTodayCard()
    }
}