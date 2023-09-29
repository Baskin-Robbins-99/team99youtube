package com.example.team99.Home

data class YoutubeVideoCategory(
    var order: Int,
    var name: String,
    var id: Int = 0
) {
    companion object {
        fun copy(target: YoutubeVideoCategory): YoutubeVideoCategory =
            YoutubeVideoCategory(target.order, target.name, target.id)
    }
}