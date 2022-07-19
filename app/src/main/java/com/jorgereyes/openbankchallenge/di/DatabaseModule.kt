package com.jorgereyes.openbankchallenge.di

import android.app.Application
import androidx.room.Room
import com.jorgereyes.openbankchallenge.data.db.FavoriteCharacterDAO
import com.jorgereyes.openbankchallenge.data.db.FavoriteCharactersDataBase
import com.jorgereyes.openbankchallenge.data.db.HeroDAO
import com.jorgereyes.openbankchallenge.data.db.HeroesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

  @Singleton
  @Provides
  fun providesHeroDatabase(app: Application): HeroesDatabase {
    return Room.databaseBuilder(app, HeroesDatabase::class.java, "heroes_db")
      .fallbackToDestructiveMigration()
      .allowMainThreadQueries()
      .build()
  }

  @Singleton
  @Provides
  fun providesFavoritesDatabase(app: Application): FavoriteCharactersDataBase {
    return Room.databaseBuilder(app, FavoriteCharactersDataBase::class.java, "fav_heroes_db")
      .fallbackToDestructiveMigration()
      .allowMainThreadQueries()
      .build()
  }

  @Singleton
  @Provides
  fun provideHeroDAO(heroesDatabase: HeroesDatabase): HeroDAO {
    return heroesDatabase.getHeroDAO()
  }

  @Singleton
  @Provides
  fun provideFavoriteCharacterDAO(favCharactersDatabase: FavoriteCharactersDataBase): FavoriteCharacterDAO {
    return favCharactersDatabase.getFavoriteCharactersDAO()
  }
}
