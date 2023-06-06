package com.elewa.thmanyahpodcast.modules.home.data.repository

import com.elewa.thmanyahpodcast.modules.home.data.mapper.toEntity
import com.elewa.thmanyahpodcast.modules.home.data.source.PlayListDS
import com.elewa.thmanyahpodcast.modules.home.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.home.domain.repository.PlayListRepository
import javax.inject.Inject

class PlayListRepositoryImpl
@Inject constructor(
    private val dataSource: PlayListDS,
) : PlayListRepository {


    override suspend fun getPlayList(): PlayListEntity {
        return dataSource.loadPlayList().toEntity()
    }


}