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

    private val VIEW_TYPE_POPULAR = 1
    private val VIEW_TYPE_CATEGORY = 2
//    private val VIEW_TYPE_CHANNEL = 3


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> {
                val binding = VideoItemBinding.inflate(inflater, parent, false)
                PopularHolder(binding)
            }

            2 -> {
                val binding = VideoItemBinding.inflate(inflater, parent, false)
                CategoryHolder(binding)
            }

//            3 -> {
//                val binding = VideoItemBinding.inflate(inflater, parent, false)
//                ChannelHolder(binding)
//            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val videoItem = videoItems[position]
        when (getItemViewType(position)) {
            1 -> {
                val popularHolder = holder as PopularHolder
                Glide.with(mContext)
                    .load(videoItem.thumbnails)
                    .into(popularHolder.thumbnails)
                popularHolder.title.text = videoItem.title
            }

            2 -> {
                val categoryHolder = holder as CategoryHolder
                Glide.with(mContext)
                    .load(videoItem.thumbnails)
                    .into(categoryHolder.thumbnails)
                categoryHolder.title.text = videoItem.title
            }

            3 -> {
//                val channelHolder = holder as ChannelHolder
//                Glide.with(mContext)
//                    .load(videoItem.thumbnails)
//                    .into(categoryHolder.thumbnails)
//                channelHolder.title.text = videoItem.title

            }
        }
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    override fun getItemViewType(position: Int): Int {
        val videoItem = videoItems[position]
        return when (videoItem) {
            is VideoItem -> VIEW_TYPE_POPULAR

            // 필요한 경우 CategoryItem과 ChannelItem을 구분하여 처리
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    inner class PopularHolder(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

        init {
            thumbnails.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                val clickItem = videoItems[position]
                if (position != RecyclerView.NO_POSITION) {
                    MainActivity.saveSelectedItem(mContext,clickItem)
                    Log.d("itemd", "$clickItem")




                    val intent = Intent(thumbnails.context, VideoDetailActivity::class.java)
                    intent.putExtra("key", videoItems)
                    thumbnails.context.startActivity(intent)
                }
            }
        }
    }

    inner class CategoryHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv

        init {
            thumbnails.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    videoItems[position]
                    val intent = Intent(thumbnails.context, VideoDetailActivity::class.java)
                    intent.putExtra("key", videoItems.toTypedArray())
                    thumbnails.context.startActivity(intent)
                }
            }
        }
    }

    inner class ChannelHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnailsIv
        var title: TextView = binding.titleTv
    }


    fun setCategoryVideos(newVideos: List<VideoItem>) {
//        val populars = videoItems.filter { it.type == 1 }
        videoItems.clear()
        if (newVideos.isNotEmpty()) {
            videoItems.addAll(newVideos)

        }
        videoItems.addAll(videoItems)
        notifyDataSetChanged()
    }

    fun setVideos(newVideos: List<VideoItem>){
        videoItems.clear()
        if (newVideos.isNotEmpty()) {
            videoItems.addAll(newVideos)

        }
        notifyDataSetChanged()

    }


}

