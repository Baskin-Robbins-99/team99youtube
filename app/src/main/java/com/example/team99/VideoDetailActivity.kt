package com.example.team99

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.team99.Home.VideoItem
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.databinding.ActivityVideoDetailBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class VideoDetailActivity : AppCompatActivity() {

    private var isLike = false
    private lateinit var webView: WebView
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var binding: ActivityVideoDetailBinding
    var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this

        adapter = VideoAdpter(mContext)

        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webView = findViewById(R.id.web_view)

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val videoId = "C3GouGa0noM"
        val iframeCode = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe>"

        // WebView에 iframe 코드 로드
        webView.loadData(iframeCode, "text/html", "utf-8")

        binding.llDetailLike.setOnClickListener {
            if(!isLike){
                binding.ivDetailLike.setImageResource(R.drawable.ic_bookmark)
                isLike = true
            }else {
                binding.ivDetailLike.setImageResource(R.drawable.ic_bookmark_border)
                isLike = false
            }
        }
        getVideoData()


    }


    override fun onBackPressed() {
        //2.5초이내에 한 번 더 뒤로가기 클릭 시
        if (System.currentTimeMillis() - backPressedTime < 2500) {
            super.onBackPressed()
            return
        }
        Toast.makeText(this, "한번 더 클릭 시 홈으로 이동됩니다.", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }


    private fun <ActionBar> ActionBar?.setTitle(nothing: Nothing?) {


    }

    private fun getVideoData() {
        RetrofitClient.apiService()
            .popularVideo("snippet", "mostPopular", "KR", "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
            .enqueue(object : Callback<YoutubeVideosApi> {
                override fun onResponse(
                    call: Call<YoutubeVideosApi>,
                    response: Response<YoutubeVideosApi>
                ) {
                    if (response.isSuccessful) {
                        Log.d("respone", response.body().toString())
                        val videosApi = response.body()
                        if (videosApi != null) {
                            val items = videosApi.items
                            if (items != null) {
                                for (item in items) {
                                    val snippet = item?.snippet
                                    if (snippet != null) {
                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                        val title = snippet.title ?: ""
                                        val videoItem = VideoItem(thumbnails, title)
                                        adapter.videoItems.add(videoItem)
                                    }
                                }
                                adapter.notifyDataSetChanged()
                            }
                        } else {


                        }
                    }
                }

                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {

                }
            })
    }
}