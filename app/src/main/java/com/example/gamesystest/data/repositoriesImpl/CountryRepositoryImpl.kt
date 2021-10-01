package com.example.gamesystest.data.repositoriesImpl

import com.example.gamesystest.data.mapper.toData
import com.example.gamesystest.data.mapper.toDomain
import com.example.gamesystest.data.source.CacheDataSource
import com.example.gamesystest.data.source.RemoteDataSource
import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.internal.cacheGet
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: CacheDataSource
): CountryRepository {

    override fun getAllCountries(apiKey: String): Flow<List<CountryResponseDomain>> {
        return remoteDataSource.getAllCountries(apiKey).map { it.map { it.toDomain() } }
    }

    override suspend fun addAllCountriesToDb(countryData: List<CountryResponseDomain>) {
        return localDataSource.addCountryToDb(countryData.map { it.toData() })
    }

    override suspend fun getAllCountriesFromDb(): Flow<List<CountryResponseDomain>> {
        return localDataSource.getCountryFromDb().map { it.map { it.toDomain() }}
    }
}