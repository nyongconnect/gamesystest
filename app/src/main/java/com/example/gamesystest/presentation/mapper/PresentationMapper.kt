package com.example.gamesystest.presentation.mapper

import com.example.gamesystest.data.models.CurrencyData
import com.example.gamesystest.domain.models.CountryResponseDomain
import com.example.gamesystest.domain.models.CurrencyDomain
import com.example.gamesystest.presentation.model.Country
import com.example.gamesystest.presentation.model.Currency
import com.example.gamesystest.remote.model.CurrencyResponse

fun CountryResponseDomain.toPresentation(): Country {
    return Country(
        alpha2Code,
        alpha3Code,
        altSpellings,
        area,
        borders,
        callingCodes,
        capital,
        currencies.map { it.toPresentation() },
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

fun CurrencyDomain.toPresentation(): Currency {
    return Currency (
        code,
        name,
        symbol
    )
}

fun Country.toDomain(): CountryResponseDomain {
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

fun Currency.toDomain(): CurrencyDomain {
    return CurrencyDomain (
        code,
        name,
        symbol
    )
}