package com.example.gamesystest.remote.service

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.data.source.RemoteDataSource
import com.example.gamesystest.remote.api.CountryApi
import com.example.gamesystest.remote.mapper.toData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiService @Inject constructor(
    private val countryApi: CountryApi
): RemoteDataSource {

    override fun getAllCountries(apiKey: String): Flow<List<CountryResponseData>> {
        return flow {
            val response = countryApi.getAllCountries(apiKey)
            emit(response.map { it.toData() })
        }
    }
}