package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteCharactersUseCase (private val heroesRepository: HeroesRepository) {

  suspend fun execute(): Flow<List<FavoriteCharacter>> {
    return heroesRepository.getFavoriteCharacters()
  }
}
