package com.example.team99

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.team99.databinding.ActivityVideoDetailBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoDetailBinding
    var backPressedTime : Long = 0
    private var videoPlayer: SimpleExoPlayer? = null
    private var sampleUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
    private lateinit var video_player_view: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        video_player_view = findViewById(R.id.playerView);

        // ExoPlayer 인스턴스를 생성하고 소스를 플레이에 할당하여 비디오 플레이어 초기화
        videoPlayer = SimpleExoPlayer.Builder(this).build()
        video_player_view?.player = videoPlayer
        buildMediaSource()?.let {
            videoPlayer?.prepare(it)
        }
    }

    // MediaSource: 영상에 출력할 미디어 정보를 가져오는 클래스
    private fun buildMediaSource(): MediaSource? {
        val dataSourceFactory = DefaultDataSourceFactory(this, "sample")
        val mediaItem = MediaItem.fromUri(sampleUrl)
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mediaItem)
    }

    // 일시중지
    override fun onResume() {
        super.onResume()
        videoPlayer?.playWhenReady = true
    }

    // 정지
    override fun onStop() {
        super.onStop()
        videoPlayer?.playWhenReady = false
        if (isFinishing) {
            releasePlayer()
        }
    }

    // 종료
    private fun releasePlayer() {
        videoPlayer?.release()
    }


//    //private fun preparePlayer() {
//        exoPlayer = ExoPlayer.Builder(this).build()
//        exoPlayer?.playWhenReady = true
//        binding.playerView.player = exoPlayer
//        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
//        val mediaItem = MediaItem.fromUri(URL)
//        val mediaSource =
//           DashMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
//       exoPlayer?.setMediaSource(mediaSource)
//       exoPlayer?.seekTo(playbackPosition)
//       exoPlayer?.playWhenReady = playWhenReady
//        exoPlayer?.prepare()
//    }

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