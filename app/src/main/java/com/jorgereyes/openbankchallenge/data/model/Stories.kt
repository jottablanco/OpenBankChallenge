package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Stories(
  @SerializedName("available")
  val storiesAvailable: Int,
  @SerializedName("collectionURI")
  val storiesCollectionURI: String,
  @Embedded
  @SerializedName("items")
  val storiesItems: List<Item>,
  @SerializedName("returned")
  val storiesReturned: Int
)
