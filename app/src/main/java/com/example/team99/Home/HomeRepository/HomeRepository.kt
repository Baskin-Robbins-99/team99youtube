package com.example.team99.Home.HomeRepository

import com.example.team99.Constants
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Retrofit.Retrofit_interface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository(private val apiService: Retrofit_interface) {

    fun getPopularVideos(callback: (YoutubeVideosApi?) -> Unit) {
        apiService.popularVideo("snippet", "mostPopular", "US", Constants.API_KEY)
            .enqueue(object : Callback<YoutubeVideosApi> {
                override fun onResponse(
                    call: Call<YoutubeVideosApi>,
                    response: Response<YoutubeVideosApi>
                ) {
                    if (response.isSuccessful) {
                        val videos = response.body()
                        callback(videos)
                    } else {
                        callback(null)
                    }
                }

                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {
                    callback(null)
                }
            })
    }

    fun getVideosByCategory(category: String, callback: (YoutubeVideosApi?) -> Unit) {
        apiService.categoryChannel("snippet", "video", category, "mostPopular", Constants.API_KEY)
            .enqueue(object : Callback<YoutubeVideosApi> {
                override fun onResponse(
                    call: Call<YoutubeVideosApi>,
                    response: Response<YoutubeVideosApi>
                ) {
                    if (response.isSuccessful) {
                        val videos = response.body()
                        callback(videos)
                    } else {
                        callback(null)
                    }
                }

                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {
                    callback(null)
                }
            })
    }

    // Singleton pattern
//    companion object {
//        private var instance: HomeRepository? = null
//
//        fun getInstance(application: Application): HomeRepository? {
//            if (instance == null) instance = HomeRepository(application)
//            return instance
//        }
//    }
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