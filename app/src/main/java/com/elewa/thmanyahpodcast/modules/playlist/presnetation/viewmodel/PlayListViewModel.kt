package com.elewa.thmanyahpodcast.modules.playlist.presnetation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.playlist.domain.interceptro.GetPlayListUseCase
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel @Inject constructor(
    private val getPlayListUseCase: GetPlayListUseCase
) : ViewModel() {

    private val _playListState = MutableStateFlow<PlayListState>(PlayListState())
    val playListState: StateFlow<PlayListState>
        get() = _playListState

    init {
        getPlayList()
    }

    fun getPlayList() {
        viewModelScope.launch(Dispatchers.IO) {
            _playListState.emit(PlayListState(isLoading = true))
            try {
                _playListState.emit(PlayListState(data = getPlayListUseCase.execute(null)))
            } catch (e: IOException) {
                _playListState.emit(PlayListState(error = e))
            } catch (e: Exception) {
                _playListState.emit(PlayListState(error = e))
            }

        }
    }


}