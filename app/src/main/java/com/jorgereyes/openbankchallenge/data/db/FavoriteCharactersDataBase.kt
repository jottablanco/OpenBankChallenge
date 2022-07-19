package com.jorgereyes.openbankchallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter

@Database(
  entities = [FavoriteCharacter::class],
  version = 1,
  exportSchema = false
)
abstract class FavoriteCharactersDataBase: RoomDatabase() {

  abstract fun getFavoriteCharactersDAO(): FavoriteCharacterDAO
}
