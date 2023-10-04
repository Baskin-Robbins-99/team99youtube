// YouTubeApiService.kt

package com.example.team99.Search

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
    @GET("search")
    suspend fun searchVideos(
        @Query("part") part: String,
        @Query("q") query: String,
        @Query("key") key: String,
        @Query("maxResults") maxResults: Int = 25,
        @Query("type") type: String = "video"
    ): Response<VideoResponse>
}
