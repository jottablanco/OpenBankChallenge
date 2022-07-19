package com.jorgereyes.openbankchallenge.data.repository.dataSourceImpl

import com.jorgereyes.openbankchallenge.data.db.FavoriteCharacterDAO
import com.jorgereyes.openbankchallenge.data.db.HeroDAO
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroLocalDataSource
import kotlinx.coroutines.flow.Flow

class HeroLocalDataSourceImpl (private val heroDAO: HeroDAO, private val favoriteCharacterDAO: FavoriteCharacterDAO) : HeroLocalDataSource {
  override suspend fun saveHeroesToDB(heroesList: List<Result>) {
    heroDAO.insertHeroes(heroesList)
  }

  override fun getSavedHeroes(): Flow<List<Result>> {
    return heroDAO.getAllHeroes()
  }

  override fun getHeroDetails(id: Int): Flow<Result> {
    return heroDAO.getCharacterDetail(id)
  }

  override fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>> {
    return favoriteCharacterDAO.getFavoriteCharacters()
  }

  override fun saveFavoriteCharacter(favoriteCharacter: FavoriteCharacter) {
    favoriteCharacterDAO.insertFavoriteCharacter(favoriteCharacter)
  }

  override suspend fun deleteHeroFromDB(result: Result) {
    heroDAO.deleteHero(result)
  }



}
