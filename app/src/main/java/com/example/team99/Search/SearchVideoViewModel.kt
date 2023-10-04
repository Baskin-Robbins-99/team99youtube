// VideoViewModel.kt

package com.example.team99.Search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchVideoViewModel : ViewModel() {
    val searchResult: MutableLiveData<List<SearchVideoItem>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun searchVideos(query: String) {
        // [API call and UI update logic]
    }
}
