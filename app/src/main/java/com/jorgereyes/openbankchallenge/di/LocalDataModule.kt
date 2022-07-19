package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.data.db.FavoriteCharacterDAO
import com.jorgereyes.openbankchallenge.data.db.HeroDAO
import com.jorgereyes.openbankchallenge.data.repository.dataSourceImpl.HeroLocalDataSourceImpl
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

  @Singleton
  @Provides
  fun provideLocalDataSource(heroDAO: HeroDAO, favoriteCharacterDAO: FavoriteCharacterDAO): HeroLocalDataSource {
    return HeroLocalDataSourceImpl(heroDAO, favoriteCharacterDAO)
  }
}
