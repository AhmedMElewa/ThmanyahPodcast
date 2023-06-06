package com.elewa.thmanyahpodcast.modules.home.data.source

import android.content.Context
import android.util.Log
import com.elewa.thmanyahpodcast.modules.home.data.model.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject


class PlayListDS @Inject constructor(
    private val gson: Gson,
    @ApplicationContext
    val context: Context
) {

    fun loadPlayList(): ApiResponse {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("api.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Timber.d(ioException)
        }

        val listCountryType = object : TypeToken<List<ApiResponse>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }

}