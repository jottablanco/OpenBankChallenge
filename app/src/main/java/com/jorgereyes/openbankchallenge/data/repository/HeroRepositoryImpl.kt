package com.jorgereyes.openbankchallenge.data.repository

import com.jorgereyes.openbankchallenge.data.model.APIResponse
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroLocalDataSource
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroRemoteDataSource
import com.jorgereyes.openbankchallenge.data.util.Resource
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class HeroRepositoryImpl (
  private val heroRemoteDataSource: HeroRemoteDataSource,
  private val heroLocalDataSource: HeroLocalDataSource
) : HeroesRepository {
  override suspend fun getHeroesList(page: Int): Resource<APIResponse> {
    return responseToResource(heroRemoteDataSource.getHeroesFromAPI(page))
  }

  override suspend fun saveHeroes(heroesList: List<Result>) {
    heroLocalDataSource.saveHeroesToDB(heroesList)
  }

  override suspend fun deleteHero(result: Result) {
    heroLocalDataSource.deleteHeroFromDB(result)
  }

  override suspend fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>> {
    return heroLocalDataSource.getFavoriteCharacters()
  }

  override suspend fun saveFavoriteCharacter(favoriteCharacter: FavoriteCharacter) {
    heroLocalDataSource.saveFavoriteCharacter(favoriteCharacter)
  }

  override fun getSavedHeroes(): Flow<List<Result>> {
    return heroLocalDataSource.getSavedHeroes()
  }

  private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
    if (response.isSuccessful) {
      response.body()?.let {
        return Resource.Success(it)
      }
    }
    return Resource.Error(response.message())
  }

}
