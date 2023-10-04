package com.example.team99.Search

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("items") val items: List<SearchVideoItem>
)

data class VideoItem(
    @SerializedName("id") val id: VideoId,
    @SerializedName("snippet") val snippet: VideoSnippet
)

data class VideoId(
    @SerializedName("videoId") val videoId: String
)

data class VideoSnippet(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnails") val thumbnails: VideoThumbnails
)

data class VideoThumbnails(
    @SerializedName("default") val defaultThumbnail: VideoThumbnail
)

data class VideoThumbnail(
    @SerializedName("url") val url: String
)
