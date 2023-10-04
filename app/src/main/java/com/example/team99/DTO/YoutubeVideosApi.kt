package com.example.team99.DTO


import com.google.gson.annotations.SerializedName

data class YoutubeVideosApi(
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?
) {
    data class PageInfo(
        @SerializedName("resultsPerPage")
        val resultsPerPage: Int?,
        @SerializedName("totalResults")
        val totalResults: Int?
    )

    data class Item(
        @SerializedName("etag")
        val etag: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("kind")
        val kind: String?,
        @SerializedName("snippet")
        val snippet: Snippet?
    ) {
        data class Snippet(
            @SerializedName("categoryId")
            val categoryId: String?,
            @SerializedName("channelId")
            val channelId: String?,
            @SerializedName("channelTitle")
            val channelTitle: String?,
            @SerializedName("defaultAudioLanguage")
            val defaultAudioLanguage: String?,
            @SerializedName("defaultLanguage")
            val defaultLanguage: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("liveBroadcastContent")
            val liveBroadcastContent: String?,
            @SerializedName("localized")
            val localized: Localized?,
            @SerializedName("publishedAt")
            val publishedAt: String?,
            @SerializedName("tags")
            val tags: List<String?>?,
            @SerializedName("thumbnails")
            val thumbnails: Thumbnails?,
            @SerializedName("title")
            val title: String?
        ) {
            data class Localized(
                @SerializedName("description")
                val description: String?,
                @SerializedName("title")
                val title: String?
            )

            data class Thumbnails(
                @SerializedName("default")
                val default: Default?,
            ) {
                data class Default(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("url")
                    val url: String?,
                    @SerializedName("width")
                    val width: Int?
                )

            }
        }
    }
}