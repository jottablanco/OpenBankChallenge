package com.jorgereyes.openbankchallenge.data.model

data class Item(
  val name: String,
  val resourceURI: String,
  val type: String? = ""
)
