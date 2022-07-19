package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.presentation.adapter.FavoriteCharactersAdapter
import com.jorgereyes.openbankchallenge.presentation.adapter.HeroAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

  @Singleton
  @Provides
  fun providesHeroAdapter() : HeroAdapter {
    return HeroAdapter()
  }

  @Singleton
  @Provides
  fun provideFavCharactersAdapter() : FavoriteCharactersAdapter {
    return FavoriteCharactersAdapter()
  }
}
