package com.elewa.thmanyahpodcast.modules.home.data.model

import com.google.gson.annotations.SerializedName

data class PlayListData(
    @SerializedName("playlist")
    val playlist: Playlist,
    @SerializedName("episodes")
    val episodes: List<Episodes>,
)