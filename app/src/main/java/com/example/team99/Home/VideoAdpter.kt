package com.example.team99.Home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.MainActivity
import com.example.team99.VideoDetailActivity
import com.example.team99.databinding.VideoItemBinding

class VideoAdpter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var videoItems: ArrayList<VideoItem> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VideoItemBinding.inflate(inflater, parent, false)
        return PopularHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val videoItem = videoItems[position]
        val popularHolder = holder as PopularHolder

        Glide.with(mContext)
            .load(videoItem.thumbnails)
            .into(popularHolder.thumbnails)
        popularHolder.title.text = videoItem.title
    }


    override fun getItemCount(): Int {
        return videoItems.size
    }


    inner class PopularHolder(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

        init {
            thumbnails.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                val clickItem = videoItems[position]
                if (position != RecyclerView.NO_POSITION) {
                    MainActivity.saveSelectedItem(mContext, clickItem)
                    Log.d("itemd", "$clickItem")

                    val intent = Intent(thumbnails.context, VideoDetailActivity::class.java)
                    intent.putExtra("title", clickItem.title)
                    intent.putExtra("description", clickItem.description)
                    intent.putExtra("thumbnailUrl", clickItem.thumbnails)
                    thumbnails.context.startActivity(intent)
                }
            }
        }
    }


    fun setVideos(newVideos: List<VideoItem>) {
        videoItems.clear()
        if (newVideos.isNotEmpty()) {
            videoItems.addAll(newVideos)

        }
        notifyDataSetChanged()

    }


}