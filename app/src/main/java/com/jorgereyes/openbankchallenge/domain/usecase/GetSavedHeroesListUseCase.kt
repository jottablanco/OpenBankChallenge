package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedHeroesListUseCase (private val heroesRepository: HeroesRepository) {
  fun execute(): Flow<List<Result>> {
    return heroesRepository.getSavedHeroes()
  }
}
