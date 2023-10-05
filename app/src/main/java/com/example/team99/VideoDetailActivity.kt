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
import androidx.recyclerview.widget.RecyclerView
import com.example.team99.Home.HomeFragment
import com.example.team99.Home.VideoAdpter
import com.example.team99.Home.VideoItem
import com.example.team99.Retrofit.RetrofitClient
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

        val videoId = "C3GouGa0noM"
        val iframeCode =
            "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe>"
        val videotitle = intent.getStringExtra("title")
        val videodescription = intent.getStringExtra("description")
        binding.tvDetailDesc.text = videodescription
        binding.tvTitle.text = videotitle
        // WebView에 iframe 코드 로드
        webView.loadData(iframeCode, "text/html", "utf-8")
        Log.d("VideoDetailActivity", "Iframe 코드가 WebView에 로드되었습니다.")

        //뒤로가기
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 즐겨찾기 이미지 클릭 시
        binding.ivDetailLike.setOnClickListener {
            if (!isFavorite) {
                binding.ivDetailLike.setImageResource(R.drawable.ic_bookmark)
                isFavorite = true
                val title = intent.getStringExtra("title")?: ""
                val description = intent.getStringExtra("description")
                val thumbnails = intent.getStringExtra("thumbnails")
                val videoItem = VideoItem(
                    title = title ?: "",
                    description = description ?: "",
                    categoryId = null,
                    chanelId = null,
                    thumbnails = thumbnails ?: ""
                )
                MainActivity.saveSelectedItem(mContext, videoItem)
            Toast.makeText(this, "내 보관함에 등록하였습니다!", Toast.LENGTH_SHORT).show()
            }
            else{
                val title = intent.getStringExtra("title") ?: ""
                MainActivity.deleteItem(mContext, title)
            binding.ivDetailLike.setImageResource(R.drawable.ic_bookmark_border)
        }
        }
    }

    }


