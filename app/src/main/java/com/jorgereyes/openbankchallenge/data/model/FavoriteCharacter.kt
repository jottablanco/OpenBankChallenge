package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "fav_character")
data class FavoriteCharacter(
  @PrimaryKey
  @SerializedName("id")
  val favoriteCharacterId: Int,
  @SerializedName("description")
  val favoriteCharacterDescription: String,
  @SerializedName("modified")
  val favoriteCharacterModified: String,
  @SerializedName("name")
  val favoriteCharacterName: String,
  @SerializedName("resourceURI")
  val favoriteCharacterResourceURI: String,
  @Embedded
  @SerializedName("thumbnail")
  val favoriteCharacterThumbnail: Thumbnail
): Serializable
