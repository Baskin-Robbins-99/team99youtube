package com.example.team99.MyVideoFragment.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.Objects


@Database(entities = [StorageDatabase::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storageDAO(): StorageDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val MIGRATION_1_2 = object : Migration(1,2)
        {
            override fun migrate(database: SupportSQLiteDatabase) {
            }
        }
        fun getDatabase(context: Context) : AppDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context, AppDatabase::class.java,"video_database")
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
        return INSTANCE as AppDatabase
        }
    }
}