package com.elewa.thmanyahpodcast.modules.playlist.presnetation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.elewa.thmanyahpodcast.base.BaseFragment
import com.elewa.thmanyahpodcast.core.extention.toGone
import com.elewa.thmanyahpodcast.core.extention.toVisible
import com.elewa.thmanyahpodcast.databinding.FragmentPlaylistBinding
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.PlayListEntity
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.adapter.PlayListAdapter
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListSideEffects
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.uimodel.PlayListState
import com.elewa.thmanyahpodcast.modules.playlist.presnetation.viewmodel.PlayListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PlayListFragment : BaseFragment<FragmentPlaylistBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlaylistBinding
        get() = FragmentPlaylistBinding::inflate

    private val viewModel: PlayListViewModel by viewModels()

    @Inject
    lateinit var adapter: PlayListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObservation()
        initEffectObservation()
    }

    private fun initView() {}
    private fun initObservation() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.playListState.collect { state ->
                    when (state) {
                        is PlayListState.Idle -> {
                            binding.layoutLoading.clLoading.toGone()
                            binding.layoutError.clError.toGone()
                            binding.cardRec.toGone()
                            binding.cardImage.toGone()
                        }

                        is PlayListState.Loading -> {
                            if (state.loading) {
                                binding.layoutLoading.clLoading.toVisible()
                            }
                        }

                        is PlayListState.playListLoaded -> {
                            binding.layoutLoading.clLoading.toGone()
                            binding.layoutError.clError.toGone()
                            binding.cardRec.toVisible()
                            binding.cardImage.toVisible()
                            binding.recPlayList.toVisible()
                            adapter.submitList(state.data.episodes)
                            setView(state.data)
                            binding.recPlayList.adapter = adapter
                        }
                    }
                }
            }
        }
    }

    private fun initEffectObservation() {
        lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEffects.collectLatest { effect ->
                    when (effect) {
                        is PlayListSideEffects.Error -> {
                            binding.layoutError.clError.toVisible()
                            binding.layoutError.tvError.setText(effect.message)
                        }
                    }
                }
            }

        }
    }

    private fun setView(playListEntity: PlayListEntity) {
        Glide.with(requireActivity())
            .load(playListEntity.image)
            .into(binding.imgMedia);
        binding.txtPlayListHeader.text = playListEntity.name
        binding.txtPlayDesc.text = playListEntity.description
        binding.txtEpoCount.text =
            "${playListEntity.episodeCount} حلقة . ${playListEntity.episodeTotalDuration / 60 / 60} ساعه"

    }

}