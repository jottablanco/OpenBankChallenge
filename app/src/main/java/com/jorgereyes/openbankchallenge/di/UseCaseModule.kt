package com.jorgereyes.openbankchallenge.di

import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import com.jorgereyes.openbankchallenge.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Singleton
  @Provides
  fun provideGetHeroesListUseCase(heroesRepository: HeroesRepository): GetHeroesListUseCase {
    return GetHeroesListUseCase(heroesRepository)
  }

  @Singleton
  @Provides
  fun providesGetSavedHeroesListUseCase(heroesRepository: HeroesRepository): GetSavedHeroesListUseCase {
    return GetSavedHeroesListUseCase(heroesRepository)
  }

  @Singleton
  @Provides
  fun providesDeleteSavedHeroUseCase(heroesRepository: HeroesRepository): DeleteSavedHeroUseCase {
    return DeleteSavedHeroUseCase(heroesRepository)
  }

  @Singleton
  @Provides
  fun providesSaveHeroesListUseCase(heroesRepository: HeroesRepository): SaveHeroesListUseCase {
    return SaveHeroesListUseCase(heroesRepository)
  }

  @Singleton
  @Provides
  fun providesGetSavedFavoriteCharacters(heroesRepository: HeroesRepository): GetFavoriteCharactersUseCase {
    return GetFavoriteCharactersUseCase(heroesRepository)
  }

  @Singleton
  @Provides
  fun provideSaveFavoriteCharacterUseCase(heroesRepository: HeroesRepository) : SaveFavoriteCharactersUseCase {
    return SaveFavoriteCharactersUseCase(heroesRepository)
  }

}
