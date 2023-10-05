package com.example.team99.MyVideoFragment.Database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.team99.Home.VideoItem
import com.example.team99.MainActivity
import com.example.team99.Retrofit.Retrofit_interface

class MyVideoViewModel : ViewModel() {
    // LiveData를 사용하여 북마크된 아이템 리스트를 관리
    private val _bookmarkedItems = MutableLiveData<List<VideoItem>>()
    val bookmarkedItems: LiveData<List<VideoItem>> get() = _bookmarkedItems

    // 저장된 북마크 아이템들을 가져오는 함수
    fun getBookmarkedItems(context: Context) {
        // Utils 클래스 또는 SharedPreferences 등을 이용해 저장된 북마크를 가져와서 _bookmarkedItems에 저장
        // 예: _bookmarkedItems.value = MainActivity.getPrefBookmarkItems(context)
    }

    // 북마크 아이템 추가 함수 (예: 북마크 아이템을 추가하는 메서드)
    fun addBookmarkItem(item: VideoItem) {
        // 북마크 아이템을 _bookmarkedItems에 추가하고 업데이트
        val currentList = _bookmarkedItems.value.orEmpty().toMutableList()
        currentList.add(item)
        _bookmarkedItems.value = currentList
    }

    // 북마크 아이템 제거 함수 (예: 북마크 아이템을 제거하는 메서드)
    fun removeBookmarkItem(item: VideoItem) {
        // 북마크 아이템을 _bookmarkedItems에서 제거하고 업데이트
        val currentList = _bookmarkedItems.value.orEmpty().toMutableList()
        currentList.remove(item)
        _bookmarkedItems.value = currentList
    }
}
//class SharedViewModel : ViewModel() {
//
//    private val _deletedItemUrls = MutableLiveData<Event<List<String>>>()
//    val deletedItemUrls: LiveData<Event<List<String>>> get() = _deletedItemUrls
//
//    /**
//     * 사용자가 이미지를 삭제할 때 호출되는 함수입니다.
//     * @param url 삭제된 이미지의 URL
//     */
//    fun addDeletedItemUrls(url: String) {
//        val currentList = _deletedItemUrls.value?.peekContent() ?: emptyList()
//        _deletedItemUrls.value = Event(currentList + url)
//    }
//
//    /**
//     * 삭제된 아이템 URL 리스트를 초기화합니다.
//     */
//    fun clearDeletedItemUrls() {
//        _deletedItemUrls.value = Event(emptyList())
//    }
//
//}
//open class Event<out T>(private val content: T) {
//
//    private var hasBeenHandled = false
//
//    /**
//     * 내용을 반환하고 다시 사용되지 않게 합니다.
//     */
//    fun getContentIfNotHandled(): T? {
//        return if (hasBeenHandled) {
//            null
//        } else {
//            hasBeenHandled = true
//            content
//        }
//    }
//
//    /**
//     * 내용을 반환합니다. 이미 처리되었더라도 반환됩니다.
//     */
//    fun peekContent(): T = content
//}
