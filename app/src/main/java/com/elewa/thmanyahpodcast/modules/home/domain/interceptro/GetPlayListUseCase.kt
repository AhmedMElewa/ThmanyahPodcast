package com.elewa.thmanyahpodcast.modules.home.domain.interceptro

import com.elewa.thmanyahpodcast.base.BaseUseCase
import com.elewa.thmanyahpodcast.modules.home.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.home.domain.repository.PlayListRepository
import javax.inject.Inject

class GetPlayListUseCase @Inject constructor(private val repository: PlayListRepository) :
    BaseUseCase<Nothing, PlayListEntity> {

    override suspend fun execute(params: Nothing?): PlayListEntity {
        return repository.getPlayList()
    }


}