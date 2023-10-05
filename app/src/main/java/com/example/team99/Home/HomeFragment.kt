package com.example.team99.Home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.DTO.YoutubeChannelApi
import com.example.team99.Detail.VideoDetailActivity
import com.example.team99.Home.HomeAdapter.CategoryAdapter
import com.example.team99.Home.HomeAdapter.ChannelAdapter
import com.example.team99.Home.HomeAdapter.VideoAdpter
import com.example.team99.Home.Items.ChannelItem
import com.example.team99.Home.Items.VideoItem
import com.example.team99.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var categoryadapter: CategoryAdapter
    private lateinit var channeladapter: ChannelAdapter
    private var videoChannelIds = mutableListOf<String>()
    private var popularItem = mutableListOf<VideoItem>()
    private var categoryItem = mutableListOf<VideoItem>()
    private var channelItems = mutableListOf<ChannelItem>()
    private var selectedCategory = "20"


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
        categoryadapter = CategoryAdapter(mContext)
        channeladapter = ChannelAdapter(mContext)
        mContext = requireContext()



        binding.popularRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecycle.adapter = adapter

        binding.cateoryRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.cateoryRecycle.adapter = categoryadapter
        categoryadapter.notifyDataSetChanged()

        binding.channelRecycler.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.channelRecycler.adapter = channeladapter
        channeladapter.notifyDataSetChanged()


        binding.musicChip.setOnClickListener {
            val musicId = categoryItem.filter { item ->
                item.categoryId == "10"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (musicId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(musicId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.gameChip.setOnClickListener {
            val gameId = categoryItem.filter { item ->
                item.categoryId == "20"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (gameId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(gameId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.petChip.setOnClickListener {
            val petId = categoryItem.filter { item ->
                item.categoryId == "15"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (petId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(petId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.sportChip.setOnClickListener {
            val sportId = categoryItem.filter { item ->
                item.categoryId == "17"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (sportId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(sportId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.travelChip.setOnClickListener {
            val travelId = categoryItem.filter { item ->
                item.categoryId == "19"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (travelId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(travelId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.entertainChip.setOnClickListener {
            val entertainId = categoryItem.filter { item ->
                item.categoryId == "24"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (entertainId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(entertainId)
            categoryadapter.notifyDataSetChanged()
        }
        binding.comedyChip.setOnClickListener {
            val comedyId = categoryItem.filter { item ->
                item.categoryId == "23"
            }
            val matchingChannels = mutableListOf<ChannelItem>()

            for (channelItem in channelItems) {
                if (comedyId.any { it.chanelId == channelItem.channelId }) {
                    matchingChannels.add(channelItem)
                }
            }

            channeladapter.setChannels(matchingChannels)
            channeladapter.notifyDataSetChanged()
            categoryadapter.setCategoryVideos(comedyId)
            categoryadapter.notifyDataSetChanged()
        }
        getVideoData()
        getChannelData()
    }


    private fun getVideoData() {
        RetrofitClient.apiService()
            .popularVideo("snippet", "mostPopular", "KR", 50,"AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
            .enqueue(object : Callback<YoutubeVideosApi> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<YoutubeVideosApi>,
                    response: Response<YoutubeVideosApi>
                ) {
                    if (response.isSuccessful) {
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
                                        val chanelId = snippet.channelId ?: ""
                                        val description = snippet.description?: ""
                                        val videoId = item.videoId ?: ""
                                        val videoItem = VideoItem(thumbnails, title, categoryId, chanelId, description, videoId)
                                        val categoryVideoItem = VideoItem(thumbnails, title, categoryId, chanelId, description, videoId)
                                        categoryItem.add(categoryVideoItem)
                                        popularItem.add(videoItem)
                                        videoChannelIds.add(chanelId)
                                        Log.d("HomegetData","nyh ${categoryItem}")
                                    }
                                }
                                adapter.setVideos(categoryItem)
                                categoryadapter.setCategoryVideos(categoryItem)
                                getChannelData()
                            }
                        } else {
                        }
                    }
                }

                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {

                }
            })
    }
    private fun getChannelData() {
        for (channelId in videoChannelIds) {
            RetrofitClient.apiService()
                .categoryChannel("snippet", channelId, 10, "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
                .enqueue(object : Callback<YoutubeChannelApi> {
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onResponse(
                        call: Call<YoutubeChannelApi>,
                        response: Response<YoutubeChannelApi>
                    ) {
                        if (response.isSuccessful) {
                            val videosApi = response.body()
                            if (videosApi != null) {
                                val items = videosApi.items
                                if (items != null && items.isNotEmpty()) {
                                    val item = items[0]
                                    val snippet = item?.snippet
                                    if (snippet != null) {
                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                        val title = snippet.title ?: ""
                                        val channelId = item.id ?: ""
                                        val channelItem = ChannelItem(thumbnails, title, channelId)
                                        channelItems.add(channelItem)
                                        Log.d("HomeChannelgetData", "nyh ${channelItems}")
                                        channeladapter.setChannels(channelItems)
                                    }
                                }
                            } else {
                                Log.d("HomeChannelgetData", "Failed to get channel data")
                            }
                        }
                    }

                    override fun onFailure(call: Call<YoutubeChannelApi>, t: Throwable) {
                        Log.d("HomeChannelgetData", "Error: ${t.message}")
                    }
                })
        }
    }
}
//