package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Events(
  @SerializedName("available")
  val eventsAvailable: Int,
  @SerializedName("collectionURI")
  val eventsCollectionURI: String,
  @Embedded
  @SerializedName("items")
  val eventsItems: List<Item>,
  @SerializedName("returned")
  val eventsReturned: Int
)
