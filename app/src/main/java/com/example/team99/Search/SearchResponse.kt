package com.example.team99.Search

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("items") val items: List<VideoItem>
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
    @SerializedName("thumbnails") val thumbnails: VideoThumbnails,
    @SerializedName("channelTitle") val channelTitle: String? = null,
    @SerializedName("channelId") val channelId: String? = null
)

data class VideoThumbnails(
    @SerializedName("default") val defaultThumbnail: VideoThumbnail
)

data class VideoThumbnail(
    @SerializedName("url") val url: String
)

data class ChannelResponse(
    @SerializedName("items") val items: List<ChannelItem>
)

data class ChannelItem(
    @SerializedName("snippet") val snippet: ChannelSnippet
)

data class ChannelSnippet(
    @SerializedName("thumbnails") val thumbnails: ChannelThumbnails
)

data class ChannelThumbnails(
    @SerializedName("default") val defaultThumbnail: ChannelThumbnail
)

data class ChannelThumbnail(
    @SerializedName("url") val url: String
)
