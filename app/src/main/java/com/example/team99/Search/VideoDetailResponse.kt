package com.example.team99.Search

import com.google.gson.annotations.SerializedName

data class VideoDetailResponse(
    val items: List<VideoDetailItem>
)

data class VideoDetailItem(
    val id: String,
    val snippet: VideoDetailSnippet,
    val contentDetails: VideoContentDetails,
    val statistics: VideoStatistics
)

data class VideoDetailSnippet(
    @SerializedName("channelTitle") val channelName: String,
    @SerializedName("publishedAt") val publishedAt: String? = null
)

data class VideoContentDetails(
    @SerializedName("duration") val duration: String
)

data class VideoStatistics(
    @SerializedName("viewCount") val viewCount: String
)
