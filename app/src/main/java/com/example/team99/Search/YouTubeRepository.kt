// YouTubeRepository.kt

package com.example.team99.Search

class YouTubeRepository {

    suspend fun searchVideos(query: String): List<SearchVideoItem>? {
        return try {
            val response = RetrofitInstance.api.searchVideos(
                part = "snippet",
                query = query,
                key = "AIzaSyCvE-aHt4WSh1CqDE1aIzzLRLByxBgR9GI"
            )
            when {
                response.isSuccessful -> {
                    response.body()?.items?.map { searchVideoItem ->
                        mapApiToUi(searchVideoItem)
                    }

                }
                else -> {
                    // Log or report the error message
                    null
                }
            }
        } catch (e: Exception) {
            // Log the exception
            null
        }
    }

    private fun mapApiToUi(searchVideoItem: SearchVideoItem): SearchVideoItem {
        val thumbnailUrl = searchVideoItem.thumbnailUrl

        val videoDuration = "영상 길이"
        val channelName = "채널 이름" //
        val viewCount = "조회수" //
        val date = "날짜" //

        return SearchVideoItem(
            thumbnailUrl = thumbnailUrl,
            duration = videoDuration,
            title = searchVideoItem.title,
            channelName = channelName,
            viewCount = viewCount,
            date = date
        )
    }
}
