package com.example.gamesystest.data.source

import javax.inject.Inject


class DataSourceFactory @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: CacheDataSource
) {

    fun remote(): RemoteDataSource = remoteDataSource
    fun cache(): CacheDataSource = cacheDataSource
}