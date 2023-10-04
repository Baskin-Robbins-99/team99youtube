package com.example.team99

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.databinding.VideoItemBinding

class VideoAdpter (private val mContext: Context) : RecyclerView.Adapter<VideoAdpter.PopularHolder>() {

    var videoItems: ArrayList<VideoItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdpter.PopularHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularHolder, position: Int) {
        val videoItem = videoItems[position]
        Glide.with(mContext)
            .load(videoItem.thumbnails)
            .into(holder.thumbnails)
        holder.title.text = videoItem.title
    }
    override fun getItemCount(): Int {
        return videoItems.size
    }
    inner class PopularHolder(val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root){
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

    }

}