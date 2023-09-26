package com.example.team99

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.team99.databinding.ActivityVideoDetailBinding

class VideoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back()

    }
    private fun back() = with(binding) {
        playerView.setOnClickListener {
            finish()
        }
    }

}