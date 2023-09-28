package com.example.team99

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.databinding.VideoItemBinding

class VideoAdpter (private val mContext: Context) : RecyclerView.Adapter<VideoAdpter.PopularHolder>() {

    private var videoItems: ArrayList<VideoItem> = ArrayList()

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
        var thumbnails: ImageView = binding.thumbnails
        var title: TextView = binding.title
        init{
            thumbnails.setOnClickListener {
                val position =adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val clickItem = videoItems[position]
                    val intent = Intent(thumbnails.context,VideoDetailActivity::class.java)
                  intent.putExtra("key", videoItems)
                    thumbnails.context.startActivity(intent)
                }
            }
        }

    }

    @SuppressLint("NotifiDataSetChanged")
    internal fun setData(newItems: VideoItem){

    }

}