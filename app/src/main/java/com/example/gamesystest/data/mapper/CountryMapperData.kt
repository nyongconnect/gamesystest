package com.example.gamesystest.data.mapper

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.data.models.CurrencyData
import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.models.CurrencyDomain
import com.example.gamesystest.remote.model.CurrencyResponse

fun CountryResponseData.toDomain(): CountryResponseDomain {
    return CountryResponseDomain(
        alpha2Code,
        alpha3Code,
        altSpellings,
        area,
        borders,
        callingCodes,
        capital,
        currencies.map { it.toDomain() },
        demonym,
        gini,
        latlng,
        name,
        region,
        numericCode,
        population,
        region,
        subregion,
        timezones,
        topLevelDomain,
    )
}

fun CurrencyData.toDomain(): CurrencyDomain {
    return CurrencyDomain (
        code,
        name,
        symbol
    )
}

fun CountryResponseDomain.toData(): CountryResponseData {
    return CountryResponseData(
        alpha2Code,
        alpha3Code,
        altSpellings,
        area,
        borders,
        callingCodes,
        capital,
        currencies.map { it.toData() },
        demonym,
        gini,
        latlng,
        name,
        region,
        numericCode,
        population,
        region,
        subregion,
        timezones,
        topLevelDomain,
    )
}

fun CurrencyDomain.toData(): CurrencyData {
    return CurrencyData (
        code,
        name,
        symbol
    )
}