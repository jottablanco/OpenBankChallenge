package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.data.api.MarvelAPIService
import com.jorgereyes.openbankchallenge.data.repository.dataSourceImpl.HeroRemoteDataSourceImpl
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

  @Singleton
  @Provides
  fun provideHeroRemoteDataSource(marvelAPIService: MarvelAPIService): HeroRemoteDataSource {
    return HeroRemoteDataSourceImpl(marvelAPIService)
  }
}
