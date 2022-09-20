package br.com.devcapu.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("São Paulo")
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
    ) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                backgroundColor = Color(0xFF5887DD),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "20/09/2022 | 19:30",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "28°C",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AdditionalInformation(
                        icon = painterResource(id = R.drawable.ic_launcher_foreground),
                        value = "28°C",
                        name = "Sensação"
                    )
                    AdditionalInformation(
                        icon = painterResource(id = R.drawable.ic_launcher_foreground),
                        value = "88%",
                        name = "Humidade"
                    )

                    AdditionalInformation(
                        icon = painterResource(id = R.drawable.ic_launcher_foreground),
                        value = "1009hPa",
                        name = "Pressão do ar"
                    )
                }
            }

            Text(
                text = "Em cada horário",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            LazyRow {
                items(listOf("Bla")) {
                    repeat(10) {
                        Card(modifier = Modifier.padding(end = 16.dp)) {
                            Column() {
                                Text("Agora")
                                Column {
                                    Image(
                                        painterResource(id = R.drawable.ic_launcher_foreground),
                                        contentDescription = null
                                    )
                                    Text("28°C")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AdditionalInformation(
    icon: Painter,
    value: String,
    name: String,
) {
    Column(horizontalAlignment = CenterHorizontally) {
        Image(icon, contentDescription = null)
        Text(value)
        Text(name)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    WeatherTheme {
        Greeting()
    }
}