package br.com.devcapu.weather.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {
    @GET("forecast?" +
            "hourly=temperature_2m,relativehumidity_2m,apparent_temperature,pressure_msl" +
            "&current_weather=true" +
            "&timezone=America%2FSao_Paulo"
    )
    fun getWeather(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
    ): Call<WeatherApiModel>

    @GET("search")
    fun search(@Query("name") name: String)
}