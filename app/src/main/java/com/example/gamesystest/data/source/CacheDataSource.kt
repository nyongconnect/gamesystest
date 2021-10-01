package com.example.gamesystest.data.source

import com.example.gamesystest.data.models.CountryResponseData
import kotlinx.coroutines.flow.Flow

interface CacheDataSource {

    suspend fun addCountryToDb(countryData: List<CountryResponseData>)

    suspend fun getCountryFromDb(): Flow<List<CountryResponseData>>
}