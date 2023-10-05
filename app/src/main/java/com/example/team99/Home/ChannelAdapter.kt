package com.example.team99.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.databinding.VideoItemBinding

class ChannelAdapter (private val mContext: Context) : RecyclerView.Adapter<ChannelAdapter.ChanelHolder>() {
    var channelItems: MutableList<ChannelItem> = ArrayList()

    inner class ChanelHolder(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChanelHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VideoItemBinding.inflate(inflater, parent, false)
        return ChanelHolder(binding)
    }
    override fun onBindViewHolder(holder: ChanelHolder, position: Int) {
        val channelVideoItems = channelItems[position]
        val channelHolder = holder as ChanelHolder
        Glide.with(mContext)
            .load(channelVideoItems.thumbnails)
            .into(channelHolder.thumbnails)
        channelHolder.title.text = channelVideoItems.title
    }

    override fun getItemCount(): Int {
        return channelItems.size
    }

    fun setChannels(newVideos: List<ChannelItem>) {
        channelItems.clear()
        if (newVideos.isNotEmpty()) {
            channelItems.addAll(newVideos)
        }
        notifyDataSetChanged()
    }
}