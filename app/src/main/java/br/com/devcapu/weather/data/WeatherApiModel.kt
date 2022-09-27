package br.com.devcapu.weather.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherApiModel(
    val latitude: Float,
    val longitude: Float,
    val elevation: Float,
    val hourly: HourlyApiModel,
    @SerializedName("current_weather") val currentWeather: CurrentWeather,
) : Serializable

data class HourlyApiModel(
    val time: List<String>,
    @SerializedName("temperature_2m") val temperature: List<Float>,
    @SerializedName("apparent_temperature") val temperatureSensation: List<Float>,
    @SerializedName("relativehumidity_2m") val humidity: List<Float>,
    @SerializedName("pressure_msl") val airPressures: List<Float>
)

data class CurrentWeather(
    val time: String,
    val temperature: Float,
    val weatherCode: Int,
    val windspeed: Float,
    val winddirection: Int,
)