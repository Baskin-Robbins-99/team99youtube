package com.example.team99.MyVideoFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.team99.Home.VideoItem
import com.example.team99.MainActivity
import com.example.team99.databinding.MyvdVideoBinding


class MyStorageAdapter(private val context: Context) :
    RecyclerView.Adapter<MyStorageAdapter.MyStorageHolder>() {
    private val myvideos : ArrayList<VideoItem> = ArrayList()

    fun addAll(itemList: List<VideoItem>) {
        myvideos.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyStorageHolder {
        val binding = MyvdVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyStorageHolder(binding)
    }

    override fun onBindViewHolder(holder: MyStorageHolder, position: Int) {
        val currentItem = myvideos[position]
        Glide.with(context)
            .load(currentItem.thumbnails)
            .into(holder.videoThumnail)
        holder.title.text = currentItem.title
        holder.item.setOnClickListener{
            MainActivity.deleteItem(context, currentItem.title.toString())
            myvideos.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return myvideos.size
    }

    inner class MyStorageHolder(val binding: MyvdVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val videoThumnail = binding.myvdVideoThumbnail
        val title = binding.myvdVideoTitle
        val item = binding.myvdVideo

    }
}


