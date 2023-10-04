package com.example.team99.Search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.team99.Search.VideoResponse

import kotlinx.coroutines.launch
import retrofit2.Response

class VideoViewModel : ViewModel() {

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

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchVideos(
                    part = "snippet",
                    query = query,
                    key = "AIzaSyCvE-aHt4WSh1CqDE1aIzzLRLByxBgR9GI"
                )
                handleResponse(response)
            } catch (e: Exception) {
                errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                // Indicate that loading has finished, whether successful or not
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
