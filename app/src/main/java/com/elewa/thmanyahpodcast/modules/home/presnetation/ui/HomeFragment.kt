package com.elewa.thmanyahpodcast.modules.home.presnetation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elewa.thmanyahpodcast.R
import com.elewa.thmanyahpodcast.base.BaseFragment
import com.elewa.thmanyahpodcast.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate


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