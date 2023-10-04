package com.example.team99.Search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team99.databinding.SearchVideoBinding

class SearchAdapter (private val search: Context) : RecyclerView.Adapter<SearchAdapter.PopularHolder>() {

    var searchItems: ArrayList<SearchItem> = ArrayList()
    fun clearItem() {
        searchItems.clear()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHolder {
        val binding = SearchVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularHolder, position: Int) {
        holder.search_titel.text = searchItems[position].search
    }
    override fun getItemCount(): Int {
        return searchItems.size
    }
    inner class PopularHolder(val binding: SearchVideoBinding) : RecyclerView.ViewHolder(binding.root){
        val search_titel =  binding.searchTxt
    }

}