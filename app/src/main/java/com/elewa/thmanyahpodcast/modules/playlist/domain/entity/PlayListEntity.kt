package com.elewa.thmanyahpodcast.modules.playlist.domain.entity

data class PlayListEntity(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val episodeCount: Long,
    val episodeTotalDuration: Long,
    val createdAt: String,
    val followingCount: Long,
    val episodes: List<EpisodeEntity>
)