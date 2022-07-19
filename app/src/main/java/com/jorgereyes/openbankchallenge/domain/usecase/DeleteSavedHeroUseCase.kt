package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import javax.inject.Inject

class DeleteSavedHeroUseCase (private val heroesRepository: HeroesRepository) {
  suspend fun execute(result: Result) = heroesRepository.deleteHero(result)
}
