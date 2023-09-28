package com.example.team99.Home.HomeRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.VideoItem
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class HomeRepository(application: Application) {

    //Retrofit 연결
    private val apiService = RetrofitClient.apiService

    // Retrofit으로 데이터를 가져오는 함tn
    suspend fun retrofitSelectAllTodo(): YoutubeVideosApi? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.popularVideo(
                    "",
                    "",
                    "",
                    ""
                ).execute()
                if (response.isSuccessful) {
                    return@withContext response.body()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return@withContext null
        }
    }

    // Retrofit로 데이터를 비동기적으로 삽입하는 함수
    suspend fun retrofitInsertTodo(youtubeVideosApi: YoutubeVideosApi): YoutubeVideosApi? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.popularVideo(
                    youtubeVideosApi.etag,
                    youtubeVideosApi.kind,
                    youtubeVideosApi.nextPageToken,
                    youtubeVideosApi.kind
                ).execute()
                if (response.isSuccessful) {
                    return@withContext youtubeVideosApi
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return@withContext null
        }
    }

    // Singleton pattern
    companion object {
        private var instance: HomeRepository? = null

        fun getInstance(application: Application): HomeRepository? {
            if (instance == null) instance = HomeRepository(application)
            return instance
        }
    }
}
//}
//   }
//
//    // singleton pattern
//       companion object {
//  private var instance: HomeRepository? = null
//
//      fun getInstance(application: Application): HomeRepository? {
//           if (instance == null) instance = HomeRepository(application)
//         return  instance
//      }
//   }
//   //  Insert
//  suspend fun retrofitInsertTodo(YoutubeVideosApi: YoutubeVideosApi) : Call<YoutubeVideosApi> {
//       return RetrofitClient.apiService.popularVideo("","","","")
//   }
//
//
//
//}