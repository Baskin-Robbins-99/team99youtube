package com.example.team99.MyVideoFragment.View

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomOpenHelper
import com.example.team99.MyVideoFragment.Database.AppDatabase
import com.example.team99.MyVideoFragment.Database.StorageDAO
import com.example.team99.MyVideoFragment.Database.StorageDatabase
import com.example.team99.MyVideoFragment.DummyData
import com.example.team99.MyVideoFragment.MyStorageAdapter
import com.example.team99.databinding.FragmentMyVideoBinding


class MyVideoFragment : Fragment() {
    private lateinit var binding: FragmentMyVideoBinding
    lateinit var mystorageadapter: MyStorageAdapter
    lateinit var helper: RoomOpenHelper
    lateinit var storageDao: StorageDAO
    private lateinit var myvideos : Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        myvideos = requireContext()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyVideoBinding.inflate(inflater, container, false)
        saveStorage()

        return binding.root
    }


    private fun saveStorage()  {
        mystorageadapter = MyStorageAdapter(myvideos)
            binding.myvdRcStorage.adapter = mystorageadapter
    }
}




