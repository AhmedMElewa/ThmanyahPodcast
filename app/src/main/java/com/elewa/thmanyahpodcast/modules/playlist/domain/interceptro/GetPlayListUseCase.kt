package com.elewa.thmanyahpodcast.modules.playlist.domain.interceptro

import com.elewa.thmanyahpodcast.base.BaseUseCase
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.playlist.domain.repository.PlayListRepository
import javax.inject.Inject

class GetPlayListUseCase @Inject constructor(private val repository: PlayListRepository) :
    BaseUseCase<Nothing, PlayListEntity> {

    override suspend fun execute(params: Nothing?): PlayListEntity {
        return repository.getPlayList()
    }


}