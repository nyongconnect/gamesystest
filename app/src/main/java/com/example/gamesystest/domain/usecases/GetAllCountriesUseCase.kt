package com.example.gamesystest.domain.usecases

import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
): FlowUseCase<List<CountryResponseDomain>, String>() {

    override suspend fun buildFlowUseCase(params: String?): Flow<List<CountryResponseDomain>> {
        return countryRepository.getAllCountries(params?: "")
    }
}