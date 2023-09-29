package com.example.team99.Home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Home.ViewModel.CategoryViewModel
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.VideoAdpter
import com.example.team99.VideoItem
import com.example.team99.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var adapter: VideoAdpter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var viewModel: CategoryViewModel

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
        mContext = requireContext()
        adapter = VideoAdpter(mContext)
        categoryAdapter = CategoryAdapter(mContext)
        binding.popularRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecycle.adapter = adapter
        binding.cateoryRecycle.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.cateoryRecycle.adapter = categoryAdapter


        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedChip = group.findViewById<Chip>(checkedId)
            if (selectedChip != null) {
                val selectedCategory = selectedChip.text.toString()

                // 선택된 카테고리에 따라 ViewModel에 요청하여 비디오 목록 업데이트
                viewModel.fetchVideoCategories(selectedCategory)

            }
        }


        // Set RecyclerView Adapters
        viewModel.categoryVideos.observe(viewLifecycleOwner) { categories ->
            categoryAdapter.setCategories(categories ?: emptyList())
        }

// Fetch initial categories
        viewModel.fetchVideoCategories("YOUR_INITIAL_CATEGORY")
        getVideoData()
    }

    private fun getVideoData() {
        RetrofitClient.apiService
            .popularVideo("snippet", "mostPopular", "KR", "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc")
            .enqueue(object : Callback<YoutubeVideosApi> {
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
                                for (item in items) {
                                    val snippet = item?.snippet
                                    if (snippet != null) {
                                        val thumbnails = snippet.thumbnails?.default?.url ?: ""
                                        val title = snippet.title ?: ""
                                        val videoItem = VideoItem(thumbnails, title)
                                        adapter.videoItems.add(videoItem)
                                    }
                                }
                                adapter.notifyDataSetChanged()
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





