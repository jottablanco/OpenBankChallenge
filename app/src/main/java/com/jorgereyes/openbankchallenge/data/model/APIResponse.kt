package com.jorgereyes.openbankchallenge.data.model

data class APIResponse(
  val attributionHTML: String,
  val attributionText: String,
  val code: Int,
  val copyright: String,
  val data: Data,
  val etag: String,
  val status: String
)

