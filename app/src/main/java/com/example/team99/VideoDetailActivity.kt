package com.example.team99

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.team99.databinding.ActivityVideoDetailBinding

class VideoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoDetailBinding
    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


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


}