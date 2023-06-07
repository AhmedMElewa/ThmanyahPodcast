package com.elewa.thmanyahpodcast.modules.playlist.data.mapper

import com.elewa.thmanyahpodcast.modules.playlist.data.model.ApiResponse
import com.elewa.thmanyahpodcast.modules.playlist.data.model.Episodes
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.EpisodeEntity
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity

fun ApiResponse.toEntity() = PlayListEntity(
    id = data.playlist.id,
    name = data.playlist.name,
    description = data.playlist.description,
    image = data.playlist.image,
    episodeCount = data.playlist.episodeCount,
    episodeTotalDuration = data.playlist.episodeTotalDuration,
    createdAt = data.playlist.createdAt,
    followingCount = data.playlist.followingCount,
    episodes = data.episodes.map { it.toEntity() }
)

fun Episodes.toEntity() = EpisodeEntity(
    id = id,
    name = name,
    description = description,
    image = image,
    imageBigger = imageBigger,
    audioLink = audioLink,
    duration = duration,
    durationInSeconds = durationInSeconds,
    views = views,
    podcastName = podcastName,
    releaseDate = releaseDate,

    )