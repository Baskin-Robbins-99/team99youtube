package com.example.team99

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.Home.VideoItem
import com.example.team99.databinding.VideoItemBinding

class VideoAdpter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var videoItems: ArrayList<VideoItem> = ArrayList()
    var catevideoItems: ArrayList<CategoryVideoItem> = ArrayList()

    private val VIEW_TYPE_POPULAR = 1
    private val VIEW_TYPE_CATEGORY = 2
    private val VIEW_TYPE_CHANNEL = 3


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_POPULAR -> {
                val binding = VideoItemBinding.inflate(inflater, parent, false)
                PopularHolder(binding)
            }

            VIEW_TYPE_CATEGORY -> {
                val binding = VideoItemBinding.inflate(inflater, parent, false)
                CategoryHolder(binding)
            }

            VIEW_TYPE_CHANNEL -> {
                val binding = VideoItemBinding.inflate(inflater, parent, false)
                ChannelHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_POPULAR -> {
                val popularHolder = holder as PopularHolder
                val videoItem = videoItems[position]
                Glide.with(mContext)
                    .load(videoItem.thumbnails)
                    .into(popularHolder.thumbnails)
                popularHolder.title.text = videoItem.title
            }

            VIEW_TYPE_CATEGORY -> {
                val categoryHolder = holder as CategoryHolder
                val videoItem = videoItems[position]
                Glide.with(mContext)
                    .load(videoItem.thumbnails)
                    .into(categoryHolder.thumbnails)
                categoryHolder.title.text = videoItem.title
            }

            VIEW_TYPE_CHANNEL -> {
                val channelHolder = holder as ChannelHolder
                // 채널 아이템 바인딩 코드 작성
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
        var thumbnails: ImageView = binding.thumbnails
        var title: TextView = binding.title

        init {
            thumbnails.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickItem = videoItems[position]
                    val intent = Intent(thumbnails.context, VideoDetailActivity::class.java)
                    intent.putExtra("key", videoItems)
                    thumbnails.context.startActivity(intent)
                }
            }
        }
    }

    inner class CategoryHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var thumbnails: ImageView = binding.thumbnails
        var title: TextView = binding.title

        init {
            thumbnails.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    videoItems[position]
                    val intent = Intent(thumbnails.context, VideoDetailActivity::class.java)
                    intent.putExtra("key", videoItems)
                    thumbnails.context.startActivity(intent)
                }
            }
        }
    }

    inner class ChannelHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // 채널 아이템 바인딩 코드 작성
    }

    fun setVideos(newCategoryVideos: List<CategoryVideoItem>) {
        catevideoItems.clear()
        if (newCategoryVideos.isNotEmpty()) {
            catevideoItems.addAll(newCategoryVideos)
        }
        notifyDataSetChanged()
    }


}

