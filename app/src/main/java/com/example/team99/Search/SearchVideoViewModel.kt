package com.example.team99.Search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchVideoViewModel : ViewModel() {
    val searchResult: MutableLiveData<List<SearchVideoItem>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun searchVideos(query: String) {
        if (query.isBlank()) {
            errorMessage.value = "Query must not be blank"
            return
        }

        isLoading.value = true

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchVideos(
                    part = "snippet",
                    query = query,
                    key = "AIzaSyBGb0QETVeG-ncGgn-mBvJW6mzhQV1HYHc"
                )
                handleResponse(response)
            } catch (e: Exception) {
                errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                isLoading.value = false
            }
        }
    }

    private fun handleResponse(response: Response<SearchResponse>) {
        if (response.isSuccessful) {
            viewModelScope.launch {
                val mappedList = response.body()?.items?.mapNotNull { videoItem ->
                    mapApiToUi(videoItem)
                }
                searchResult.value = mappedList
            }
        } else {
            errorMessage.value = "Failed to load data: ${response.message()}"
        }
    }

    private suspend fun mapApiToUi(videoItem: VideoItem): SearchVideoItem? {
        val thumbnailUrl = videoItem.snippet.thumbnails.defaultThumbnail.url

        val videoDetailResponse = RetrofitInstance.api.getVideoDetails(
            videoId = videoItem.id.videoId,
            key = "AIzaSyBGb0QETVeG-ncGgn-mBvJW6mzhQV1HYHc"
        )

        val videoDetails = videoDetailResponse.body()?.items?.firstOrNull() ?: return null

        val videoDuration = videoDetails.contentDetails.duration
        val channelName = videoDetails.snippet.channelName
        val viewCount = videoDetails.statistics.viewCount
        val date = videoDetails.snippet.publishedAt ?: "Unknown"

        return SearchVideoItem(
            thumbnailUrl = thumbnailUrl,
            duration = videoDuration,
            title = videoItem.snippet.title,
            channelName = channelName,
            viewCount = viewCount,
            date = date
        )
    }

}
