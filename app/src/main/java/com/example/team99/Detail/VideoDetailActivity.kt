package com.example.team99.Detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.team99.Home.HomeAdapter.VideoAdpter
import com.example.team99.R
import com.example.team99.databinding.ActivityVideoDetailBinding


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

        val videoId = intent.getStringExtra("videoId")
        Log.d("kyi","${videoId}")
        val iframeCode = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe>"
        val videotitle = intent.getStringExtra("title")
        val videodescription = intent.getStringExtra("description")
        binding.tvDetailDesc.text = videodescription
        binding.tvTitle.text = videotitle

        // WebView에 iframe 코드 로드
        webView.loadData(iframeCode, "text/html", "utf-8")
        Log.d("VideoDetailActivity", "Iframe 코드가 WebView에 로드되었습니다.")

        // 이미지 버튼 클릭 시
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            finish()
        }

        // 즐겨찾기 이미지 클릭 시
        findViewById<ImageView>(R.id.iv_detailLike).setOnClickListener {
            if (!isFavorite) {
                isFavorite = true
                // Favorit에 추가되었다는 토스트 메시지 표시
                Toast.makeText(this, "Favorit에 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}