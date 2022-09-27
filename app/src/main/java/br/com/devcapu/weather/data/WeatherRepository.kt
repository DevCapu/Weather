package br.com.devcapu.weather.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import br.com.devcapu.weather.ui.viewModel.HourlyWeatherItem
import br.com.devcapu.weather.ui.viewModel.MainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherRepository {
    suspend fun searchForWeather(onCompletion: (MainUiState) -> Unit) {
        withContext(Dispatchers.IO) {
            val endpoint = Connection.instance().create(Endpoint::class.java)
            val call = endpoint.getWeather(
                latitude = "-23.55",
                longitude = "-46.66",

                )
            call.enqueue(object : Callback<WeatherApiModel> {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onResponse(
                    call: Call<WeatherApiModel>,
                    response: Response<WeatherApiModel>,
                ) {
                    if (response.isSuccessful) {
                        onCompletion(map(response.body()!!))
                    } else {
                        Log.d("FAILURE_200", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<WeatherApiModel>, t: Throwable) {
                    Log.d("FAILURE_500", t.message.toString())
                }

            })
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun map(response: WeatherApiModel): MainUiState {
        val current = LocalDateTime.now()
        val date = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val time = DateTimeFormatter.ofPattern("HH:mm")
        val hour = current.format(DateTimeFormatter.ofPattern("HH"))

        return MainUiState(
            city = "São Paulo",
            celsius = response.currentWeather.temperature.toInt().toString(),
            date = current.format(date),
            time = current.format(time),
            sensation = response.hourly.temperatureSensation[hour.toInt()].toInt(),
            humidity = response.hourly.humidity[hour.toInt()].toInt(),
            airPressure = response.hourly.airPressures[hour.toInt()].toInt(),
            hourlyWeather = map(response.hourly)
        )
    }

    private fun map(response: HourlyApiModel): List<HourlyWeatherItem> {
        val hourlyItems =
            response.time.filterIndexed { index, _ -> index < 24 }.mapIndexed { index, time ->
                HourlyWeatherItem(
                    hour = time.split(":")[0].split("T")[1],
                    celsius = response.temperature[index].toString(),
                    image = ""
                )
            }
        return hourlyItems
    }
}