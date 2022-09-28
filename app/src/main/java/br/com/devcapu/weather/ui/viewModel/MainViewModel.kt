package br.com.devcapu.weather.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devcapu.weather.data.forecast.ForecastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MainUiState(
    val city: String = "",
    val celsius: String = "",
    val date: String = "",
    val time: String = "",
    val sensation : Int = 0,
    val humidity: Int = 0,
    val airPressure: Int = 0,
    val hourlyWeather: List<HourlyWeatherItem> = emptyList()
)

data class HourlyWeatherItem(
    val hour: String,
    val celsius: String,
    val image: String
)

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            ForecastRepository().searchForWeather { _uiState.value = it }
        }
    }

}