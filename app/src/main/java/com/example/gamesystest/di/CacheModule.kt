package com.example.gamesystest.di

import android.content.Context
import androidx.room.Room
import com.example.gamesystest.cache.source.LocalDataSourceImpl
import com.example.gamesystest.data.source.CacheDataSource
import com.example.gamesystest.db.CountryDataBase
import com.example.gamesystest.utils.AppConstant.DATABASE_NAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun localDataSource(localDataSourceImpl: LocalDataSourceImpl): CacheDataSource
}


@Module
@InstallIn(ApplicationComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun dataBase(@ApplicationContext context: Context) : CountryDataBase {

        return Room.databaseBuilder(
            context,
            CountryDataBase::class.java, DATABASE_NAME
        ).build()
    }
}