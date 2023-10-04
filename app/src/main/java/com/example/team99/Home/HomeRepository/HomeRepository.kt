package com.example.team99.Home.HomeRepository

import com.example.team99.Item
import com.example.team99.YoutubeCategoriesApi
import com.example.team99.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoCategoryRepository {
    fun getVideoCategories(
        part: String,
        regionCode: String,
        callback: (List<Item>?) -> Unit
    ) {
        val call = RetrofitClient.apiService().categoryVideo("snippet", "","","",0)

        if (call != null) {
            call.enqueue(object : Callback<YoutubeCategoriesApi?> {

                override fun onResponse(
                    call: Call<YoutubeCategoriesApi?>,
                    response: Response<YoutubeCategoriesApi?>
                ) {

                    if (response.isSuccessful) {
                        val YoutubeVideoCategory = response.body()
                        val videoCategories = YoutubeVideoCategory?.items
                        callback(videoCategories)
                    } else {
                        callback(null)
                    }
                }

                override fun onFailure(call: Call<YoutubeCategoriesApi?>, t: Throwable) {
                    callback(null)
                }
            })
        }
    }
}