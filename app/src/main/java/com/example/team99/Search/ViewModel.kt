package com.example.team99.Search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.team99.Search.VideoResponse

import kotlinx.coroutines.launch
import retrofit2.Response

class VideoViewModel : ViewModel() {

    private val repository = YouTubeRepository()  // Repository 인스턴스 생성

    val searchResult = MutableLiveData<List<SearchVideoItem>>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun searchVideos(query: String) {
        // Check if the query is not blank
        if(query.isBlank()) {
            errorMessage.value = "Query must not be blank"
            return
        }

        // Indicate that loading has started
        isLoading.value = true

        // Start the network request using Coroutine
        viewModelScope.launch {
            try {
                val result = repository.searchVideos(query) ?: listOf()

                if (result.isEmpty()) {
                    errorMessage.value = "No videos found"
                } else {
                    searchResult.value = result
                }

            } catch (e: Exception) {
                errorMessage.value = e.localizedMessage ?: "Unknown error"
            } finally {
                isLoading.value = false
            }
        }
    }

    private fun handleResponse(response: Response<VideoResponse>) {
        if(response.isSuccessful) {
            searchResult.value = response.body()?.items
        } else {
            errorMessage.value = "Failed to load data: ${response.message()}"
        }
    }
}
