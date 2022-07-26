package com.jorgereyes.openbankchallenge.data.repository.dataSourceImpl

import android.annotation.SuppressLint
import com.jorgereyes.openbankchallenge.BuildConfig
import com.jorgereyes.openbankchallenge.data.api.MarvelAPIService
import com.jorgereyes.openbankchallenge.data.model.APIResponse
import com.jorgereyes.openbankchallenge.data.repository.datasource.HeroRemoteDataSource
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

class HeroRemoteDataSourceImpl (private val marvelAPIService: MarvelAPIService) : HeroRemoteDataSource {

  override suspend fun getHeroesFromAPI(page: Int): Response<APIResponse> {
    return marvelAPIService.getMarvelCharacters(
      timeStamp = getTimeStamp(),
      hash = md5(getTimeStamp()+(BuildConfig.SECRET)+(BuildConfig.API_KEY)),
      orderBy = CHARACTERS_ORDER_BY,
      offset = page * CHARACTERS_SIZE_PAGE,
      limit = CHARACTERS_SIZE_PAGE
    )
  }

  private fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
  }

  @SuppressLint("SimpleDateFormat")
  private fun getTimeStamp(): String {
    return SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
  }

  companion object {
    const val CHARACTERS_SIZE_PAGE = 50
    const val CHARACTERS_ORDER_BY = "name"
  }
}
