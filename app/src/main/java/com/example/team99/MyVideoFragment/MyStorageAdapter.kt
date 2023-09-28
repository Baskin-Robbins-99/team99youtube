package com.example.team99.MyVideoFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.MyVideoFragment.Database.StorageDatabase
import com.example.team99.databinding.MyvdVideoBinding
import com.example.team99.MyVideoFragment.DummyData



class MyStorageAdapter(private val myvideos : Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var myvideo = mutableListOf<StorageDatabase>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  RecyclerView.ViewHolder {
        val binding = MyvdVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyStorageHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder , position: Int) {
        val currentItem = myvideo[position]
        if (holder is MyStorageHolder){
        Glide.with(myvideos)
            .load(currentItem.thumbnail)
            .into(holder.video_thumnail)
            holder.title.text = myvideo[position].title
            holder.channel.text = myvideo[position].channel
        }
        }

        override fun getItemCount(): Int {
            return myvideo.size
        }

        inner class MyStorageHolder(val binding: MyvdVideoBinding) :
            RecyclerView.ViewHolder(binding.root) {
            val video_thumnail = binding.myvdVideoThumbnail
            val title = binding.myvdVideoTitle
            val channel = binding.myvdVideoId
        }
    }

