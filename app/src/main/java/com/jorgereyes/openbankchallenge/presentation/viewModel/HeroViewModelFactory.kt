package com.jorgereyes.openbankchallenge.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jorgereyes.openbankchallenge.domain.usecase.*

class HeroViewModelFactory (
  private val app: Application,
  private val getHeroesListUseCase: GetHeroesListUseCase,
  private val getSavedHeroesListUseCase: GetSavedHeroesListUseCase,
  private val getFavoriteCharactersUseCase: GetFavoriteCharactersUseCase,
  private val deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
  private val saveHeroesListUseCase: SaveHeroesListUseCase,
  private val saveFavoriteCharactersUseCase: SaveFavoriteCharactersUseCase
): ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return HeroViewModel(
      app,
      getHeroesListUseCase,
      getSavedHeroesListUseCase,
      deleteSavedHeroUseCase,
      saveHeroesListUseCase,
      getFavoriteCharactersUseCase,
      saveFavoriteCharactersUseCase
    ) as T
  }

}
