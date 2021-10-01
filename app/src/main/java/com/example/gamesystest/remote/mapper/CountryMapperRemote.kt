package com.example.gamesystest.remote.mapper

import com.example.gamesystest.data.models.CountryResponseData
import com.example.gamesystest.data.models.CurrencyData
import com.example.gamesystest.remote.model.CountryResponse
import com.example.gamesystest.remote.model.CurrencyResponse

fun CountryResponse.toData(): CountryResponseData {
    return CountryResponseData(
        alpha2Code?: "",
        alpha3Code?: "",
        altSpellings?: emptyList(),
        area?: 0.0,
        borders?: emptyList(),
        callingCodes?: emptyList(),
        capital?: "",
        currencies?.map { it.toData() }?: emptyList(),
        demonym?: "",
        gini?: 0.0,
        latlng?: emptyList(),
        name?:"",
        region?: "",
        numericCode?:"",
        population?: 0,
        region?: "",
        subregion?: "",
        timezones?: emptyList(),
        topLevelDomain?: emptyList(),
    )
}

fun CurrencyResponse.toData(): CurrencyData {
    return CurrencyData (
        code?: "",
        name?: "",
        symbol?: ""
    )
}