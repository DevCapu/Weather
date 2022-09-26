package br.com.devcapu.weather.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.open-meteo.com/v1/"
class Connection {
    companion object {
        fun instance(): Retrofit {
            val httpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}