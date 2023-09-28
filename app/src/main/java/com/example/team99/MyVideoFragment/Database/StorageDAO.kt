package com.example.team99.MyVideoFragment.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StorageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//충돌 시 새 데이터로 교체 하는 코드
    fun insertAll(vararg users: StorageDatabase)
    @Delete
    fun delete(user: StorageDatabase)
    @Query("SELECT * FROM StorageDatabase")
    fun getAll(): LiveData<List<StorageDatabase>>

    @Query("SELECT * FROM StorageDatabase WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<StorageDatabase>

}