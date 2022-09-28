package br.com.devcapu.weather.data.forecast

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import br.com.devcapu.weather.data.Connection
import br.com.devcapu.weather.data.Endpoint
import br.com.devcapu.weather.data.ForecastApiModel
import br.com.devcapu.weather.ui.viewModel.MainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastRepository {
    suspend fun searchForWeather(onCompletion: (MainUiState) -> Unit) {
        withContext(Dispatchers.IO) {
            val endpoint = Connection.instance().create(Endpoint::class.java)
            val call = endpoint.getWeather(
                latitude = "-23.55",
                longitude = "-46.66",

                )
            call.enqueue(ForecastCallback(onCompletion))
        }
    }
}