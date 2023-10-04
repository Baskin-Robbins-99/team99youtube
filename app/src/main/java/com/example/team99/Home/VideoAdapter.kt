package com.example.team99.Home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.MainActivity
import com.example.team99.VideoDetailActivity
import com.example.team99.databinding.VideoItemBinding


class VideoAdapter(private val mContext: Context) :
    RecyclerView.Adapter<VideoAdapter.PopularHolder>() {

    var videoItems: ArrayList<VideoItem> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHolder {
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

    inner class PopularHolder(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        var thumbnails: ImageView = binding.thumbnails
        var title: TextView = binding.title
        var item = binding.consItem
        init {
            item.setOnClickListener(this)
        }
       override fun onClick(view: View) {
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val selectedItem = videoItems[position]
            MainActivity.saveSelectedItem(view.context, videoItems)
            val intent = Intent(view.context, VideoDetailActivity::class.java)
            intent.putExtra("videoitem", selectedItem)
            view.context.startActivity(intent)
            Log.d("item", "Received VideoItem: ${selectedItem}")
        }

    }


}

