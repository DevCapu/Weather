package br.com.devcapu.weather.data

import retrofit2.Call
import retrofit2.http.GET


interface Endpoint {
    @GET("/posts")
    fun getPosts() : Call<List<Any>>
}