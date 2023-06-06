package com.elewa.thmanyahpodcast.modules.home.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val data: PlayListData,
)