package br.com.devcapu.weather.data.forecast

import android.os.Build
import androidx.annotation.RequiresApi
import br.com.devcapu.weather.data.HourlyApiModel
import br.com.devcapu.weather.data.ForecastApiModel
import br.com.devcapu.weather.ui.viewModel.HourlyWeatherItem
import br.com.devcapu.weather.ui.viewModel.MainUiState
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ForecastMapper {

    @RequiresApi(Build.VERSION_CODES.O)
    fun map(response: ForecastApiModel): MainUiState {
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