package com.example.team99.Home.ViewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.team99.Constants.API_KEY
import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewModel : ViewModel() {
    private val _categoryVideos = MutableLiveData<List<YoutubeCategoriesApi.Item>?>()
    val categoryVideos: LiveData<List<YoutubeCategoriesApi.Item>?> = _categoryVideos


    init {
        // ViewModel 초기화 시 카테고리 목록을 가져오도록 호출
        fetchVideoCategories("YOUR_INITIAL_CATEGORY")
    }

    fun fetchVideoCategories(selectedCategory: String) {
        RetrofitClient.apiService.categoryVideo("snippet", "KR", API_KEY)
            ?.enqueue(object : Callback<YoutubeCategoriesApi?> {

                override fun onResponse(
                    call: Call<YoutubeCategoriesApi?>,
                    response: Response<YoutubeCategoriesApi?>
                ) {
                    if (response.isSuccessful) {
                        val categories = response.body()?.items
                        _categoryVideos.postValue(categories as List<YoutubeCategoriesApi.Item>?)
                    }
                }

                override fun onFailure(call: Call<YoutubeCategoriesApi?>, t: Throwable) {
                    Log.d("ViewModel","nyh failure")
                }

            })
    }
}