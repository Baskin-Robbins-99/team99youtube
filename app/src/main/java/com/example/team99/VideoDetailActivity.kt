package com.example.team99

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.team99.Home.VideoAdpter
import com.example.team99.databinding.ActivityVideoDetailBinding




class VideoDetailActivity : AppCompatActivity() {

    private var isFavorite = false
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var binding: ActivityVideoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this

        adapter = VideoAdpter(mContext)

        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videotitle = intent.getStringExtra("title")
        val videodescription = intent.getStringExtra("description")
        val thumbnailUrl = intent.getStringExtra("thumbnailUrl")
        binding.tvDetailDesc.text = videodescription
        binding.tvTitle.text = videotitle
        Log.d("DetailActivity","nyh $thumbnailUrl")
        Glide.with(this)
            .load(thumbnailUrl) // 이미지 URL
            .into(binding.imageView99)



       binding.btnBack.setOnClickListener {
           finish()
        }


        findViewById<ImageView>(R.id.iv_detailLike).setOnClickListener {
            if (!isFavorite) {
                isFavorite = true
                // Favorit에 추가되었다는 토스트 메시지 표시
                Toast.makeText(this, "Favorit에 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }


}