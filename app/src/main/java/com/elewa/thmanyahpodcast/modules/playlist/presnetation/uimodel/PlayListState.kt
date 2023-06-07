package com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel

import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import java.util.Objects


sealed class PlayListState {
    object Idle : PlayListState()
    data class Loading(val loading: Boolean = false) : PlayListState()

    data class playListLoaded(val data: PlayListEntity) : PlayListState()


    val error: Throwable? = null

}
