package br.com.devcapu.weather.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository() {
    suspend fun searchForWeather() {
        withContext(Dispatchers.IO) {
            Connection.instance().create(Endpoint::class.java).getPosts()
        }
    }
}