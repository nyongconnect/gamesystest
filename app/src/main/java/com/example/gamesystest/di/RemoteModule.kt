package com.example.gamesystest.di

import com.example.gamesystest.data.source.RemoteDataSource
import com.example.gamesystest.remote.service.ApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteModule {
    @Binds
    @Singleton
    abstract fun remoteDataSource(remoteDataSourceImpl: ApiService): RemoteDataSource
}