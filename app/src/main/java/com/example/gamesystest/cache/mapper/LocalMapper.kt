package com.example.gamesystest.cache.mapper

import com.example.gamesystest.cache.typeconverter.CountryLocal
import com.example.gamesystest.cache.typeconverter.CurrencyLocal
import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.data.models.CurrencyData
import com.example.gamesystest.domain.models.CurrencyDomain

fun CountryLocal.toData(): CountryResponseData {
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

fun CurrencyLocal.toData(): CurrencyData {
    return CurrencyData (
        code,
        name,
        symbol
    )
}

fun CountryResponseData.toLocal(): CountryLocal {
    return CountryLocal(
        alpha2Code,
        alpha3Code,
        altSpellings,
        area,
        borders,
        callingCodes,
        capital,
        currencies.map { it.toLocal() },
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

fun CurrencyData.toLocal(): CurrencyLocal {
    return CurrencyLocal (
        code,
        name,
        symbol
    )
}