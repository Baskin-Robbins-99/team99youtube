package com.example.team99.Home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.CategoryAdapter
import com.example.team99.YoutubeVideosApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var categoryadapter: CategoryAdapter

    private var popularItem = mutableListOf<VideoItem>()
    private var categoryItem = mutableListOf<VideoItem>()

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
        categoryadapter = CategoryAdapter((mContext))
        mContext = requireContext()
        binding.popularRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecycle.adapter = adapter

        binding.cateoryRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.cateoryRecycle.adapter = categoryadapter
        categoryadapter.notifyDataSetChanged()

        binding.musicChip.setOnClickListener {
            val musicId = categoryItem.filter { item ->
                item.categoryId == "10"
            }
            categoryadapter.setCategoryVideos(musicId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.gameChip.setOnClickListener {
            val gameId = categoryItem.filter { item ->
                item.categoryId == "20"
            }
            categoryadapter.setCategoryVideos(gameId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.petChip.setOnClickListener {
            val petId = categoryItem.filter { item ->
                item.categoryId == "15"
            }
            categoryadapter.setCategoryVideos(petId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.sportChip.setOnClickListener {
            val sportId = categoryItem.filter { item ->
                item.categoryId == "17"
            }
            categoryadapter.setCategoryVideos(sportId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.travelChip.setOnClickListener {
            val travelId = categoryItem.filter { item ->
                item.categoryId == "19"
            }
            categoryadapter.setCategoryVideos(travelId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.entertainChip.setOnClickListener {
            val entertainId = categoryItem.filter { item ->
                item.categoryId == "24"
            }
            categoryadapter.setCategoryVideos(entertainId)
            categoryadapter.notifyDataSetChanged()
        }
        getVideoData()
    }

    private fun getVideoData() {
        RetrofitClient.apiService()
            .popularVideo(
                "snippet",
                "mostPopular",
                "KR",
                50,
                "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc"
            )
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
                                        val videoItem = VideoItem(thumbnails, title, categoryId)
                                        val categoryVideoItem =
                                            VideoItem(thumbnails, title, categoryId)
                                        categoryItem.add(categoryVideoItem)
                                        popularItem.add(videoItem)
                                        Log.d("HomegetData", "nyh ${categoryItem}")
                                    }
                                }
                                adapter.setVideos(categoryItem)
                                categoryadapter.setCategoryVideos(categoryItem)
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




