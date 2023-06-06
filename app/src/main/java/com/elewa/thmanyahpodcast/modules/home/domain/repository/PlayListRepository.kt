package com.elewa.thmanyahpodcast.modules.home.domain.repository

import com.elewa.thmanyahpodcast.modules.home.domain.entity.PlayListEntity

interface PlayListRepository {
    suspend fun getPlayList(): PlayListEntity
}