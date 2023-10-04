package com.example.team99


import com.google.gson.annotations.SerializedName

data class YoutubeChannelApi(
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("kind")
    val kind: String?,
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
            @SerializedName("country")
            val country: String?,
            @SerializedName("customUrl")
            val customUrl: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("localized")
            val localized: Localized?,
            @SerializedName("publishedAt")
            val publishedAt: String?,
            @SerializedName("thumbnails")
            val thumbnails: Thumbnails?,
            @SerializedName("title")
            val title: String?
        )

        data class Localized(
            @SerializedName("description")
            val description: String?,
            @SerializedName("title")
            val title: String?
        )

        data class Thumbnails(
            @SerializedName("default")
            val default: Default?
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