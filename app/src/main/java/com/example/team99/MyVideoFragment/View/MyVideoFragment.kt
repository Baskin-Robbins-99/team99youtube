package com.example.team99.MyVideoFragment.View


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.team99.MainActivity.Companion.getPrefBookmarkItems
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
        mystorageadapter = MyStorageAdapter(myvideos)
        binding.myvdRcStorage.adapter = mystorageadapter
        val layoutManager = GridLayoutManager(myvideos, 2)
        binding.myvdRcStorage.layoutManager = layoutManager

        val bookmarkedItems = getPrefBookmarkItems(myvideos) // 수정 필요
        mystorageadapter.addAll(bookmarkedItems)


        return binding.root
    }
}




