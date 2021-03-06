package com.michaldrabik.network.trakt.model

data class Show(
  val ids: Ids,
  val title: String,
  val year: Int,
  val overview: String,
  val firstAired: String,
  val runtime: Int,
  val airTime: AirTime,
  val certification: String,
  val network: String,
  val country: String,
  val trailer: String,
  val homepage: String,
  val status: String,
  val rating: Float,
  val votes: Long,
  val commentCount: Long,
  val genres: List<String>,
  val airedEpisodes: Int
)
