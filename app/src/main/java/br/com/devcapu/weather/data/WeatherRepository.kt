package br.com.devcapu.weather.data

import android.util.Log
import br.com.devcapu.weather.ui.viewModel.HourlyWeatherItem
import br.com.devcapu.weather.ui.viewModel.MainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Flow

class WeatherRepository() {
    suspend fun searchForWeather(onCompletion: (MainUiState) -> Unit){
        withContext(Dispatchers.IO) {
            val endpoint = Connection.instance().create(Endpoint::class.java)
            val call = endpoint.getWeather(
                latitude = "-23.55",
                longitude = "-46.66",

            )
            call.enqueue(object : Callback<WeatherApiModel> {
                override fun onResponse(
                    call: Call<WeatherApiModel>,
                    response: Response<WeatherApiModel>,
                ) {
                    if (response.isSuccessful) {
                       onCompletion(map(response.body()!!))
                    } else{
                        Log.d("FAILURE_200", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<WeatherApiModel>, t: Throwable) {
                    Log.d("FAILURE_500", t.message.toString())
                }

            })
        }
    }

    private fun map(response: WeatherApiModel): MainUiState {
        return MainUiState(
            city = "São Paulo",
            celsius = response.currentWeather.temperature.toString(),
            date = "26/09/2022",
            time = "19:46",
            sensation = 22,
            humidity = response.currentWeather.windspeed.toInt(),
            airPressure = response.elevation.toInt(),
            hourlyWeather = map(response.hourly)
        )
    }

    private fun map(response: HourlyApiModel): List<HourlyWeatherItem> {
        return response.time.filterIndexed { index, _ ->  index < 24}.mapIndexed { index, time ->
            HourlyWeatherItem(
                hour = time.split(":")[0].split("T")[1],
                celsius = response.temperature[index].toString(),
                image = ""
            )
        }

    }
}