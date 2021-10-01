package com.example.gamesystest.remote.mapper

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.remote.model.CountryResponse

fun CountryResponse.toData(): CountryResponseData {
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