package com.example.team99.MyVideoFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.Home.VideoItem
import com.example.team99.MainActivity
import com.example.team99.databinding.MyvdVideoBinding


class MyStorageAdapter(private val context: Context , private val myvideo: MutableList<VideoItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  RecyclerView.ViewHolder {
        val binding = MyvdVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyStorageHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder , position: Int) {
        val currentItem = myvideo[position]
        if (holder is MyStorageHolder){
        Glide.with(context)
            .load(currentItem.thumbnails)
            .into(holder.videoThumnail)
            holder.title.text = myvideo[position].title
        }
        }

        override fun getItemCount(): Int {
            return myvideo.size
        }

        inner class MyStorageHolder(val binding: MyvdVideoBinding) :
            RecyclerView.ViewHolder(binding.root) {
            val videoThumnail = binding.myvdVideoThumbnail
            val title = binding.myvdVideoTitle
        }
    }

