package com.jorgereyes.openbankchallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result

@Database(
  entities = [Result::class],
  version = 1,
  exportSchema = false
)

abstract class HeroesDatabase : RoomDatabase() {
  abstract fun getHeroDAO(): HeroDAO
}
