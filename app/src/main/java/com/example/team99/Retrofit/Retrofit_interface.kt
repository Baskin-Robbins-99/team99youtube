package com.example.team99.Retrofit

import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.DTO.YoutubeVideosApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit_interface {
    @GET("youtube/v3/videos")
    fun popularVideo(
        @Query("part")  part: String?,
        @Query("chart") chart: String?,
        @Query("regionCode") regionCode: String?,
        @Query("key") key: String?
    ): Call<YoutubeVideosApi>
    @GET("youtube/v3/videoCategories")
    fun categoryVideo(
        @Query("part") part: String,
        @Query("regionCode") regionCode: String,
        @Query("key") apiKey: String,
        API_KEY: String
    ): Call<YoutubeCategoriesApi?>?
    @GET("youtube/v3/videos")
    fun categoryChannel(s: String, s1: String, category: String, s2: String, apiKey: String): Call<YoutubeVideosApi>
}