package com.example.team99

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoItem(
    val thumbnails: String,
    val title: String
): Parcelable