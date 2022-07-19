package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.BuildConfig
import com.jorgereyes.openbankchallenge.data.api.MarvelAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

  @Singleton
  @Provides
  fun provideRetrofit() : Retrofit {

    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
      .addInterceptor(logger)
      .build()

    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .baseUrl(BuildConfig.BASE_URL)
      .build()
  }

  @Singleton
  @Provides
  fun provideMarvelAPIService(retrofit: Retrofit): MarvelAPIService {
    return retrofit.create(MarvelAPIService::class.java)
  }
}
