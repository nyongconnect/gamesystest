package com.example.gamesystest.presentation.mapper

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.presentation.model.Country

fun CountryResponseDomain.toPresentation(): Country {
    return Country(
        alpha2Code,
        alpha3Code,
        altSpellings,
        callingCodes,
        capital,
        name,
        region,
        topLevelDomain
    )
}

fun Country.toDomain(): CountryResponseDomain {
    return CountryResponseDomain(
        alpha2Code,
        alpha3Code,
        altSpellings,
        callingCodes,
        capital,
        name,
        region,
        topLevelDomain
    )
}
