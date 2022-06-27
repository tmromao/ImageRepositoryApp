package com.example.imagerepositoryapp.di

import android.content.Context
import coil.ImageLoader
import coil.util.CoilUtils
import com.example.imagerepositoryapp.network.ImageService
import com.example.imagerepositoryapp.network.RequestInterceptor
import com.skydoves.sandwich.coroutines.CoroutinesDataSourceCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    @Singleton
    fun okHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .cache(CoilUtils.createDefaultCache(context))
            .build()
    }

    @Provides
    @Singleton
    fun ImageLoader(@ApplicationContext context: Context,
                    okHttpClient: OkHttpClient): ImageLoader {
        return ImageLoader.Builder(context)
            .okHttpClient { okHttpClient }
            .build()
    }

    @Provides
    @Singleton
    fun Retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gist.githubusercontent.com/tmromao/8b1568411ec728ed778d120b737b4295/raw/a2e64d9e972496709e2a143414223e94f83daac9/json")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutinesDataSourceCallAdapterFactory.create())
            .build()
    }

    fun provideImageService(retrofit: Retrofit): ImageService {
        return retrofit.create(ImageService::class.java)
    }
}