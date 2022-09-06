package com.jorgereyes.openbankchallenge.data.api

import com.jorgereyes.openbankchallenge.BuildConfig
import com.jorgereyes.openbankchallenge.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MarvelAPIService {

  @GET("v1/public/characters")
  @Headers(HEADER_ACCEPT_JSON)
  suspend fun getMarvelCharacters(
    @Query("ts") timeStamp: String,
    @Query("apikey") apiKey: String = BuildConfig.API_KEY,
    @Query("hash") hash: String,
    @Query("orderBy") orderBy: String,
    @Query("offset") offset: Int,
    @Query("limit") limit:Int
  ): Response<APIResponse>

  companion object {
    private const val HEADER_ACCEPT_JSON = "Accept: application/json"

  }


}
