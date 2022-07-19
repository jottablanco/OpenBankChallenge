package com.jorgereyes.openbankchallenge.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jorgereyes.openbankchallenge.data.model.APIResponse
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.data.util.Resource
import com.jorgereyes.openbankchallenge.domain.usecase.*
import com.jorgereyes.openbankchallenge.util.isNetworkAvailable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class HeroViewModel constructor(
  private val app: Application,
  private val getHeroesListUseCase: GetHeroesListUseCase,
  private val getSavedHeroesListUseCase: GetSavedHeroesListUseCase,
  private val deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
  private val saveHeroesListUseCase: SaveHeroesListUseCase,
  private val getFavoriteCharactersUseCase: GetFavoriteCharactersUseCase,
  private val saveFavoriteCharactersUseCase: SaveFavoriteCharactersUseCase
) : AndroidViewModel(app) {

  val heroesData: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

  fun getHeroesList() = viewModelScope.launch(Dispatchers.IO) {
    heroesData.postValue(Resource.Loading())

    try {
        if(isNetworkAvailable(app)) {
          val apiResult =  getHeroesListUseCase.execute()
          heroesData.postValue(apiResult)
        } else {
          heroesData.postValue(Resource.Error("Check Internet Connection"))
        }
    } catch (ex: Exception) {
      heroesData.postValue(Resource.Error(ex.message.toString()))
    }
  }

  fun saveHeroes(heroesList: List<Result>) = viewModelScope.launch {
    saveHeroesListUseCase.execute(heroesList)
  }

  fun getSavedHeroes() = liveData {
    getSavedHeroesListUseCase.execute().collect {
      emit(it)
    }
  }

  fun deleteSavedHeroes(hero: Result) = viewModelScope.launch {
    deleteSavedHeroUseCase.execute(hero)
  }

  fun getFavoriteCharacters() = liveData {
    getFavoriteCharactersUseCase.execute().collect {
      emit(it)
    }
  }

  fun saveFavoriteCharacters(favoriteCharacter: FavoriteCharacter) = viewModelScope.launch {
    saveFavoriteCharactersUseCase.execute(favoriteCharacter)
  }

}
