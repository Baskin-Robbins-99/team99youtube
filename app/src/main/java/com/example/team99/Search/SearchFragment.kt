package com.example.team99.Search

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.DTO.YoutubeVideosApi
import com.example.team99.Home.VideoItem
import com.example.team99.Retrofit.RetrofitClient
import com.example.team99.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class SearchFragment : Fragment() {
    lateinit var searchAdapter: SearchAdapter
    private lateinit var search: Context
    private lateinit var binding: FragmentSearchBinding
    private  var resItems : ArrayList<SearchItem> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.search = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchAdapter = SearchAdapter(search)
        binding.searchRv.adapter = searchAdapter
        setupListeners()
        return binding.root
    }
    private fun setupListeners(){
        binding.searchButton.setOnClickListener{
            val query = binding.searchEdit.text.toString()
            if (query.isNotEmpty()){
                saveLastSearch(requireContext(), query)
                fetchImageResults(query)
                searchAdapter.clearItem()
            }else {
                Toast.makeText(requireContext(),"검색어를 입력해주세요.",Toast.LENGTH_LONG).show()
            }
            val imm =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
            imm.hideSoftInputFromWindow(binding.searchEdit.windowToken, 0)
        }
    }
    private fun fetchImageResults(query: String) {

        val call = RetrofitClient.apiService().popularVideo(
            "snippet",
            "mostPopular",
            "KR",
            "AIzaSyBx5x3nhrglEpE6nZqj37ywin9WJW9WhDc"
        )

        call.enqueue(object : Callback<YoutubeVideosApi> {
            override fun onResponse(
                call: Call<YoutubeVideosApi>,
                response: Response<YoutubeVideosApi>
            ) {
                if (response.isSuccessful) {
                    response.body()?.items?.forEach {
                        val title = it?.snippet?.title?: ""
                        resItems.add(SearchItem(title))
                        Log.d("resItems",resItems.toString())
                    }
                } else {
                    Log.e("YouTubeApi","Error : ${response.errorBody()}")
                }
                searchAdapter.searchItems = resItems
                searchAdapter.notifyDataSetChanged()
            }


                override fun onFailure(call: Call<YoutubeVideosApi>, t: Throwable) {
            // 네트워크 오류 등에 대한 처리를 추가하세요.
            Log.e("TAG", "네트워크 오류 발생: ${t.message}")
    }})
    }
    fun  saveLastSearch(context: Context,query: String){
        val prefs =   context.getSharedPreferences("com.example.team99.Search", Context.MODE_PRIVATE)
        prefs.edit().putString("IMAGE_SEARCH_PREF", query).apply()
    }
}

