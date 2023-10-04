package com.example.team99.MyVideoFragment.View

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.team99.Home.VideoItem
import com.example.team99.MainActivity
import com.example.team99.MyVideoFragment.MyStorageAdapter
import com.example.team99.databinding.FragmentMyVideoBinding

class MyVideoFragment : Fragment() {
    private lateinit var binding: FragmentMyVideoBinding
    lateinit var mystorageadapter: MyStorageAdapter
    private val myvideo = mutableListOf<VideoItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyVideoBinding.inflate(inflater, container, false)
        mystorageadapter = MyStorageAdapter(requireContext(),myvideo)
        binding.myvdRcStorage.adapter = mystorageadapter
        return binding.root
    }
}




