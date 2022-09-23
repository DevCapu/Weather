package br.com.devcapu.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        backgroundColor = Color(0xFFF5F6F8),
        topBar = { AppBar() },
        bottomBar = { BottomBar() }

    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            item {
                Card(
                    backgroundColor = Color(0xFF5887DD),
                    contentColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painterResource(id = R.drawable.sun),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.5f)
                        )

                        Column(
                            verticalArrangement = SpaceBetween,
                            horizontalAlignment = CenterHorizontally,
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

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp),
                    ) {
                        AdditionalInformation(
                            icon = painterResource(id = R.drawable.humidity),
                            value = "28°C",
                            name = "Sensação"
                        )
                        AdditionalInformation(
                            icon = painterResource(id = R.drawable.rainy),
                            value = "88%",
                            name = "Humidade"
                        )

                        AdditionalInformation(
                            icon = painterResource(id = R.drawable.dashboard),
                            value = "1009 hPa",
                            name = "Pressão do ar"
                        )
                    }
                }
            }

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

            item { HourlyWeather() }
        }
    }
}

@Composable
private fun HourlyWeather() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(10) {
            item {
                Card {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = CenterHorizontally
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
        }
    }
}

@Composable
private fun BottomBar() { }

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

@Composable
private fun AdditionalInformation(
    icon: Painter,
    value: String,
    name: String,
) {
    Column(horizontalAlignment = CenterHorizontally) {
        Image(icon, contentDescription = null, modifier = Modifier.padding(vertical = 16.dp))
        Text(value)
        Text(name)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    WeatherTheme {
        MainScreen()
    }
}