package com.example.gamesystest.domain.usecases

import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesFromDb @Inject constructor(
    private val countryRepository: CountryRepository
): FlowUseCase<List<CountryResponseDomain>, Unit>() {

    override suspend fun buildFlowUseCase(params: Unit?): Flow<List<CountryResponseDomain>> {
        return countryRepository.getAllCountriesFromDb()
    }
}