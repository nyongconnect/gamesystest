package com.example.gamesystest.cache.source

import com.example.gamesystest.cache.mapper.toData
import com.example.gamesystest.cache.mapper.toLocal
import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.data.source.CacheDataSource
import com.example.gamesystest.db.CountryDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
        private val database : CountryDataBase
): CacheDataSource
{
    override suspend fun getCountryFromDb(): Flow<List<CountryResponseData>> {
        return flow {
            val result =  database.countryDao().getCountriesFromDb()
            emit(result.map { it.toData() })
        }
    }

    override suspend fun addCountryToDb(countryData: List<CountryResponseData>) {
        return database.countryDao().addToCountriesToDb(countryData.map { it.toLocal() })
    }
}