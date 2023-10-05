package com.example.team99

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.team99.Home.HomeFragment
import com.example.team99.Home.VideoAdpter
import com.example.team99.Home.VideoItem
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.databinding.ActivityVideoDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class VideoDetailActivity : AppCompatActivity() {

    private var isFavorite = false
    private lateinit var webView: WebView
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var binding: ActivityVideoDetailBinding

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
        Log.d("VideoDetailActivity", "Iframe 코드가 WebView에 로드되었습니다.")

        // 이미지 버튼 클릭 시
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            // 홈 프래그먼트로 이동
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }

        // 즐겨찾기 이미지 클릭 시
        findViewById<ImageView>(R.id.iv_detailLike).setOnClickListener {
            if (!isFavorite) {
                isFavorite = true
                // Favorit에 추가되었다는 토스트 메시지 표시
                Toast.makeText(this, "Favorit에 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        getVideoData()
    }

    private fun getVideoData() {
        RetrofitClient.apiService()
            .popularVideo("snippet", "mostPopular", "KR", 25,"AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
            .enqueue(object : Callback<YoutubeVideosApi> {
                override fun onResponse(
                    call: Call<YoutubeVideosApi>,
                    response: Response<YoutubeVideosApi>
                ) {
                    if (response.isSuccessful) {
                        val videosApi = response.body()
                        if (videosApi != null) {
                            val items = videosApi.items
                            if (items != null) {
                                for (item in items) {
                                    val snippet = item?.snippet
                                    if (snippet != null) {
                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                        val title = snippet.title ?: ""
                                        val categoryId = snippet.categoryId ?: ""
                                        val chanelId = snippet.channelId ?: ""
                                        val description = snippet.description ?: ""// Description 추가
                                        val videoItem = VideoItem(thumbnails, title, categoryId, chanelId ,description)
                                        adapter.videoItems.add(videoItem)
                                    }
                                }
                                adapter.notifyDataSetChanged()
                                binding.tvDetailDesc.text = VideoItem.description
                                binding.tvTitle.text = VideoItem.title
                            }
                        }

                    }else {
                        // 실패 처리
                        Log.d("API", "Error: ${response.code()}")
                    }

                }

                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {
                    Log.d("API", "Error: ${t.message}")
                // 네트워크 오류 등으로 실패한 경우의 처리
                }
            })
    }

}