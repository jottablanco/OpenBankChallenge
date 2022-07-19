package com.jorgereyes.openbankchallenge.data.api

import com.jorgereyes.openbankchallenge.BuildConfig
import com.jorgereyes.openbankchallenge.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPIService {

  @GET("v1/public/characters")
  suspend fun getMarvelCharacters(
    @Query("limit")
    limit:String = "100",
    @Query("ts")
    timeStamp: String,
    @Query("apikey")
    apiKey: String = BuildConfig.API_KEY,
    @Query("hash")
    hash: String
  ): Response<APIResponse>


}
