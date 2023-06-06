package com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel


data class PlayListState(
    val isLoading: Boolean = false,
    val data: PlayListState? = null,
    val error: Throwable? = null
)