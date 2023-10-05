package com.example.team99.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.team99.databinding.SearchItemBinding
import com.squareup.picasso.Picasso

class SearchAdapter : ListAdapter<SearchVideoItem, SearchAdapter.VideoViewHolder>(VideoDiffCallback()) {

    private val infoNumHelper = infoNum()

    class VideoViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)

        holder.binding.apply {
            Picasso.get().load(video.thumbnailUrl).into(ivVideoThumbnail)
            tvVideoDuration.text = infoNumHelper.convertDurationToHHMMSS(video.duration)
            tvVideoTitle.text = video.title
            tvVideoChannelName.text = video.channelName
            tvVideoViewCount.text = infoNumHelper.convertViewCount(video.viewCount)
            tvVideoDate.text = infoNumHelper.convertPublishedDate(video.date)

            // 채널 로고 로딩
            video.channelLogo?.let { logoUrl ->
                Picasso.get().load(video.channelLogo).into(ivChannelLogo)

            }
        }
    }
}

class VideoDiffCallback : DiffUtil.ItemCallback<SearchVideoItem>() {
    override fun areItemsTheSame(oldItem: SearchVideoItem, newItem: SearchVideoItem): Boolean {
        return oldItem.thumbnailUrl == newItem.thumbnailUrl
    }

    override fun areContentsTheSame(oldItem: SearchVideoItem, newItem: SearchVideoItem): Boolean {
        // Check the data for all items are the same or not.
        return oldItem == newItem
    }
}
