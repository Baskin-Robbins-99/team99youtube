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
        @Query("Chart") chart: String?,
        @Query("regionCode") regionCode: String?,
        @Query("key") key: String?
    ): Call<YoutubeVideosApi>
    @GET("youtube/v3/videoCategories")
    fun categoryVideo(

    ): Call<YoutubeCategoriesApi?>?
    @GET("youtube/v3/videos")
    fun categoryChannel (

    ): Call<YoutubeVideosApi>
}