package com.example.team99.Retrofit

import com.example.team99.YoutubeCategoriesApi
import com.example.team99.YoutubeVideosApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit_interface {
    @GET("youtube/v3/videos")
    fun popularVideo(
        @Query("part")  part: String?,
        @Query("chart") chart: String?,
        @Query("regionCode") regionCode: String?,
        @Query("maxResults") maxResults: Int?,
        @Query("key") key: String?
    ): Call<YoutubeVideosApi>
    @GET("youtube/v3/videos")
    fun categoryVideo(
        @Query("part") part: String?,
        @Query("chart") chart: String?,
        @Query("regionCode") regionCode: String?,
        @Query("key") key: String?
    ): Call<YoutubeCategoriesApi?>?
    @GET("youtube/v3/channels")
    fun categoryChannel (
        @Query("part") part : String?,
        @Query("id") id : String?,
        @Query("maxResults") maxResults: Int?,
        @Query("key") key: String?
    ): Call<YoutubeChannelApi>
}