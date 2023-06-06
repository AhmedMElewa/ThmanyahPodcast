package com.elewa.thmanyahpodcast.modules.playlist.data.model

import com.google.gson.annotations.SerializedName

data class Episodes(
    @SerializedName("id")
    val id: String,
    @SerializedName("itunesId")
    val itunesId: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageBigger")
    val imageBigger: String,
    @SerializedName("audioLink")
    val audioLink: String,
    @SerializedName("duration")
    val duration: Long,
    @SerializedName("durationInSeconds")
    val durationInSeconds: Long,
    @SerializedName("views")
    val views: Long,
    @SerializedName("podcastItunesId")
    val podcastItunesId: String,
    @SerializedName("podcastName")
    val podcastName: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("isDeleted")
    val isDeleted: String,
    @SerializedName("isEditorPick")
    val isEditorPick: Boolean,
    @SerializedName("sentNotification")
    val sentNotification: Boolean,
    @SerializedName("position")
    val position: Int
)