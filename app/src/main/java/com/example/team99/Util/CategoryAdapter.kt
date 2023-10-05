package com.example.team99

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.Home.VideoItem
import com.example.team99.databinding.VideoItemBinding

class CategoryAdapter (private val mContext: Context) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    var categoryVideoItems: MutableList<VideoItem> = ArrayList()

    inner class CategoryHolder(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VideoItemBinding.inflate(inflater, parent, false)
        return CategoryHolder(binding)
    }
    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val categoryVideoItems = categoryVideoItems[position]
        val categoryHolder = holder as CategoryHolder
        Glide.with(mContext)
            .load(categoryVideoItems.thumbnails)
            .into(categoryHolder.thumbnails)
        categoryHolder.title.text = categoryVideoItems.title
    }

    override fun getItemCount(): Int {
        return categoryVideoItems.size
    }

    fun setCategoryVideos(newVideos: List<VideoItem>) {
        categoryVideoItems.clear()
        if (newVideos.isNotEmpty()) {
            categoryVideoItems.addAll(newVideos)
        }
        notifyDataSetChanged()
    }
}