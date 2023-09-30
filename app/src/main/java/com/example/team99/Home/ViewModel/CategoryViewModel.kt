package com.example.team99.Home.ViewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.team99.Constants.API_KEY
import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.VideoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoCategoryViewModel : ViewModel() {
    private val _selectedCategory = MutableStateFlow("전체")
    val selectedCategory: Flow<String> = _selectedCategory.asStateFlow()

    private val _videoList = MutableStateFlow<List<VideoItem>>(emptyList())
    val videoList: Flow<List<VideoItem>> = _videoList.asStateFlow()

    fun selectCategory(category: String) {
        _selectedCategory.value = category
        updateVideoList()
    }

    fun updateVideoList() {
        val categoryId = getCategoryIdFromSelectedCategory()
        if (categoryId != null) {
            fetchVideoList(categoryId)
        }
    }

    private fun getCategoryIdFromSelectedCategory(): String? {
        val selectedCategory = _selectedCategory.value
        val categoryMap = mapOf(
            "전체" to "0",
            "게임" to "20",
            "동물" to "15",
            // 여기에 원하는 카테고리와 해당 categoryId를 추가하세요.
        )
        return categoryMap[selectedCategory] ?: "0"
    }

    private fun fetchVideoList(categoryId: String) {
        RetrofitClient.apiService.categoryVideo(
            "snippet",
            "KR",
            categoryId,
            API_KEY
        )?.enqueue(object : Callback<YoutubeCategoriesApi?> {
            override fun onResponse(
                call: Call<YoutubeCategoriesApi?>,
                response: Response<YoutubeCategoriesApi?>
            ) {
                if (response.isSuccessful) {
                    val videoResponse = response.body()
                    if (videoResponse != null) {
                        val videos = videoResponse.items?.mapNotNull { item ->
                            val snippet = item?.snippet
                            if (snippet != null) {
                                val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                val title = snippet.title ?: ""
                                VideoItem(thumbnails, title)
                            } else {
                                null
                            }
                        } ?: emptyList()
                        _videoList.value = videos
                    }
                } else {
                    // 실패 처리
                    Log.d("VideoCategoryViewModel", "Fetching video list failed")
                }
            }

            override fun onFailure(call: Call<YoutubeCategoriesApi?>, t: Throwable) {
                // 오류 처리
                Log.d("VideoCategoryViewModel", "Fetching video list failed")
            }
        })
    }
}
