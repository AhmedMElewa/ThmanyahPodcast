package com.elewa.thmanyahpodcast.modules.playlist.presnetation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.playlist.domain.interceptro.GetPlayListUseCase
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel @Inject constructor(
    private val getPlayListUseCase: GetPlayListUseCase
) : ViewModel() {

    private val _playListState = MutableStateFlow<PlayListState>(PlayListState())
    val playListState: StateFlow<PlayListState>
        get() = _playListState


}