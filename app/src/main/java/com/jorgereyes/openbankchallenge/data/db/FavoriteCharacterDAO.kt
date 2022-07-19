package com.jorgereyes.openbankchallenge.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDAO {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertFavoriteCharacter(favoriteCharacter: FavoriteCharacter)

  @Query("SELECT * FROM fav_character")
  fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>>
}
