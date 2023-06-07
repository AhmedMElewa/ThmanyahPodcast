package com.elewa.thmanyahpodcast.modules.playlist.presnetation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elewa.thmanyahpodcast.R
import com.elewa.thmanyahpodcast.modules.playlist.domain.interceptro.GetPlayListUseCase
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListSideEffects
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel @Inject constructor(
    private val getPlayListUseCase: GetPlayListUseCase
) : ViewModel() {

    private val _playListState = MutableStateFlow<PlayListState>(PlayListState.Idle)
    val playListState: StateFlow<PlayListState>
        get() = _playListState

    val uiEffects = MutableSharedFlow<PlayListSideEffects>(0)

    init {
        getPlayList()
    }

    fun getPlayList() {
        viewModelScope.launch(Dispatchers.IO) {
            _playListState.emit(PlayListState.Loading(true))
            try {
                _playListState.emit(PlayListState.playListLoaded(data = getPlayListUseCase.execute(null)))
            } catch (e: IOException) {
                e.handleError()
            } catch (e: Exception) {
                e.handleError()
            }

        }
    }

    private fun updateEffect(effect: PlayListSideEffects) {
        viewModelScope.launch {
            uiEffects.emit(effect)
        }
    }

    private fun Throwable.handleError() {
        when (this@handleError) {
            is IOException -> updateEffect(PlayListSideEffects.Error(R.string.no_internet))
            else -> updateEffect(PlayListSideEffects.Error(R.string.generic_error))
        }
    }


}