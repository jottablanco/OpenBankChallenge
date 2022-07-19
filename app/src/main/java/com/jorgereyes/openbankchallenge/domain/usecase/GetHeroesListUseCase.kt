package com.jorgereyes.openbankchallenge.domain.usecase

import com.jorgereyes.openbankchallenge.data.model.APIResponse
import com.jorgereyes.openbankchallenge.data.util.Resource
import com.jorgereyes.openbankchallenge.domain.repository.HeroesRepository
import javax.inject.Inject

class GetHeroesListUseCase (private val heroesRepository: HeroesRepository) {

  suspend fun execute(): Resource<APIResponse> {
    return heroesRepository.getHeroesList()
  }
}
