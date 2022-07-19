package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Series(
  @SerializedName("available")
  val seriesAvailable: Int,
  @SerializedName("collectionURI")
  val seriesCollectionURI: String,
  @Embedded
  @SerializedName("items")
  val seriesItems: List<Item>,
  @SerializedName("returned")
  val seriesReturned: Int
)
