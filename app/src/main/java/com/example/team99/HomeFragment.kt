package com.example.team99

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.Retrofit.Retrofit_interface
import com.example.team99.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mContext: Context
    private lateinit var adapter:VideoAdpter

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
        binding.popularRecyclerview.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerview.adapter = adapter

    }

    private fun getVideoData () {
        RetrofitClient.apiService().popularVideo("snippet","mostPopular"."KR" )
    }
        //selectVideo()

//    private fun selectVideo() = with(binding) {
//        homeImgThumbnail.setOnClickListener {
//            val intent = Intent(context, VideoDetailActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
