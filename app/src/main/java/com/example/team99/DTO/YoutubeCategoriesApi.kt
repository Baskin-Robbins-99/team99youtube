package com.example.team99.DTO


import com.google.gson.annotations.SerializedName

data class YoutubeCategoriesApi(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("prevPageToken")
    val prevPageToken: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?,
    @SerializedName("items")
    val items: List<Item>?
)

data class Item(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("snippet")
    val snippet: Snippet?
)

data class Snippet(
    @SerializedName("assignable")
    val assignable: Boolean?,
    @SerializedName("channelId")
    val channelId: String?,
    @SerializedName("title")
    val title: String?,
    val thumbnails: YoutubeVideosApi.Item.Snippet.Thumbnails
)

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: Int?,
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int?
)
//1 -  Film & Animation
//2 - Autos & Vehicles
//10 - Music
//15 - Pets & Animals
//17 - Sports
//18 - Short Movies
//19 - Travel & Events
//20 - Gaming
//21 - Videoblogging
//22 - People & Blogs
//23 - Comedy
//24 - Entertainment
//25 - News & Politics
//26 - Howto & Style
//27 - Education
//28 - Science & Technology
//29 - Nonprofits & Activism
//30 - Movies
//31 - Anime/Animation
//32 - Action/Adventure
//33 - Classics
//34 - Comedy
//35 - Documentary
//36 - Drama
//37 - Family
//38 - Foreign
//39 - Horror
//40 - Sci-Fi/Fantasy
//41 - Thriller
//42 - Shorts
//43 - Shows
//44 - Trailers
//
//
//From  youtube upload page
//    2 - Cars & Vehicles
//    23 - Comedy
//    27 - Education
//    24 - Entertainment
//    1 - Film & Animation
//    20 - Gaming
//    26 - How-to & Style
//    10 - Music
//    25 - News & Politics
//    29 - Non-profits & Activism
//    22 - People & Blogs
//    15 - Pets & Animals
//    28 - Science & Technology
//    17 - Sport
//    19 - Travel & Events