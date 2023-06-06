package com.elewa.thmanyahpodcast.modules.playlist.di


import com.elewa.thmanyahpodcast.modules.playlist.data.repository.PlayListRepositoryImpl
import com.elewa.thmanyahpodcast.modules.playlist.domain.repository.PlayListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class PlayListModule {
    @Binds
    @ViewModelScoped
    abstract fun bindImagesRepository(impl: PlayListRepositoryImpl): PlayListRepository
}