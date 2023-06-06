package com.elewa.thmanyahpodcast.modules.playlist.data.model

import com.google.gson.annotations.SerializedName

data class Playlist(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("access")
    val access: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("episodeCount")
    val episodeCount: Long,
    @SerializedName("episodeTotalDuration")
    val episodeTotalDuration: Long,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("isDeleted")
    val isDeleted: String,
    @SerializedName("followingCount")
    val followingCount: Long,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("isSubscribed")
    val isSubscribed: Boolean
)