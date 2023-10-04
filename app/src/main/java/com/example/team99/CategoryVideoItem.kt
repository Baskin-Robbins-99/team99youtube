package com.example.team99

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryVideoItem(
    val thumbnails: String,
    val title: String,
    val categoryId: Int
) : Parcelable
