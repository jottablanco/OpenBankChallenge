package com.jorgereyes.openbankchallenge.di

import android.app.Application
import com.jorgereyes.openbankchallenge.domain.usecase.*
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

  @Singleton
  @Provides
  fun providesHeroViewModelFactory(
    application: Application,
    getHeroesListUseCase: GetHeroesListUseCase,
    getFavoriteCharactersUseCase: GetFavoriteCharactersUseCase,
    getSavedHeroesListUseCase: GetSavedHeroesListUseCase,
    deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
    savedHeroesListUseCase: SaveHeroesListUseCase,
    saveFavoriteCharactersUseCase: SaveFavoriteCharactersUseCase

  ): HeroViewModelFactory {
    return HeroViewModelFactory(
      application,
      getHeroesListUseCase,
      getSavedHeroesListUseCase,
      getFavoriteCharactersUseCase,
      deleteSavedHeroUseCase,
      savedHeroesListUseCase,
      saveFavoriteCharactersUseCase
    )
  }
}
