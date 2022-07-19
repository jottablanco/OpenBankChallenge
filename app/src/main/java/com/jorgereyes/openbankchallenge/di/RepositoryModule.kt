package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.data.repository.HeroRepositoryImpl
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroLocalDataSource
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroRemoteDataSource
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Singleton
  @Provides
  fun provideHeroRepository(
    heroLocalDataSource: HeroLocalDataSource,
    heroRemoteDataSource: HeroRemoteDataSource
  ): HeroesRepository {
    return HeroRepositoryImpl(heroRemoteDataSource, heroLocalDataSource)
  }
}
