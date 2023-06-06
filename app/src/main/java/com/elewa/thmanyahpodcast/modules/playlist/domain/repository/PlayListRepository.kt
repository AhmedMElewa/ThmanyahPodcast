package com.elewa.thmanyahpodcast.modules.playlist.domain.repository

import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity

interface PlayListRepository {
    suspend fun getPlayList(): PlayListEntity
}