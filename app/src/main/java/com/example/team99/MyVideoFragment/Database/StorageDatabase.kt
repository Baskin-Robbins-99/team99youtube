package com.example.team99.MyVideoFragment.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//데이터베이스 테이블


@Entity
data class StorageDatabase(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "My_storage")
    val thumbnail: String?,
    val title : String?,
    val channel : String,
    val liked : Boolean = false
)