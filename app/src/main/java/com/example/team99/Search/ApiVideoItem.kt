package com.example.team99.Search

data class ApiVideoItem(
    val snippet: Snippet
) {
    data class Snippet(
        val title: String,
        val description: String,
        val thumbnails: Thumbnails,
        val duration: String, // 예를 들어, 영상 길이 정보 추가
        val channelName: String, // 예를 들어, 채널 이름 정보 추가
        val viewCount: String, // 예를 들어, 조회수 정보 추가
        val date: String // 예를 들어, 날짜 정보 추가
    )

    data class Thumbnails(
        val medium: Thumbnail
    )

    data class Thumbnail(
        val url: String
    )
}

