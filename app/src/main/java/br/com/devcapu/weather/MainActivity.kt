package br.com.devcapu.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.devcapu.weather.ui.screen.MainScreen
import br.com.devcapu.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme { MainScreen() }
        }
    }
}

