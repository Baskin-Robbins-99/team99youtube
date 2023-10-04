package com.example.team99.Home


import java.io.Serializable



data class VideoItem(
    val thumbnails: String,
    val title: String,
    //var isLike: Boolean,
    var description: String
): Serializable {
    companion object {
        val title: CharSequence?
            get() {
                TODO()
            }
        val description: CharSequence?
            get() {
                TODO()
            }
    }
}