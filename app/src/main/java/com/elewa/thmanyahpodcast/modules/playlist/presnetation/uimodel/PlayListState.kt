package com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel

import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity


data class PlayListState(
    val isLoading: Boolean = false,
    val data: PlayListEntity? = null,
    val error: Throwable? = null
)