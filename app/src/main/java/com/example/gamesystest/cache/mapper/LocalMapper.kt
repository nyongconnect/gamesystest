package com.example.gamesystest.cache.mapper

import com.example.gamesystest.cache.typeconverter.CountryLocal
import com.example.gamesystest.data.models.CountryResponseData

fun CountryLocal.toData(): CountryResponseData {
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

fun CountryResponseData.toLocal(): CountryLocal {
    return CountryLocal(
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