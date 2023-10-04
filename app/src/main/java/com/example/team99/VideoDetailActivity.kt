package com.example.team99

import android.content.Intent
import android.os.Bundle
import com.example.team99.Home.VideoItem
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.team99.MyVideoFragment.Database.StorageDAO
import com.example.team99.databinding.ActivityVideoDetailBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class VideoDetailActivity : AppCompatActivity() {

    private val video: MediaStore.Video? = null
    private var toolbar: Toolbar? = null
    private val database: StorageDAO? = null
    private lateinit var favIcon: MenuItem


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


    fun setupToolbar(toolbarId: Int) {
        toolbar = findViewById<View>(toolbarId) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar.setTitle(null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_video_detail, menu)
        favIcon = menu.findItem(R.id.bookmark)
        favIcon.isVisible=true
        if (isFav()) favIcon.setIcon(R.drawable.ic_bookmark) else favIcon.setIcon(R.drawable.ic_bookmark_border)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.share) {
            shareVideo()
        } else if (itemId == R.id.bookmark) {
            if (isFav()) {
                deleteVideo()
            } else {
                saveVideo()
            }
        }
        return super.onOptionsItemSelected(item)
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

private fun <ActionBar> ActionBar?.setTitle(nothing: Nothing?) {

}
