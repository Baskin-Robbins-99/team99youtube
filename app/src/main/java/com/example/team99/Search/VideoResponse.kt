package com.example.team99.Search

data class VideoResponse(
    val items: List<SearchVideoItem>
)

data class SearchVideoItemResponse(
    val id: String,
    val title: String,
    val description: String
)

