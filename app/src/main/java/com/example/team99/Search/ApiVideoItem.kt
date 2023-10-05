package com.example.team99.Search

data class ApiVideoItem(
    val id: VideoId,
    val snippet: Snippet,
    val contentDetails: ContentDetails? = null,
    val statistics: Statistics? = null
) {
    data class VideoId(
        val videoId: String
    )

    data class Snippet(
        val title: String,
        val description: String,
        val thumbnails: Thumbnails,
        val channelTitle: String,
        val publishedAt: String,
        val channelId: String  // 채널 ID 추가
    )

    data class ContentDetails(
        val duration: String
    )

    data class Statistics(
        val viewCount: String
    )

    data class Thumbnails(
        val medium: Thumbnail
    )

    data class Thumbnail(
        val url: String
    )
}
