package com.example.imagerepositoryapp.di

import android.app.Application
import androidx.room.Room
import com.example.imagerepositoryapp.R
import com.example.imagerepositoryapp.persistence.AppDatabase
import com.example.imagerepositoryapp.persistence.ImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Persistence {

    @Provides
    fun provideImageDao(appDatabase: AppDatabase): ImageDao {
        return appDatabase.imageDao()

    }

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application):AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, application.getString(R.string.database))
            .fallbackToDestructiveMigration()
            .build()
    }
}