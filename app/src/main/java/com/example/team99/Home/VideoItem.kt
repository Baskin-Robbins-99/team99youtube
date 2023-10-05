package com.example.team99.Home


import java.io.Serializable


data class VideoItem(
    val thumbnails: String?,
    val title: String?,
    val categoryId: String?,
    val chanelId: String?,
    val description: String?
): Serializable
