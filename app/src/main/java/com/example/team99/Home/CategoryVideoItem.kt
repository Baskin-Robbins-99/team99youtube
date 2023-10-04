package com.example.team99.Home

import java.io.Serializable


data class CategoryVideoItem(
    val thumbnails: String,
    val title: String,
    val categoryId: Int
): Serializable