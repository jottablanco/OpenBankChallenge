package com.jorgereyes.openbankchallenge.domain.repository

import com.jorgereyes.openbankchallenge.data.model.APIResponse
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface HeroesRepository {

  suspend fun getHeroesList(): Resource<APIResponse>
  suspend fun saveHeroes(heroesList: List<Result>)
  suspend fun deleteHero(result: Result)
  suspend fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>>
  suspend fun saveFavoriteCharacter(favoriteCharacter: FavoriteCharacter)
  fun getSavedHeroes(): Flow<List<Result>>
}
