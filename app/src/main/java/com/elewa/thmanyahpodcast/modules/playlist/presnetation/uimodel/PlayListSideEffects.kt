package com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel

import androidx.annotation.StringRes

sealed class PlayListSideEffects {

    data class Error(@StringRes val message: Int) : PlayListSideEffects()

}
