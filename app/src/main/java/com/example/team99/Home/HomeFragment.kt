package com.example.team99.Home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.CategoryVideoItem
import com.example.team99.YoutubeVideosApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.VideoAdpter
import com.example.team99.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private var popularItem = mutableListOf<VideoItem>()
    private var categoryItem = mutableListOf<VideoItem>()
//    private val viewModel: VideoCategoryViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = VideoAdpter(mContext)
        mContext = requireContext()
        binding.popularRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecycle.adapter = adapter

        binding.cateoryRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.cateoryRecycle.adapter = adapter

        // 카테고리 선택 시 동영상 목록 업데이트

        binding.aniChip.setOnClickListener {
            val animalId = categoryItem.filter { item ->

                item.type == 2 &&
                item.categoryId == "15"
            }

            Log.d("aniChip","nyh ${animalId}")
            adapter.setCategoryVideos(animalId)
        }
        binding.musicChip.setOnClickListener {
            val musicId = categoryItem.filter { item ->
                item.type == 2 &&
                item.categoryId == "20"
            }
            adapter.setCategoryVideos(musicId)
        }

        getVideoData()
    }

    private fun getVideoData() {
        RetrofitClient.apiService()
            .popularVideo("snippet", "mostPopular", "KR", "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
            .enqueue(object : Callback<YoutubeVideosApi> {
                @SuppressLint("NotifyDataSetChanged")
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
                                categoryItem.clear()
                                popularItem.clear()
                                for (item in items) {
                                    val snippet = item?.snippet
                                    if (snippet != null) {
                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                        val title = snippet.title ?: ""
                                        val categoryId = snippet.categoryId ?: ""
                                        val videoItem = VideoItem(thumbnails, title, categoryId, 1)
                                        val categoryVideoItem = VideoItem(thumbnails, title, categoryId, 2)
                                        categoryItem.add(categoryVideoItem)
                                        popularItem.add(videoItem)
                                        Log.d("HomegetData","nyh ${categoryItem}")
                                    }
                                }
                                adapter.setVideos(categoryItem)
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




