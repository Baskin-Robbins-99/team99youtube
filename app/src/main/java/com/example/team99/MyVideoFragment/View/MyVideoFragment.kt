package com.example.team99.MyVideoFragment.View

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.team99.MyVideoFragment.MyStorageAdapter
import com.example.team99.databinding.FragmentMyVideoBinding


class MyVideoFragment : Fragment() {
    private lateinit var binding: FragmentMyVideoBinding
    lateinit var mystorageadapter: MyStorageAdapter
    private lateinit var myvideos: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        myvideos = requireContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyVideoBinding.inflate(inflater, container, false)

        return binding.root
    }


}




