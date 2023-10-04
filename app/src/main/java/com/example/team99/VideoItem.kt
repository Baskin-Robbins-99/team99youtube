package com.example.team99

import android.os.Parcelable


@Parcelize
data class VideoItem(
    val thumbnails: String,
    val title: String,
): Parcelable