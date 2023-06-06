package com.elewa.thmanyahpodcast.modules.playlist.presnetation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elewa.thmanyahpodcast.base.BaseFragment
import com.elewa.thmanyahpodcast.databinding.FragmentPlaylistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayListFragment : BaseFragment<FragmentPlaylistBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlaylistBinding
        get() = FragmentPlaylistBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObservation()
        initListeners()
    }

    private fun initView() {}
    private fun initObservation() {}
    private fun initListeners() {}
}