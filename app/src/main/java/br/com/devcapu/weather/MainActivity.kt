package br.com.devcapu.weather

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.weather.ui.component.AdditionalInformation
import br.com.devcapu.weather.ui.component.HourlyWeatherList
import br.com.devcapu.weather.ui.component.WeatherTodayCard
import br.com.devcapu.weather.ui.theme.WeatherTheme
import br.com.devcapu.weather.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme { MainScreen() }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { AppBar() },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            item { WeatherTodayCard() }

            item { AdditionalInformation() }

            item {
                Text(
                    text = "Em cada horário",
                    fontSize = 19.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    fontFamily = fontFamily
                )
            }

            item { HourlyWeatherList() }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        title = {
            Text(
                text = "São Paulo",
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
        MainScreen()
    }
}