package com.example.gamesystest.domain.usecases

import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AddCountriesToDbUseCase @Inject constructor(
    private val countryRepository: CountryRepository
): FlowUseCase<Unit, List<CountryResponseDomain>>() {

    override suspend fun buildFlowUseCase(params: List<CountryResponseDomain>?): Flow<Unit> {
        return flowOf(countryRepository.addAllCountriesToDb(params?: emptyList()))
    }
}