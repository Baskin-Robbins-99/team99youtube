package com.example.team99.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//class ChannelAdapter ( private val mContext: Context) : RecyclerView.Adapter<ChannelAdapter.ChannelHolder>() {
//
//     var channelItems: ArrayList<ChannelItem> = ArrayList()
//
//
//     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelHolder {
//          val binding = ChannelItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//          return ChannelHolder(binding)
//     }
//
//     override fun getItemCount(): Int {
//          return channelItems.size
//     }
//
//     override fun onBindViewHolder(holder: ChannelHolder, position: Int) {
//          val channelItem = channelItems[position]
//          Glide.with(mContext)
//               .load(channelItems.thumbnails)
//               .into(holder.thumbnails)
//          holder.title.text = channelItem.title
//     }
//
//     inner class ChannelHolder(private val binding: ChannelItemBinding) :RecyclerView.ViewHolder(binding.root) {
//          var thumbnails: ImageView = binding.thumbnailsIv
//          var title: TextView = binding.titleTv
//     }
//
//
//}