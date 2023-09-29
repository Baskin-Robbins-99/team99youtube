package com.example.team99.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.team99.DTO.YoutubeCategoriesApi
import com.example.team99.databinding.VideoItemBinding

class CategoryAdapter(
    private val context1: Context
) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categories: List<YoutubeCategoriesApi.Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VideoItemBinding.inflate(inflater, parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = categories[position]
        // 카테고리 아이템을 바인딩하고 필요한 UI 업데이트 작업을 수행합니다.
        // 예를 들어, 카테고리의 제목을 TextView에 설정할 수 있습니다.
        holder.title.text = category.snippet?.title

        // 카테고리 클릭 이벤트 처리
        holder.itemView.setOnClickListener {
            // 선택한 카테고리에 대한 처리를 수행하도록 구현하세요.
            // 예를 들어, 선택한 카테고리에 따라 동영상 목록을 가져오거나 화면을 업데이트할 수 있습니다.
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
    }

    // 카테고리 목록 업데이트 메서드
    fun setCategories(categories: List<YoutubeCategoriesApi.Item>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}
