package com.example.gamesystest.di

import com.example.gamesystest.data.repositoriesImpl.CountryRepositoryImpl
import com.example.gamesystest.domain.repository.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MovieModule {

    @Binds
    abstract fun dataRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository
}