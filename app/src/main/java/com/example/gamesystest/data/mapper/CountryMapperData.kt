package com.example.gamesystest.data.mapper

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.domain.models.CountryResponseDomain

fun CountryResponseData.toDomain(): CountryResponseDomain {
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

fun CountryResponseDomain.toData(): CountryResponseData {
    return CountryResponseData(
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
