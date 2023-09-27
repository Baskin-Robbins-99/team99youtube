package com.example.team99.MyVideoFragment

import com.example.team99.MyVideoFragment.Database.StorageDatabase

data class DummyData(val uid: Int) {
    val list : MutableList<StorageDatabase>
        get() = dummyStorageData
    val dummyStorageData = mutableListOf(
        StorageDatabase(
            uid = 1,
            thumbnail = "https://news.samsungdisplay.com/wp-content/uploads/2018/08/8.jpg",
            title = "Video Title 1",
            channel = "Channel 1",
            liked = false
        ),
        StorageDatabase(
            uid = 2,
            thumbnail = "https://cdn.travie.com/news/photo/first/201710/img_19975_1.jpg",
            title = "Video Title 2",
            channel = "Channel 2",
            liked = false
        ),
            StorageDatabase(
                uid = 3,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 3",
                channel = "Channel 3",
                liked = false
            ),
            StorageDatabase(
                uid = 4,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 4",
                channel = "Channel 4",
                liked = false
            ),
            StorageDatabase(
                uid = 5,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 5",
                channel = "Channel 5",
                liked = false
            ),
            StorageDatabase(
                uid = 6,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 6",
                channel = "Channel 6",
                liked = false
            ),
            StorageDatabase(
                uid = 7,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 7",
                channel = "Channel 7",
                liked = false
            ),
            StorageDatabase(
                uid = 8,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 8",
                channel = "Channel 8",
                liked = false
            ),
            StorageDatabase(
                uid = 9,
                thumbnail = "https://www.econovill.com/news/photo/201812/353683_236958_5647.jpg",
                title = "Video Title 9",
                channel = "Channel 9",
                liked = false
            ))
    }


