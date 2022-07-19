package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository

class SaveFavoriteCharactersUseCase (private val heroesRepository: HeroesRepository) {
  suspend fun execute(favoriteCharacter: FavoriteCharacter) = heroesRepository.saveFavoriteCharacter(favoriteCharacter)
}
