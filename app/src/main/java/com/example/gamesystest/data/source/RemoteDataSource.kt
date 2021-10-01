package com.example.gamesystest.data.source

import com.example.gamesystest.data.models.CountryResponseData
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {

    fun getAllCountries(apiKey: String) : Flow<List<CountryResponseData>>
}