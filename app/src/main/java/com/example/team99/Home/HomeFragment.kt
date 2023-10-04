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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import com.example.team99.Home.ViewModel.HomeViewModel
import com.example.team99.MyVideoFragment
import com.example.team99.VideoDetailActivity
import com.example.team99.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private  lateinit var binding: FragmentHomeBinding
//    lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root

//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        // 뷰모델이 가지고 있는 값의 변경사항을 관찰할 수 있는 라이브 데이터를 옵저빙한다.
//        homeViewModel.currenValue.observe(viewLifecycleOwner, Observer {
//            binding.homeFrag.text = it.toString()
//        })
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view,savedInstanceState)
//        selectVideo()
//    }
//
//    private fun selectVideo() = with(binding) {
//        homeImgThumbnail.setOnClickListener {
//            val intent = Intent(context, VideoDetailActivity::class.java)
//            startActivity(intent)
//        }
   }
}