package com.example.imagerepositoryapp.di

import com.example.imagerepositoryapp.network.ImageService
import com.example.imagerepositoryapp.persistence.ImageDao
import com.example.imagerepositoryapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object Repository {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        imageService: ImageService,
        imageDao: ImageDao
    ):MainRepository{
        return MainRepository(imageService, imageDao)
    }

}