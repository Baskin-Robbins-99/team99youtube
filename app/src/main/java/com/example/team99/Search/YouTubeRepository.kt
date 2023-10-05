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
                    response.body()?.items?.mapNotNull { videoItem ->
                        val videoDetail = getVideoDetails(videoItem.id.videoId)
                        mapApiToUi(videoItem, videoDetail)
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

    private suspend fun getChannelLogo(channelId: String): String? {
        val response = RetrofitInstance.api.getChannelDetails(channelId = channelId, key = "AIzaSyBGb0QETVeG-ncGgn-mBvJW6mzhQV1HYHc")
        return response.body()?.items?.firstOrNull()?.snippet?.thumbnails?.defaultThumbnail?.url
    }


    private suspend fun getVideoDetails(videoId: String): VideoDetailItem? {
        val response = RetrofitInstance.api.getVideoDetails(videoId = videoId, key = "AIzaSyBGb0QETVeG-ncGgn-mBvJW6mzhQV1HYHc")
        return response.body()?.items?.firstOrNull()
    }

    private suspend fun mapApiToUi(videoItem: VideoItem, videoDetail: VideoDetailItem?): SearchVideoItem? {
        val thumbnailUrl = videoItem.snippet.thumbnails.defaultThumbnail.url
        val videoDuration = videoDetail?.contentDetails?.duration ?: "Unknown"
        val channelName = videoDetail?.snippet?.channelName ?: "Unknown"
        val viewCount = videoDetail?.statistics?.viewCount ?: "Unknown"
        val date = videoDetail?.snippet?.publishedAt ?: "Unknown"
        val channelId = videoDetail?.snippet?.channelId ?: return null
        val channelLogo = getChannelLogo(channelId)

        return SearchVideoItem(
            thumbnailUrl = thumbnailUrl,
            duration = videoDuration,
            title = videoItem.snippet.title,
            channelName = channelName,
            viewCount = viewCount,
            date = date,
            channelLogo = channelLogo  // 채널 로고 URL 설정
        )
    }
}
