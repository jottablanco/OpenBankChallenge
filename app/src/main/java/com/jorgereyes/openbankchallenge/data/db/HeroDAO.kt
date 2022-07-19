package com.jorgereyes.openbankchallenge.data.db

import androidx.room.*
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDAO {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertHeroes(result: List<Result>) : Void

  @Query("SELECT * FROM characters")
  fun getAllHeroes(): Flow<List<Result>>

  @Query("SELECT * FROM characters WHERE characterId=:id")
  fun getCharacterDetail(id: Int): Flow<Result>

  @Delete
  fun deleteHero(result: Result)

}
