package com.jorgereyes.openbankchallenge.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "characters")
data class Result(
  @PrimaryKey
  @SerializedName("id")
  val characterId: Int,
  @SerializedName("description")
  val characterDescription: String,
  @SerializedName("modified")
  val characterModified: String,
  @SerializedName("name")
  val characterName: String,
  @SerializedName("resourceURI")
  val characterResourceURI: String,
  @Embedded
  @SerializedName("thumbnail")
  val characterThumbnail: Thumbnail
) : Serializable
