package com.example.team99.MyVideoFragment.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.team99.MyVideoFragment.View.MyVideoFragment

//
//@Database(entities = [StorageDatabase::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun storageDAO(): StorageDAO
//
//    companion object {
//        @Volatile//데이터를 캐시에 넣지 않기 위해서 쓰는 코드
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "video_database")
//                        .fallbackToDestructiveMigration()
//                        .build()
//                            INSTANCE = instance
//                            instance
//            }
//        }
//    }
//}