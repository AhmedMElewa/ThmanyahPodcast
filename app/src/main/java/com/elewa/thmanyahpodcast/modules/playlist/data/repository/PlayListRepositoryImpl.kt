package com.elewa.thmanyahpodcast.modules.playlist.data.repository

import com.elewa.thmanyahpodcast.modules.playlist.data.mapper.toEntity
import com.elewa.thmanyahpodcast.modules.playlist.data.source.PlayListDS
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.playlist.domain.repository.PlayListRepository
import javax.inject.Inject

class PlayListRepositoryImpl
@Inject constructor(
    private val dataSource: PlayListDS,
) : PlayListRepository {


    override suspend fun getPlayList(): PlayListEntity {
        return dataSource.loadPlayList().toEntity()
    }


}