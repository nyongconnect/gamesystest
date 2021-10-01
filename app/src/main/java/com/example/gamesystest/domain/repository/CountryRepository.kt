package com.example.gamesystest.domain.repository

import com.example.gamesystest.domain.models.CountryResponseDomain
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getAllCountries(apiKey: String) : Flow<List<CountryResponseDomain>>

    suspend fun getAllCountriesFromDb(): Flow<List<CountryResponseDomain>>

    suspend fun addAllCountriesToDb(countryData: List<CountryResponseDomain>)
}