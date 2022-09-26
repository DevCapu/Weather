package br.com.devcapu.weather.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    val airPressure: Int = 0
)

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = MainUiState(
                city = "Rio de Janeiro",
                celsius = "33",
                date = "24/08/2022",
                time = "12:31",
                sensation = 22,
                humidity = 12,
                airPressure = 999
            )
        }
    }

}