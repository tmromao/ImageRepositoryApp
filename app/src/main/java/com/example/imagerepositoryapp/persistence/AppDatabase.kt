package com.example.imagerepositoryapp.persistence

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imagerepositoryapp.Image

@Database(entities = [Image::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}