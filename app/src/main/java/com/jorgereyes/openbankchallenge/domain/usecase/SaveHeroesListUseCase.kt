package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import javax.inject.Inject

class SaveHeroesListUseCase (private val heroesRepository: HeroesRepository) {
  suspend fun execute(heroesList: List<Result>) = heroesRepository.saveHeroes(heroesList)
}
