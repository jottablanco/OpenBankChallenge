package com.jorgereyes.openbankchallenge.data.repository.datasource

import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import kotlinx.coroutines.flow.Flow

interface HeroLocalDataSource {
  suspend fun saveHeroesToDB(heroesList: List<Result>)
  fun getSavedHeroes(): Flow<List<Result>>
  fun getHeroDetails(id: Int): Flow<Result>
  fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>>
  fun saveFavoriteCharacter(favoriteCharacter: FavoriteCharacter)
  suspend fun deleteHeroFromDB(result: Result)
}
