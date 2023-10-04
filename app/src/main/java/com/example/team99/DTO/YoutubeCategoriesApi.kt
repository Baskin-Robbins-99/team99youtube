package com.example.team99.DTO


import com.google.gson.annotations.SerializedName

data class YoutubeCategoriesApi(
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("kind")
    val kind: String?
) {
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
            @SerializedName("assignable")
            val assignable: Boolean?,
            @SerializedName("channelId")
            val channelId: String?,
            @SerializedName("title")
            val title: String?
        )
    }

}