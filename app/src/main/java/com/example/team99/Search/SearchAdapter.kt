package com.example.team99.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.team99.databinding.SearchItemBinding
import com.squareup.picasso.Picasso // Picasso 라이브러리 추가

class SearchAdapter : ListAdapter<SearchVideoItem, SearchAdapter.VideoViewHolder>(VideoDiffCallback()) {

    class VideoViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)

        holder.binding.apply {
            // ivVideoThumbnail에 이미지 로딩 (Picasso 사용)
            Picasso.get().load(video.thumbnailUrl).into(ivVideoThumbnail)
            tvVideoDuration.text = video.duration
            tvVideoTitle.text = video.title
            tvVideoChannelName.text = video.channelName
            tvVideoViewCount.text = video.viewCount
            tvVideoDate.text = video.date
        }
    }
}

class VideoDiffCallback : DiffUtil.ItemCallback<SearchVideoItem>() {
    override fun areItemsTheSame(oldItem: SearchVideoItem, newItem: SearchVideoItem): Boolean {
        // 썸네일 URL을 비교하여 같으면 같은 아이템으로 간주
        return oldItem.thumbnailUrl == newItem.thumbnailUrl
    }

    override fun areContentsTheSame(oldItem: SearchVideoItem, newItem: SearchVideoItem): Boolean {
        // Check the data for all items are the same or not.
        return oldItem == newItem
    }
}
