package com.example.team99.MyVideoFragment.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
//
//@Dao
//interface StorageDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)//충돌 시 새 데이터로 교체 하는 코드
//    fun insert(vararg users: StorageDatabase)
//    @Delete
//    fun delete(user: StorageDatabase)
//    @Query("SELECT * FROM StorageDatabase")
//    fun getAll(): LiveData<List<StorageDatabase>>
//    @Update
//    fun update(user: StorageDatabase)
//
//    @Query("SELECT * FROM StorageDatabase WHERE liked =  :selected")
//        fun getselectedData(selected: Boolean = true) : List<StorageDatabase>
//}