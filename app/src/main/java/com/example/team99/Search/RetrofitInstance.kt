// RetrofitInstance.kt

package com.example.team99.Search

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://www.googleapis.com/youtube/v3/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: YouTubeApiService by lazy {
        retrofit.create(YouTubeApiService::class.java)
    }
}
