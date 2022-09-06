package com.jorgereyes.openbankchallenge.data.repository.datasource

import com.jorgereyes.openbankchallenge.data.model.APIResponse
import retrofit2.Response

interface HeroRemoteDataSource {
  suspend fun getHeroesFromAPI(page: Int): Response<APIResponse>
}
