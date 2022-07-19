package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comics(
  @SerializedName("available")
  val availableComics: Int,
  @SerializedName("collectionURI")
  val comicsCollectionURI: String,
  @Embedded
  @SerializedName("items")
  val comicItems: List<Item>,
  @SerializedName("returned")
  val comicsReturned: Int
) : Serializable
