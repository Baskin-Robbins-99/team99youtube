//package com.example.team99.Home.ViewModel
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import com.example.team99.CategoryVideoItem
//import com.example.team99.Retrofit.RetrofitClient
//import com.example.team99.YoutubeCategoriesApi
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class VideoCategoryViewModel : ViewModel() {
//    private val _selectedCategory = MutableStateFlow("전체")
//    val selectedCategory: StateFlow<String> = _selectedCategory
//
//    private val _videoList = MutableStateFlow<List<CategoryVideoItem>>(emptyList())
//    val videoList: StateFlow<List<CategoryVideoItem>> = _videoList
//
//    fun selectCategory(category: String) {
//        _selectedCategory.value = category
//        updateVideoList()
//    }
//
//    fun updateVideoList() {
//        val categoryId = getCategoryIdFromSelectedCategory()
//        if (categoryId != null) {
//            RetrofitClient.apiService()
//                .categoryVideo("snippet", "mostPopular", "KR", "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc", 0)
//                ?.enqueue(object : Callback<YoutubeCategoriesApi?> {
//                    override fun onResponse(
//                        call: Call<YoutubeCategoriesApi?>,
//                        response: Response<YoutubeCategoriesApi?>
//                    ) {
//                        if (response.isSuccessful) {
//                            Log.e("ViewModel response", "API 요청이 tjdrhdadsfasdfa.")
//                            val videoResponse = response.body()
//                            if (videoResponse != null) {
//                                val videos = videoResponse.items?.mapNotNull { item ->
//                                    val snippet = item?.snippet
//                                    if (snippet != null) {
//                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
//                                        val title = snippet.title ?: ""
//                                        CategoryVideoItem(thumbnails, title,0)
//                                    } else {
//                                        null
//                                    }
//                                } ?: emptyList()
//                                _videoList.value = videos
//                            }
//                        } else {
//                            Log.e("ViewModel response", "API 요청이 실패했습니다.${videoList}")
//                        }
//                    }
//
//
//                    override fun onFailure(call: Call<YoutubeCategoriesApi?>, t: Throwable) {
//                        Log.e("ViewModel response", "API 요청이 실패했습니다22222222${videoList}.")
//                    }
//                })
//        }
//    }
//
//
//
//
//
//    private fun getCategoryIdFromSelectedCategory(): String? {
//        val selectedCategory = _selectedCategory.value
//        val categoryMap = mapOf(
//            "전체" to "0",
//            "게임" to "20",
//            "동물" to "15",
//        )
//        return categoryMap[selectedCategory] ?: "0"
//    }
//}
